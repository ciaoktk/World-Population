package main;

public class MostPopulatedReport {
    private String countryName;
    private String isoName;
    private int latestPopulation;
    private int worldRank;

    public MostPopulatedReport(String countryName, String isoName, int latestPopulation, int worldRank) {
        this.countryName = countryName;
        this.isoName = isoName;
        this.latestPopulation = latestPopulation;
        this.worldRank = worldRank;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getIsoName() {
        return isoName;
    }

    public void setIsoName(String isoName) {
        this.isoName = isoName;
    }

    public int getLatestPopulation() {
        return latestPopulation;
    }

    public void setLatestPopulation(int latestPopulation) {
        this.latestPopulation = latestPopulation;
    }

    public int getWorldRank() {
        return worldRank;
    }

    public void setWorldRank(int worldRank) {
        this.worldRank = worldRank;
    }
}
