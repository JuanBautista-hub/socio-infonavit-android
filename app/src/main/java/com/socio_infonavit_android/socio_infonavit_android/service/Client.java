package com.socio_infonavit_android.socio_infonavit_android.service;

import com.socio_infonavit_android.socio_infonavit_android.model.BenevitWallets;
import com.socio_infonavit_android.socio_infonavit_android.model.Landing_Benevits;
import com.socio_infonavit_android.socio_infonavit_android.model.ResponseLogin;
import com.socio_infonavit_android.socio_infonavit_android.model.User_login;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Client {

    @POST("/api/v1/login")
    Call<ResponseLogin> login_userToken(@Body User_login user_login);

    @GET("/api/v1/member/wallets")
       Call<ArrayList<BenevitWallets>> ObtenerBenevitWallets();

    @GET("/api/v1/member/landing_benevits")
    Call<Landing_Benevits> obtenerListasCategprias (@Header("Authorization") String autHeader);

}
