package com.ews.androidrestapp.model;

/**
 * Created by wallace on 21/06/17.
 */
public class Android {

   private String versao;
   private String nome;
   private String api;
   private String urlImagem;

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    @Override
    public String toString() {
        return "Android{" +
                "versao='" + versao + '\'' +
                ", nome='" + nome + '\'' +
                ", api='" + api + '\'' +
                ", urlImagem='" + urlImagem + '\'' +
                '}';
    }
}