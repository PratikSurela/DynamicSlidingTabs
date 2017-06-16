package com.app.dynamicslidingtabs.retrofit;

import com.app.dynamicslidingtabs.model.Actors;
import com.app.dynamicslidingtabs.model.Country;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Pratik Surela on 24/5/17.
 */

public interface ApiInterface {

    @GET("jsonActors")
    Call<Actors> getActorsCall();

    /*@GET("photos")
    Call<List<AlbumList>> getAlbum();*/

    @GET("jsonparsetutorial.txt")
    Call<Country> getCountry();
}