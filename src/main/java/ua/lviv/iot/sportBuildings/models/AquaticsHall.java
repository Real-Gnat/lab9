package ua.lviv.iot.sportBuildings.models;

import javax.persistence.Entity;

@Entity
public class AquaticsHall extends SportBuilding {

    private int poolsNumber;
    private double averagePoolVolume;

    public AquaticsHall() {
    }

    public AquaticsHall(int poolsNumber, double averagePoolVolume) {
        this.poolsNumber = poolsNumber;
        this.averagePoolVolume = averagePoolVolume;
    }

    public AquaticsHall(String name, String location, int constructionYear, SportSeason sportSeason,
                        int viewersNumber, SportKind sportKind, int poolsNumber, double averagePoolVolume) {
        super(name, location, constructionYear, sportSeason, viewersNumber, sportKind);
        this.poolsNumber = poolsNumber;
        this.averagePoolVolume = averagePoolVolume;
    }

    public String getHeaders() {
        return super.getHeaders() + ","
                + "poolsNumber" + ","
                + "averagePoolVolume";
    }

    public String toCSV() {
        return super.toCSV() + ","
                + this.poolsNumber + ","
                + this.averagePoolVolume;
    }

    public int getPoolsNumber() {
        return poolsNumber;
    }

    public void setPoolsNumber(int poolsNumber) {
        this.poolsNumber = poolsNumber;
    }

    public double getAveragePoolVolume() {
        return averagePoolVolume;
    }

    public void setAveragePoolVolume(double averagePoolVolume) {
        this.averagePoolVolume = averagePoolVolume;
    }
}
