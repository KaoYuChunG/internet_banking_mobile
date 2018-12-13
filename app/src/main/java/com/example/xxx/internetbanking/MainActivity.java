package com.example.xxx.internetbanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnContaCorrente;
    private Button mBtnEmprestimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    private void setup() {
        mBtnContaCorrente = findViewById(R.id.btn_conta_corrente);
        mBtnEmprestimo = findViewById(R.id.btn_emprestimo);

        mBtnContaCorrente.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, CorrenteActivity.class);
            startActivity(i);
        });

        mBtnEmprestimo.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, EmprestimoActivity.class);
            startActivity(i);
        });
    }



}
