package com.app.dynamicslidingtabs.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Country {

    @SerializedName("worldpopulation")
    @Expose
    private List<WorldpopulationItem> worldpopulation;

    public void setWorldpopulation(List<WorldpopulationItem> worldpopulation) {
        this.worldpopulation = worldpopulation;
    }

    public List<WorldpopulationItem> getWorldpopulation() {
        return worldpopulation;
    }

    @Override
    public String toString() {
        return
                "Country{" +
                        "worldpopulation = '" + worldpopulation + '\'' +
                        "}";
    }
}