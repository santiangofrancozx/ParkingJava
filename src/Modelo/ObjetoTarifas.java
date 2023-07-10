package Modelo;

public class ObjetoTarifas {

    public ObjetoTarifas(){

    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    String tipo;
    Double valor;
}
