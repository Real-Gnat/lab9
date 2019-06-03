package ua.lviv.iot.sportBuildings.models;

import javax.persistence.Entity;

@Entity
public class AthleticsPlayground extends SportBuilding {

    private int trackDistance;
    private int tracksNumber;

    public AthleticsPlayground() {
    }

    public AthleticsPlayground(int trackDistance, int tracksNumber) {
        this.trackDistance = trackDistance;
        this.tracksNumber = tracksNumber;
    }

    public AthleticsPlayground(String name, String location, int constructionYear, SportSeason sportSeason,
                               int viewersNumber, SportKind sportKind, int trackDistance, int tracksNumber) {
        super(name, location, constructionYear, sportSeason, viewersNumber, sportKind);
        this.trackDistance = trackDistance;
        this.tracksNumber = tracksNumber;
    }

    public String getHeaders() {
        return super.getHeaders() + ","
                + "trackDistance" + ","
                + "tracksNumber";
    }

    public String toCSV() {
        return super.toCSV() + ","
                + this.trackDistance + ","
                + this.tracksNumber;
    }

    public int getTrackDistance() {
        return trackDistance;
    }

    public void setTrackDistance(int trackDistance) {
        this.trackDistance = trackDistance;
    }

    public int getTracksNumber() {
        return tracksNumber;
    }

    public void setTracksNumber(int tracksNumber) {
        this.tracksNumber = tracksNumber;
    }
}
