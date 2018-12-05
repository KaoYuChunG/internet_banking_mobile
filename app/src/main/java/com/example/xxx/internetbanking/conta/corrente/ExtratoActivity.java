package com.example.xxx.internetbanking.conta.corrente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.xxx.internetbanking.API.API;
import com.example.xxx.internetbanking.Adapter.TransacoesAdapter;
import com.example.xxx.internetbanking.Models.Transacao;
import com.example.xxx.internetbanking.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExtratoActivity extends AppCompatActivity {


    private Toolbar mToolbar;
    private final int _HISTORICORESULTADO = 1234;
    private List<Transacao> mList = new ArrayList<>();
    private TransacoesAdapter mAdapter;
    private RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extrato);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mRecycler = findViewById(R.id.rv_transacoes);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(manager);
        mRecycler.setHasFixedSize(true);

        loadData();
    }

    private void validar(){
        if(mList == null || mList.isEmpty()){
            findViewById(R.id.lbl_message).setVisibility(View.VISIBLE);
            mRecycler.setVisibility(View.GONE);
        }
        else {
            findViewById(R.id.lbl_message).setVisibility(View.INVISIBLE);
            mRecycler.setVisibility(View.VISIBLE);
        }
    }

    private void loadData(){
        Retrofit retrofit =  new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://192.168.1.1:44397/api")
                .build();

        API api = retrofit.create(API.class);

        Call<List<Transacao>> call = api.getTrabsacoes();
        call.enqueue(new Callback<List<Transacao>>() {
            @Override
            public void onResponse(Call<List<Transacao>> call, Response<List<Transacao>> response) {
                if(response.isSuccessful()){
                    mList = response.body();
                    mAdapter = new TransacoesAdapter(ExtratoActivity.this, mList);
                    mRecycler.setAdapter(mAdapter);



                }else{
                    Toast.makeText(ExtratoActivity.this, response.message(),Toast.LENGTH_LONG).show();
                }

                //validar a lista se esta vazia
                validar();
            }

            @Override
            public void onFailure(Call<List<Transacao>> call, Throwable t) {
                Toast.makeText(ExtratoActivity.this, t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }

        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
//            finish(); // close this activity and return to preview activity (if there is any)
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }


}
