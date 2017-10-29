package br.com.minhaempresa.expensecontrol;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Created by Alexandre on 26/09/2017.
 */

public class cadastrar extends Activity {

    private ListView lista;
    private EditText bar_code;
    private EditText descricao;
    private EditText val;
    Exception exception;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar);
        this.bar_code = (EditText) findViewById(R.id.field_bar);
        this.descricao = (EditText) findViewById((R.id.field_descri));
        this.val = (EditText) findViewById(R.id.camp_val);
        atualizar_lista();


    }

    public void atualizar_lista() {
        try {
            BancoController crud = new BancoController(getBaseContext());
            Cursor cursor = crud.carregaDados();


            String[] nomeCampos = new String[]{Cr_Ed_Banco.Bar_code, Cr_Ed_Banco.Descricao, Cr_Ed_Banco.Valor};


            int[] idViews = new int[]{R.id.txt_bar_cadastro, R.id.txt_descricao_cadastro, R.id.txt_valor_cadastro};

            SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                    R.layout.list_cadastro, cursor, nomeCampos, idViews, 0);
            lista = (ListView) findViewById(R.id.List_vi);
            lista.setAdapter(adaptador);
        } catch (Exception e) {
            Log.d("erro", e.toString());
        }
    }

    public void gravar(View view) {
        try {
            String bar_codeString = this.bar_code.getText().toString();
            String descricaoString = this.descricao.getText().toString();
            double valor_do = Double.parseDouble(this.val.getText().toString());
            if (bar_codeString.length() != 0 && descricaoString.length() != 0 && valor_do > 0) {
                String resultado;
                BancoController crud = new BancoController(getBaseContext());
                resultado = crud.inserdeDado(bar_codeString, descricaoString, valor_do);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                atualizar_lista();
                if (resultado == "Registro Inserido com sucesso") {
                    this.bar_code.setText("");
                    this.descricao.setText("");
                    this.val.setText("");
                    this.bar_code.requestFocus();
                }
            } else
                Toast.makeText(getApplicationContext(), "Existem campos invalidos", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Existem campos invalidos", Toast.LENGTH_LONG).show();


        }
    }
}







