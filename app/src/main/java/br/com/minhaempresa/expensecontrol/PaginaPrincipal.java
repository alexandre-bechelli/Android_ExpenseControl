package br.com.minhaempresa.expensecontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PaginaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opcao);


    }
    public void cadastrar(View v) {
        Intent intent = new Intent(PaginaPrincipal.this,
                cadastrar.class);
        startActivity(intent);

    }
    public void compras(View view) {
        Intent intent = new Intent(PaginaPrincipal.this,
                compras.class);
        startActivity(intent);

    }

}