package com.example.xxx.internetbanking.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DebitoAutomatico implements Serializable {
//    [{"id":3,"descricao":"luz","codigo":987654,"conta":0},{"id":4,"descricao":"Gás","codigo":2312312,"conta":0}]

    @SerializedName("id")
    public int id;

    @SerializedName("descricao")
    public String descricao;

    @SerializedName("codigo")
    public int codigo;
}
