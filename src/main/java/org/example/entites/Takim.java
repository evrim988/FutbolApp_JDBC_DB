package org.example.entites;

import java.time.LocalDate;

public class Takim extends BaseEntity{

    private int id;
    private String ad;
    private LocalDate kurulusTarihi;
    private String baskan;
    private Double butce;

    public Takim() {

    }

    public Takim(String ad, LocalDate kurulusTarihi, String baskan, Double butce) {
        this.ad = ad;
        this.kurulusTarihi = kurulusTarihi;
        this.baskan = baskan;
        this.butce = butce;
    }

    public Takim(int id, String ad, LocalDate kurulusTarihi, String baskan, Double butce) {
        this.id = id;
        this.ad = ad;
        this.kurulusTarihi = kurulusTarihi;
        this.baskan = baskan;
        this.butce = butce;
    }

    public Takim(int id, String ad, LocalDate kurulusTarihi, String baskan, Double butce, Integer state, Long createat, Long updateat) {
        super(state, createat, updateat);
        this.id = id;
        this.ad = ad;
        this.kurulusTarihi = kurulusTarihi;
        this.baskan = baskan;
        this.butce = butce;
    }

    @Override
    public String toString() {
        return "Takim{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", kurulusTarihi=" + kurulusTarihi +
                ", baskan='" + baskan + '\'' +
                ", butce=" + butce +
                ", state=" + getState() +
                ", createat=" + getCreateat() +
                ", updateat=" + getUpdateat() +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public LocalDate getKurulusTarihi() {
        return kurulusTarihi;
    }

    public void setKurulusTarihi(LocalDate kurulusTarihi) {
        this.kurulusTarihi = kurulusTarihi;
    }

    public String getBaskan() {
        return baskan;
    }

    public void setBaskan(String baskan) {
        this.baskan = baskan;
    }

    public Double getButce() {
        return butce;
    }

    public void setButce(Double butce) {
        this.butce = butce;
    }
}
