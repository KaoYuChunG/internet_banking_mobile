package com.example.xxx.internetbanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.xxx.internetbanking.conta.corrente.ExtratoActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnContaCorrente;
    private Button btnEmprestimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    private void setup() {
        btnContaCorrente = findViewById(R.id.btn_conta_corrente);
        btnEmprestimo = findViewById(R.id.btn_emprestimo);

        btnContaCorrente.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, CorrenteActivity.class);
            startActivity(i);
        });

        btnEmprestimo.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, EmprestimoActivity.class);
            startActivity(i);
        });
    }



}
