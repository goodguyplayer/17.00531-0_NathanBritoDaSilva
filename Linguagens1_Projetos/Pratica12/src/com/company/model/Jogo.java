package com.company.model;
import com.company.enums.Status;

public class Jogo {
    private String platform;
    private String nome;
    private Status status;

    public Jogo(String platform, String nome) {
        this.platform = platform;
        this.nome = nome;
        this.status = Status.NAO_INICIADO;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "platform='" + platform + '\'' +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                '}';
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setStatusJogando(){
        this.status = Status.JOGANDO;
    }

    public String getPlatform() {
        return platform;
    }

    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return ""+status;
    }
}
