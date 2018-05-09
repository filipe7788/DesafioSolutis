package com.solutis.filiperibeiro.solutis.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Capsula implements Serializable {

    @SerializedName("idCapsula")
    @Expose
    private long idCapsula;

    @SerializedName("nomeCapsula")
    @Expose
    private String nomeCapsula;

    @SerializedName("saborCapsula")
    @Expose
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
                "idCapsula=" + idCapsula +
                ", nomeCapsula='" + nomeCapsula + '\'' +
                ", saborCapsula='" + saborCapsula + '\'' +
                '}';
    }

    public long getId() {
        return idCapsula;
    }

    public void setId(long id) {
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
