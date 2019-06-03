package ua.lviv.iot.sportBuildings.models;

import javax.persistence.Entity;

@Entity
public class ChessHall extends SportBuilding {

    private int tablesNumber;

    public ChessHall() {
    }

    public ChessHall(int tablesNumber) {
        this.tablesNumber = tablesNumber;
    }

    public ChessHall(String name, String location, int constructionYear, SportSeason sportSeason,
                     int viewersNumber, SportKind sportKind, int tablesNumber) {
        super(name, location, constructionYear, sportSeason, viewersNumber, sportKind);
        this.tablesNumber = tablesNumber;
    }

    public String getHeaders() {
        return super.getHeaders() + ","
                + "tablesNumber";
    }

    public String toCSV() {
        return super.toCSV() + ","
                + this.tablesNumber;
    }

    public int getTablesNumber() {
        return tablesNumber;
    }

    public void setTablesNumber(int tablesNumber) {
        this.tablesNumber = tablesNumber;
    }
}
