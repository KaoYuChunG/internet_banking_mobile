package com.example.xxx.internetbanking.API;

import com.example.xxx.internetbanking.Models.DebitoAutomatico;
import com.example.xxx.internetbanking.Models.Transacao;
import com.example.xxx.internetbanking.Models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface API {

    @GET("api/transacao")
    Call<List<Transacao>> getTrabsacoes();

    @GET("api/transacao/login/{id}")
    Call<Usuario> getUsuario(@Path("id") int id);

    @GET("api/conta")
    Call<List<DebitoAutomatico>> getDebitosAutomaticos();
}
