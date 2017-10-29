package br.com.minhaempresa.expensecontrol;

/**
 * Created by Alexandre on 08/10/2017.
 */

public class Produto {
    private String name_descricao;
    private double valor;
    private String Codigo_de_Barras;


    public String getName_descricao() {
        return name_descricao;
    }

    public void setName_descricao(String name_descricao) {
        this.name_descricao = name_descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCodigo_de_Barras() {
        return Codigo_de_Barras;
    }

    public void setCodigo_de_Barras(String codigo_de_Barras) {
        Codigo_de_Barras = codigo_de_Barras;
    }
}
