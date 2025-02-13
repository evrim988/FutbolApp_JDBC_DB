package org.example.entites;

public class BaseEntity {

    private Integer state;
    private Long createat; //bigint karşılığı
    private Long updateat; //bigint karşılığı

    public BaseEntity() {
    }

    public BaseEntity(Integer state, Long createat, Long updateat) {
        this.state = state;
        this.createat = createat;
        this.updateat = updateat;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCreateat() {
        return createat;
    }

    public void setCreateat(Long createat) {
        this.createat = createat;
    }

    public Long getUpdateat() {
        return updateat;
    }

    public void setUpdateat(Long updateat) {
        this.updateat = updateat;
    }

}
