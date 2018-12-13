package com.example.xxx.internetbanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.xxx.internetbanking.API.API;
import com.example.xxx.internetbanking.Adapter.AdapterPositionOnClickListener;
import com.example.xxx.internetbanking.Adapter.DebitoAutomaticoAdapter;
import com.example.xxx.internetbanking.Models.DebitoAutomatico;
import com.example.xxx.internetbanking.Utils.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListarDebitoAutomaticoActivity extends AppCompatActivity implements AdapterPositionOnClickListener {

    private RecyclerView mRecyclerView;
    private DebitoAutomaticoAdapter mAdapter;
    private LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_debito_automatico);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_debitos_em_conta);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Retrofit getUsuarios
        getDebitosAutomaticos();
    }

    private void getDebitosAutomaticos() {
        Retrofit retrofit = ServiceGenerator.retrofit();

        API api = retrofit.create(API.class);

        Call<List<DebitoAutomatico>> call = api.getDebitosAutomaticos();

        call.enqueue(new Callback<List<DebitoAutomatico>>() {
            @Override
            public void onResponse(Call<List<DebitoAutomatico>> call, Response<List<DebitoAutomatico>> response) {
                if (response.isSuccessful()) {
                    mAdapter = new DebitoAutomaticoAdapter(ListarDebitoAutomaticoActivity.this, response.body());
                    mAdapter.setAdapterPositionOnClickListener(ListarDebitoAutomaticoActivity.this);
                    mRecyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<DebitoAutomatico>> call, Throwable t) {
                Toast.makeText(ListarDebitoAutomaticoActivity.this, "ruim", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void setAdapterPositionOnClickListener(View view, int position) {
        DebitoAutomatico d = mAdapter.getDebitoAutomatico(position);
        Intent i  = new Intent(ListarDebitoAutomaticoActivity.this, DebitoAutomaticoActivity.class);
        i.putExtra("debitoAutomatico", d);
        startActivity(i);
    }
}
