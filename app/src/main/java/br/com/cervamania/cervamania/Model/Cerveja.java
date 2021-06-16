package br.com.cervamania.cervamania.Model;

public class Cerveja {
    
    private String codigo_cerveja;
	private String nome_cerveja;
	private String descricao_cerveja;
	private String cervejaria;
	private String codigo_tipo_cerveja;
	private String teor;
	private String ingredientes;
	private String temperatura;
	private String cor;
	private String codigo_pais_cerveja;

    public Cerveja(String codigo_cerveja, String nome_cerveja, String descricao_cerveja, String cervejaria, String codigo_tipo_cerveja, String teor, String ingredientes, String temperatura, String cor, String codigo_pais_cerveja) {
        this.codigo_cerveja = codigo_cerveja;
        this.nome_cerveja = nome_cerveja;
        this.descricao_cerveja = descricao_cerveja;
        this.cervejaria = cervejaria;
        this.codigo_tipo_cerveja = codigo_tipo_cerveja;
        this.teor = teor;
        this.ingredientes = ingredientes;
        this.temperatura = temperatura;
        this.cor = cor;
        this.codigo_pais_cerveja = codigo_pais_cerveja;
    }

    public Cerveja() {
    }

    public String getCodigo_cerveja() {
        return codigo_cerveja;
    }

    public void setCodigo_cerveja(String codigo_cerveja) {
        this.codigo_cerveja = codigo_cerveja;
    }

    public String getNome_cerveja() {
        return nome_cerveja;
    }

    public void setNome_cerveja(String nome_cerveja) {
        this.nome_cerveja = nome_cerveja;
    }

    public String getDescricao_cerveja() {
        return descricao_cerveja;
    }

    public void setDescricao_cerveja(String descricao_cerveja) {
        this.descricao_cerveja = descricao_cerveja;
    }

    public String getCervejaria() {
        return cervejaria;
    }

    public void setCervejaria(String cervejaria) {
        this.cervejaria = cervejaria;
    }

    public String getCodigo_tipo_cerveja() {
        return codigo_tipo_cerveja;
    }

    public void setCodigo_tipo_cerveja(String codigo_tipo_cerveja) {
        this.codigo_tipo_cerveja = codigo_tipo_cerveja;
    }

    public String getTeor() {
        return teor;
    }

    public void setTeor(String teor) {
        this.teor = teor;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCodigo_pais_cerveja() {
        return codigo_pais_cerveja;
    }

    public void setCodigo_pais_cerveja(String codigo_pais_cerveja) {
        this.codigo_pais_cerveja = codigo_pais_cerveja;
    }
    
}
