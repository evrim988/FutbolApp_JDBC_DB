package org.example.entites;

import org.example.utility.EMevki;

import java.time.LocalDate;

public class Futbolcu extends BaseEntity {

    private int id;
    private int takimID;
    private String ad;
    private String soyad;
    private LocalDate dogum_tarihi;
    private EMevki mevki;
    private int formaNumarasi;
    private int yetenekpuan;

    public Futbolcu() {

    }

    public Futbolcu(int takimID, String ad, String soyad, LocalDate dogum_tarihi, EMevki mevki, int formaNumarasi, int yetenekpuan) {
        this.takimID = takimID;
        this.ad = ad;
        this.soyad = soyad;
        this.dogum_tarihi = dogum_tarihi;
        this.mevki = mevki;
        this.formaNumarasi = formaNumarasi;
        this.yetenekpuan = yetenekpuan;
    }

    public Futbolcu(int id, int takimID, String ad, String soyad, LocalDate dogum_tarihi, EMevki mevki, int formaNumarasi, int yetenekpuan) {
        this.id = id;
        this.takimID = takimID;
        this.ad = ad;
        this.soyad = soyad;
        this.dogum_tarihi = dogum_tarihi;
        this.mevki = mevki;
        this.formaNumarasi = formaNumarasi;
        this.yetenekpuan = yetenekpuan;
    }

    public Futbolcu(int id, int takimID, String ad, String soyad, LocalDate dogum_tarihi, EMevki mevki, int formaNumarasi, int yetenekpuan, Integer state, Long createat, Long updateat) {
        super(state, createat, updateat);
        this.id = id;
        this.takimID = takimID;
        this.ad = ad;
        this.soyad = soyad;
        this.dogum_tarihi = dogum_tarihi;
        this.mevki = mevki;
        this.formaNumarasi = formaNumarasi;
        this.yetenekpuan = yetenekpuan;
    }

    @Override
    public String toString() {
        return "Futbolcu{" +
                "id=" + id +
                ", takimID=" + takimID +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", dogum_tarihi=" + dogum_tarihi +
                ", mevki=" + mevki +
                ", formaNumarasi=" + formaNumarasi +
                ", yetenekpuan=" + yetenekpuan +
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

    public int getTakimID() {
        return takimID;
    }

    public void setTakimID(int takimID) {
        this.takimID = takimID;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public LocalDate getDogum_tarihi() {
        return dogum_tarihi;
    }

    public void setDogum_tarihi(LocalDate dogum_tarihi) {
        this.dogum_tarihi = dogum_tarihi;
    }

    public EMevki getMevki() {
        return mevki;
    }

    public void setMevki(EMevki mevki) {
        this.mevki = mevki;
    }

    public int getFormaNumarasi() {
        return formaNumarasi;
    }

    public void setFormaNumarasi(int formaNumarasi) {
        this.formaNumarasi = formaNumarasi;
    }

    public int getYetenekpuan() {
        return yetenekpuan;
    }

    public void setYetenekpuan(int yetenekpuan) {
        this.yetenekpuan = yetenekpuan;
    }
}
