package com.example.xxx.internetbanking.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Transacao implements Serializable {


    @SerializedName("id")
    public int id;

    @SerializedName("id_tipo_transacao")
    public int id_tipo_transacao;

    @SerializedName("data")
    public Date data;

    @SerializedName("hora")
    public Date hora;

    @SerializedName("valor")
    public float valor;
}
