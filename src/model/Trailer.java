package model;

public class Trailer {

    private String qtdadeConexoes;
    private String qtdadePesos;

    public Trailer(String qtdadeConexoes, String qtdadePesos) {
        this.qtdadeConexoes = qtdadeConexoes;
        this.qtdadePesos = qtdadePesos;
    }

    public String getQtdadeConexoes() {
        return qtdadeConexoes;
    }

    public String getQtdadePesos() {
        return qtdadePesos;
    }
}
