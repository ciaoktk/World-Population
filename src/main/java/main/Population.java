package main;

public class Population {
    private String countryName;
    private int population;
    public Population(String countryName, int population) {
        this.countryName = countryName;
        this.population = population;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
}