package com.example.xxx.internetbanking.API;

import com.example.xxx.internetbanking.Models.Transacao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface API {

    @GET("api/transacao")
    public Call<List<Transacao>> getTrabsacoes();
}
