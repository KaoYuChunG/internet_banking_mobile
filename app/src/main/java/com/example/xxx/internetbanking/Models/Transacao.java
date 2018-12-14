package com.example.xxx.internetbanking.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Transacao implements Serializable {



    @SerializedName("tipo_transacao_descricao")
    public String tipo_transacao;

    @SerializedName("data")
    public String data;

    @SerializedName("hora")
    public String hora;

    @SerializedName("valor")
    public float valor;
}
