package br.com.minhaempresa.expensecontrol;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Alexandre on 03/10/2017.
 */

public class Cr_Ed_Banco extends SQLiteOpenHelper {
    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "Produto";
    public static final String ID = "_id";
    public static final String Bar_code = "barra";
    public static final String Valor = "valor";
    public static final String Descricao = "descricao";
    public static final int VERSAO = 3;

    public Cr_Ed_Banco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);

    }


//"CREATE TABLE Clientes (ID INTEGER PRIMARY KEY AUTOINCREMENT, Nome TEXT NOT NULL, Sexo TEXT, UF TEXT NOT NULL, Vip INTEGER NOT NULL);"

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA + "("
                + ID + " integer primary key autoincrement,"
                + Bar_code + " text not null UNIQUE ,"
                + Valor + " Real not null,"
                + Descricao + " text not null)";
        Log.d("tag5", sql);
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        Log.d("tag2", "ok");
        onCreate(db);
    }
}



