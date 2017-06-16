package com.app.dynamicslidingtabs.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Actors {

    @SerializedName("actors")
    @Expose
    private List<ActorsItem> actors;

    public void setActors(List<ActorsItem> actors) {
        this.actors = actors;
    }

    public List<ActorsItem> getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return
                "Actors{" +
                        "actors = '" + actors + '\'' +
                        "}";
    }
}