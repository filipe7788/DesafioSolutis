package com.solutis.filiperibeiro.solutis.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties({"idCapsula"})
public class Capsula implements Serializable {


    private Long idCapsula;
    private String nomeCapsula;
    private String saborCapsula;

    public Capsula(String nomeCapsula, String saborCapsula) {
        this.nomeCapsula = nomeCapsula;
        this.saborCapsula = saborCapsula;
    }

    public Capsula() {
    }

    @Override
    public String toString() {
        return "Capsula{" +
                "id=" + idCapsula +
                ", nomeCapsula='" + nomeCapsula + '\'' +
                ", saborCapsula='" + saborCapsula + '\'' +
                '}';
    }

    public Long getId() {
        return idCapsula;
    }

    public void setId(Long id) {
        this.idCapsula = id;
    }

    public String getNomeCapsula() {
        return nomeCapsula;
    }

    public void setNomeCapsula(String nomeCapsula) {
        this.nomeCapsula = nomeCapsula;
    }

    public String getSaborCapsula() {
        return saborCapsula;
    }

    public void setSaborCapsula(String saborCapsula) {
        this.saborCapsula = saborCapsula;
    }
}
