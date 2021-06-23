package br.com.cervamania.cervamania.Model;

public class ClassificacaoCerveja {

    private String codigoCerveja, comentarios, nomeCerveja;
    private double estrelas;

    public ClassificacaoCerveja(String codigoCerveja, String comentarios, String nomeCerveja, double estrelas) {
        this.codigoCerveja = codigoCerveja;
        this.comentarios = comentarios;
        this.nomeCerveja = nomeCerveja;
        this.estrelas = estrelas;
    }

    public ClassificacaoCerveja(String codigoCerveja, double estrelas, String comentarios) {
        this.codigoCerveja = codigoCerveja;
        this.comentarios = comentarios;
        this.estrelas = estrelas;
    }

    public ClassificacaoCerveja() {
    }

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
