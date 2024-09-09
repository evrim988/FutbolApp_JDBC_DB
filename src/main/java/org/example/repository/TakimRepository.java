package org.example.repository;

import org.example.entites.Takim;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TakimRepository implements ICrud<Takim> {

    private final DatabaseHelper databaseHelper;
    private String sql;

    public TakimRepository() {
        this.databaseHelper = new DatabaseHelper();
    }

    @Override
    public void save(Takim takim) {
        sql = "INSERT INTO takim(ad, kurulustarihi, baskan, butce) VALUES ('%s','%s','%s','%s')"
                .formatted(takim.getAd(), takim.getKurulusTarihi(), takim.getBaskan(), takim.getButce());
        databaseHelper.executeUpdate(sql);
    }

    @Override
    public void softDelete(int silinecekTakimId) {
        sql = "UPDATE takim SET state = 0, updateat = EXTRACT(epoch FROM Now()) WHERE id = '%d'".formatted(silinecekTakimId);
        databaseHelper.executeUpdate(sql);
    }

    @Override
    public void hardDelete(int id) {
        sql = "DELETE FROM takim WHERE id = '%d'".formatted(id);
        databaseHelper.executeUpdate(sql);
    }

    @Override
    public void update(Takim takim) {
        sql = "UPDATE takim SET ad='%s', kurulustarihi = '%s', baskan= '%s', butce= '%s', updateat = EXTRACT(epoch FROM Now()) WHERE id = %d".formatted(takim.getAd(), takim.getKurulusTarihi(), takim.getBaskan(), takim.getButce(),takim.getId());
        databaseHelper.executeUpdate(sql);
    }

    @Override
    public List<Takim> findAll() {
        sql = "SELECT * FROM takim ORDER BY id DESC";
        Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
        List<Takim> takimList = new ArrayList<>();
        try {
            if(resultSet.isPresent()) {
                ResultSet rs = resultSet.get();
                while (rs.next()) {
                    takimList.add(getValueFromResultSet(rs));
                }
            }
        }
        catch (SQLException e){
            System.out.println("Takımları listelerken hata ile karşılaşıldı..." + e.getMessage());
        }
        return takimList;
    }

    @Override
    public Optional<Takim> findById(int id) {
        sql = "SELECT * FROM takim WHERE id = '%d'".formatted(id);
        Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
        try{
            if(resultSet.isPresent()) {
                ResultSet rs = resultSet.get();
                if(rs.next()) {
                    return Optional.of(getValueFromResultSet(rs));
                }
            }
        }
        catch (SQLException e){
            System.out.println("Takım bulma sırasında bir hata ile karşılaşıldı..." + e.getMessage());
        }
        return Optional.empty();
    }

    private Takim getValueFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String ad = rs.getString("ad");
        String kurulusTarihi = rs.getString("kurulustarihi");
        String baskan = rs.getString("baskan");
        double butce = rs.getDouble("butce");
        int state = rs.getInt("state");
        long createat = rs.getLong("createat");
        long updateat = rs.getLong("updateat");

        return new Takim(id,ad, LocalDate.parse(kurulusTarihi),baskan,butce,state,createat,updateat);

    }
}
