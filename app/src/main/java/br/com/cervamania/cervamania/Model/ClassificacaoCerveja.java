package br.com.cervamania.cervamania.Model;

public class ClassificacaoCerveja {

    private String codigoCerveja, comentarios, nomeCerveja;
    private double estrelas;

    public String getCodigoCerveja() {
        return codigoCerveja;
    }

    public void setCodigoCerveja(String codigoCerveja) {
        this.codigoCerveja = codigoCerveja;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getNomeCerveja() {
        return nomeCerveja;
    }

    public void setNomeCerveja(String nomeCerveja) {
        this.nomeCerveja = nomeCerveja;
    }

    public double getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(double estrelas) {
        this.estrelas = estrelas;
    }
}
