package com.example.xxx.internetbanking.Utils;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.lang.reflect.Type;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import static java.security.cert.CertificateFactory.getInstance;

public abstract class ServiceGenerator {

    public static String STRING_TOKEN;
    private final static String URL = "http://10.0.2.2:5000/";

    public static Retrofit retrofit(){

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(URL)
                .client(UnsafeOkHttpClient.getUnsafeOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }


    public static Retrofit retrofit(Type type){

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(URL)
                .client(UnsafeOkHttpClient.getUnsafeOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(JsonUtils.getGson(type)))
                .build();

        return retrofit;
    }
}