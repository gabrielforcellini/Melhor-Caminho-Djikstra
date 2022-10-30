package model;

public class Header {

    private String qtadeNos;
    private String somaPesos;

    public Header(String qtadeNos, String somaPesos) {
        this.qtadeNos = qtadeNos;
        this.somaPesos = somaPesos;
    }

    public String getQtadeNos() {
        return qtadeNos;
    }

    public void setQtadeNos(String qtadeNos) {
        this.qtadeNos = qtadeNos;
    }

    public String getSomaPesos() {
        return somaPesos;
    }

    public void setSomaPesos(String somaPesos) {
        this.somaPesos = somaPesos;
    }
}
