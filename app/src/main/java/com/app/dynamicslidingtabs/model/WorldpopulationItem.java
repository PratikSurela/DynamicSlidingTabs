package com.app.dynamicslidingtabs.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorldpopulationItem {

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("flag")
    @Expose
    private String flag;

    @SerializedName("rank")
    @Expose
    private int rank;

    @SerializedName("population")
    @Expose
    private String population;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return
                "WorldpopulationItem{" +
                        "country = '" + country + '\'' +
                        ",flag = '" + flag + '\'' +
                        ",rank = '" + rank + '\'' +
                        ",population = '" + population + '\'' +
                        "}";
    }
}