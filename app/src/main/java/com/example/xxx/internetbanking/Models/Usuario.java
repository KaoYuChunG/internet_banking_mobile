package com.example.xxx.internetbanking.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Usuario implements Serializable {

    @SerializedName("id")
    public int id;

    @SerializedName("numero")
    public int numero;

    @SerializedName("agencia")
    public String agencia;

    @SerializedName("saldo")
    public double saldo;

    @SerializedName("tipoConta")
    public int tipoConta;
}
