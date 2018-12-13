package com.example.xxx.internetbanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.xxx.internetbanking.conta.corrente.ExtratoActivity;

public class CorrenteActivity extends AppCompatActivity {

    private Button btnExtrto;
    private Button mBtnDebito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrente);
        setup();

    }

    private void setup() {
        btnExtrto = (Button) findViewById(R.id.btn_extrato);

        btnExtrto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CorrenteActivity.this, ExtratoActivity.class);
                startActivity(i);
            }
        });

        mBtnDebito = (Button) findViewById(R.id.btn_conta_corrente_debito);

        mBtnDebito.setOnClickListener(v -> {
            Intent i = new Intent(CorrenteActivity.this, ListarDebitoAutomaticoActivity.class);
            startActivity(i);
        });
    }
}
