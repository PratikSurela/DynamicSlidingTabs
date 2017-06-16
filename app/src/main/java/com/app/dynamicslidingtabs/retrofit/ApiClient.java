package com.app.dynamicslidingtabs.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pratik Surela on 24/5/17.
 */

public class ApiClient {

    public static final String BASE_ACTOR_URL = "http://microblogging.wingnity.com/JSONParsingTutorial/";
    //public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static final String BASE_URL = "http://www.androidbegin.com/tutorial/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getActorClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_ACTOR_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
