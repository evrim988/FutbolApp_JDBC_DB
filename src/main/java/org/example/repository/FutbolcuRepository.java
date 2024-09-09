package org.example.repository;

import org.example.entites.Futbolcu;
import org.example.utility.EMevki;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FutbolcuRepository implements ICrud<Futbolcu>{

    private final DatabaseHelper databaseHelper;
    private String sql;

    public FutbolcuRepository() {
        this.databaseHelper = new DatabaseHelper();
    }

    @Override
    public void save(Futbolcu futbolcu) {
        sql = "INSERT INTO futbolcu(takim_id, ad, soyad, dogum_tarihi, mevki, formaNumarasi, yetenekPuani) " +
                "VALUES (%d, '%s', '%s', '%s', '%s', %d, %d)"
                        .formatted(futbolcu.getTakimID(), futbolcu.getAd(), futbolcu.getSoyad(), futbolcu.getDogum_tarihi(), futbolcu.getMevki(), futbolcu.getFormaNumarasi(), futbolcu.getYetenekpuan());
        databaseHelper.executeUpdate(sql);

    }

    @Override
    public void softDelete(int silinecekFutbolcuId) {
        sql = "UPDATE futbolcu SET state = 0, updateat = EXTRACT(epoch FROM Now()) WHERE id=%d".formatted(silinecekFutbolcuId);
        databaseHelper.executeUpdate(sql);
    }

    @Override
    public void hardDelete(int id) {
        sql = "Delete from futbolcu where id=%d".formatted(id);
        databaseHelper.executeUpdate(sql);
    }

    @Override
    public void update(Futbolcu futbolcu) {
        sql = "UPDATE futbolcu SET takimID = %d, ad = '%s', soyad = '%s', dogum_tarihi = '%s', mevki='%s', formaNumarasi = %d, yetenekPuani='%s', updateat = EXTRACT(epoch FROM Now()) WHERE id= %d"
                .formatted(futbolcu.getTakimID(), futbolcu.getAd(), futbolcu.getSoyad(), futbolcu.getDogum_tarihi(),futbolcu.getMevki(),futbolcu.getFormaNumarasi(),futbolcu.getYetenekpuan(), futbolcu.getId());
        databaseHelper.executeUpdate(sql);
    }

    @Override
    public List<Futbolcu> findAll() {
        sql = "SELECT * FROM futbolcu ORDER BY id DESC";
        Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
        List<Futbolcu> futbolcuList = new ArrayList<>();
        try {
            if(resultSet.isPresent()) {
                ResultSet rs = resultSet.get();
                while (rs.next()) {
                    futbolcuList.add(getValueFromValueSet(rs));
                }
            }
        }
        catch (SQLException e){
            System.out.println("Futbolcuları listelerken hata ile karşılaşıldı..." + e.getMessage());
        }

        return futbolcuList;
    }

    @Override
    public Optional<Futbolcu> findById(int id) {
        sql = "SELECT * FROM futbolcu WHERE id=%d".formatted(id);
        Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
        try{
            if(resultSet.isPresent()) {
                ResultSet rs = resultSet.get();
                if(rs.next()) {
                    return Optional.of(getValueFromValueSet(rs));
                }
            }
        }
        catch (SQLException e){
            System.out.println("Futbolcu bulma sırasında bşr hata ile karşılaşıldı..." + e.getMessage());
        }
        return Optional.empty();
    }

    private Futbolcu getValueFromValueSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int takimID = rs.getInt("takim_id");
        String ad = rs.getString("ad");
        String soyad = rs.getString("soyad");
        String dogum_tarihi = rs.getString("dogum_tarihi");
        String mevki = rs.getString("mevki");
        int formaNumarasi = rs.getInt("formaNumarasi");
        int yetenekpuan = rs.getInt("yetenekPuani");
        int state = rs.getInt("state");
        long createat = rs.getLong("createat");
        long updateat = rs.getLong("updateat");

        return new Futbolcu(id, takimID, ad, soyad, LocalDate.parse(dogum_tarihi), EMevki.valueOf(mevki),formaNumarasi,yetenekpuan,state,createat,updateat);
    }
}
