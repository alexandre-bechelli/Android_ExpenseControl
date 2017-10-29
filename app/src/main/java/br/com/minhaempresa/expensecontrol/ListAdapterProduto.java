package br.com.minhaempresa.expensecontrol;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Alexandre on 09/10/2017.
 */

public class ListAdapterProduto extends ArrayAdapter {
    private Context context;
    private ArrayList<Produto> lista;
    private int posicao;
    compras comp = new compras();

    public ListAdapterProduto(Context context, ArrayList<Produto> lista) {
        super(context, 0, lista);
        this.lista = lista;
        this.context = context;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        try {
            Produto itemProduto = this.lista.get(position);
            convertView = LayoutInflater.from(this.context).inflate(R.layout.list_compra, null);

            TextView textView = (TextView) convertView.findViewById(R.id.txt_bar);
            textView.setText(itemProduto.getCodigo_de_Barras());

            TextView textViewDescr = (TextView) convertView.findViewById(R.id.txt_descricao);
            textViewDescr.setText(itemProduto.getName_descricao());

            TextView textViewValor = (TextView) convertView.findViewById(R.id.txt_valor);
            textViewValor.setText(String.format("R$: " + itemProduto.getValor()));

        } catch (Exception erro2) {
            Log.d("erro2", erro2.toString());
        }
        return convertView;
    }


    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
}
