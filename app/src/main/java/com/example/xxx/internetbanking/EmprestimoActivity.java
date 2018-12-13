package com.example.xxx.internetbanking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.xxx.internetbanking.API.API;
import com.example.xxx.internetbanking.Models.Usuario;
import com.example.xxx.internetbanking.Utils.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class EmprestimoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprestimo);
        setup();
        getUsuario();
    }

    private void setup() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void getUsuario() {
        Retrofit retrofit = ServiceGenerator.retrofit(Usuario.class);

        API api = retrofit.create(API.class);

        Call<Usuario> call = api.getUsuario(1);


        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(EmprestimoActivity.this, response.body().agencia, Toast.LENGTH_SHORT).show();
                    ServiceGenerator.usuario = response.body();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(EmprestimoActivity.this, "ruim", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
