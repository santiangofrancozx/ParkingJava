package Modelo;

public class ObjetoFactura {

    int codigio_factura;
    int codigo;
    int he;
    int me;
    int hs;
    int ms;
    int horas;

    public String getNameCliente() {
        return nameCliente;
    }

    public void setNameCliente(String nameCliente) {
        this.nameCliente = nameCliente;
    }

    String nameCliente;

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    int minutos;
    Double valorHoras, total;

    public int getCodigio_factura() {
        return codigio_factura;
    }

    public void setCodigio_factura(int codigio_factura) {
        this.codigio_factura = codigio_factura;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getHe() {
        return he;
    }

    public void setHe(int he) {
        this.he = he;
    }

    public int getMe() {
        return me;
    }

    public void setMe(int me) {
        this.me = me;
    }

    public int getHs() {
        return hs;
    }

    public void setHs(int hs) {
        this.hs = hs;
    }

    public int getMs() {
        return ms;
    }

    public void setMs(int ms) {
        this.ms = ms;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Double getValorHoras() {
        return valorHoras;
    }

    public void setValorHoras(Double valorHoras) {
        this.valorHoras = valorHoras;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    String tipo, placa;

    public ObjetoFactura(){

    }
}
