package br.com.minhaempresa.expensecontrol;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Alexandre on 26/09/2017.
 */

public class compras extends Activity {
    public double Valor_total = 0;
    DecimalFormat decimalFormat = new DecimalFormat("0.##");
    //
    private BancoController crud;
    private ArrayList<Produto> lista;
    private ListAdapterProduto adapterProduto;
    private ListView listView;
    private TextView campo_valor;
    private EditText bar_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compras);
        this.crud = new BancoController(getBaseContext());
        this.lista = new ArrayList<Produto>();
        this.adapterProduto = new ListAdapterProduto(this, lista);
        this.listView = (ListView) findViewById(R.id.list_comp);
        this.campo_valor = (TextView) findViewById(R.id.txt_total);
        this.bar_code = (EditText) findViewById(R.id.field_add);
        listView.setAdapter(adapterProduto);

    }


    public void adicionar_produto(View v) {
        try {
            String bar_codeString = bar_code.getText().toString();
            Produto produto = crud.BuscaProduto(bar_codeString);
            this.Valor_total += produto.getValor();
            this.lista.add(produto);
            this.listView.setAdapter(adapterProduto);
            this.campo_valor.setText(String.format("R$:" + decimalFormat.format(this.Valor_total)));
            this.bar_code.setText("");
            this.bar_code.requestFocus();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Valor não cadastrado", Toast.LENGTH_LONG).show();
        }
    }

    public void deletar_produto(View v) {
        int pos = this.listView.getPositionForView(v);
        this.Valor_total -= (this.lista.get(pos).getValor());
        this.lista.remove(pos);
        this.listView.setAdapter(this.adapterProduto);
        this.campo_valor.setText(String.format("R$:" + decimalFormat.format(this.Valor_total)));
        if (this.Valor_total <= -0) this.campo_valor.setText(String.format("R$:" + 0));


    }
}


