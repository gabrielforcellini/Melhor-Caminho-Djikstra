package model;

public class Pesos {

    private String noOrigem;
    private String noDestino;
    private String pesoAresta;

    public Pesos(String noOrigem, String noDestino, String pesoAresta) {
        this.noOrigem = noOrigem;
        this.noDestino = noDestino;
        this.pesoAresta = pesoAresta;
    }

    public String getNoOrigem() {
        return noOrigem;
    }

    public String getNoDestino() {
        return noDestino;
    }

    public String getPesoAresta() {
        return pesoAresta;
    }
}
