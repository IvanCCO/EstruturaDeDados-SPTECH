package org.example;

public class Operacao {

    private ContaBancaria objConta;

    private TipoOperacao tipoOperacao;

    private Double valor;

    public ContaBancaria getObjConta() {
        return objConta;
    }

    public void setObjConta(ContaBancaria objConta) {
        this.objConta = objConta;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Operacao{" +
                "objConta=" + objConta +
                ", tipoOperacao='" + tipoOperacao + '\'' +
                ", valor=" + valor +
                '}';
    }

    public Operacao(ContaBancaria objConta, TipoOperacao tipoOperacao, Double valor) {
        this.objConta = objConta;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
    }
}
