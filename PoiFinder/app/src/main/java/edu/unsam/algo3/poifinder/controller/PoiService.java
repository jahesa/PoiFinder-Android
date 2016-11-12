package edu.unsam.algo3.poifinder.controller;

import edu.unsam.algo3.poifinder.model;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.GET;
/**
 * Created by Javier on 12/11/2016.
 */

public interface PoiService {
    @GET("/pois")
    Call<Poi> getPois();
}
