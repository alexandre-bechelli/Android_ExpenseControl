package br.com.minhaempresa.expensecontrol;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Alexandre on 24/09/2017.
 */

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarLogin();
            }
        }, 3000);


        //mostrarLogin();
    }

    private void mostrarLogin() {
        Intent intent = new Intent(Inicio.this,
                PaginaPrincipal.class);
        startActivity(intent);
        finish();
    }

}
