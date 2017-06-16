package com.app.dynamicslidingtabs.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Album {

    @SerializedName("actors")
    @Expose
    private List<AlbumList> albumLists;

    public void setActors(List<AlbumList> actors) {
        this.albumLists = actors;
    }

    public List<AlbumList> getActors() {
        return albumLists;
    }

}