package br.com.minhaempresa.expensecontrol;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Alexandre on 03/10/2017.
 */

    public class BancoController {
    private SQLiteDatabase db;
    private Cr_Ed_Banco banco;

    public BancoController(Context context){
        banco = new Cr_Ed_Banco(context);

    }
public String inserdeDado(String code_bar,String descricao,double valor){
    ContentValues valores;
    long resultado;

    db = banco.getWritableDatabase();
    valores = new ContentValues();
    valores.put(Cr_Ed_Banco.Valor, valor);
    valores.put(Cr_Ed_Banco.Descricao,descricao);
    valores.put(Cr_Ed_Banco.Bar_code, code_bar);

    resultado = db.insert(Cr_Ed_Banco.TABELA, null, valores);
    db.close();

    if (resultado ==-1)
        return "Erro ao inserir registro";
    else
        return "Registro Inserido com sucesso" ;

}
    public Cursor carregaDados(){

        Cursor cursor;
        String[] campos =  {banco.ID,banco.Descricao,banco.Bar_code,banco.Valor};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public Produto BuscaProduto(String codigo_filtro){
        Produto produto = new Produto();

        Cursor cursor;
        String[] campos =  {banco.Descricao,banco.Bar_code,banco.Valor};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, Cr_Ed_Banco.Bar_code+ " = ?", new String[]{codigo_filtro}, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        int col_descr = cursor.getColumnIndex(Cr_Ed_Banco.Descricao);
        int col_Valor = cursor.getColumnIndex(Cr_Ed_Banco.Valor);
        produto.setName_descricao(cursor.getString(col_descr));
        produto.setValor(Double.parseDouble(cursor.getString(col_Valor)));
        produto.setCodigo_de_Barras(codigo_filtro);
        Log.d("Valores",produto.getCodigo_de_Barras()+" - " + produto.getName_descricao() + " - "+produto.getValor() );
        return produto;
    }



}





