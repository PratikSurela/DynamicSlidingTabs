package com.app.dynamicslidingtabs.utils;

import android.widget.ProgressBar;

import com.squareup.picasso.Callback;

/**
 * Created by Pratik Surela on 20/12/16.
 */

public class ImageLoadedCallback implements Callback {
    ProgressBar progressBar;

    public ImageLoadedCallback(ProgressBar progBar){
        progressBar = progBar;
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }
}