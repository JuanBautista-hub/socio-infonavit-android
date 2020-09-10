package com.socio_infonavit_android.socio_infonavit_android.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceJWT {

    private static final String URL_BASE_JWT = "https://staging.api.socioinfonavit.io/";
    private static ServiceJWT instance;
    private Retrofit retrofit;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpclientbuilder;

    private ServiceJWT() {
        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpclientbuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE_JWT)
                .client(httpclientbuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized ServiceJWT getInstance() {
        if (instance == null) {
            instance = new ServiceJWT();
        }
        return instance;
    }

    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}

