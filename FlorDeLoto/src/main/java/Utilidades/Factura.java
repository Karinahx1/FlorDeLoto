/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

/**
 *
 * @author karyj
 */
public class Factura {
    private String numeroFactura;
    private String fechaFactura; 
    private String propietario;
    private String numeroDocumento;
    private String propiedad;
    private String valorMetroCuadrado;
    private String valorAdministracion;
    private String fechaMaxPago;
    private String totalPagar;

    public Factura() {
    }

    public Factura(String numeroFactura, String fechaFactura, String propietario, String numeroDocumento, String propiedad, String valorMetroCuadrado, String valorAdministracion, String fechaMaxPago, String totalPagar) {
        this.numeroFactura = numeroFactura;
        this.fechaFactura = fechaFactura;
        this.propietario = propietario;
        this.numeroDocumento = numeroDocumento;
        this.propiedad = propiedad;
        this.valorMetroCuadrado = valorMetroCuadrado;
        this.valorAdministracion = valorAdministracion;
        this.fechaMaxPago = fechaMaxPago;
        this.totalPagar = totalPagar;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public String getValorMetroCuadrado() {
        return valorMetroCuadrado;
    }

    public void setValorMetroCuadrado(String valorMetroCuadrado) {
        this.valorMetroCuadrado = valorMetroCuadrado;
    }

    public String getValorAdministracion() {
        return valorAdministracion;
    }

    public void setValorAdministracion(String valorAdministracion) {
        this.valorAdministracion = valorAdministracion;
    }

    public String getFechaMaxPago() {
        return fechaMaxPago;
    }

    public void setFechaMaxPago(String fechaMaxPago) {
        this.fechaMaxPago = fechaMaxPago;
    }

    public String getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(String totalPagar) {
        this.totalPagar = totalPagar;
    }

    @Override
    public String toString() {
        return "Factura{" + "numeroFactura=" + numeroFactura + ", fechaFactura=" + fechaFactura + ", propietario=" + propietario + ", numeroDocumento=" + numeroDocumento + ", propiedad=" + propiedad + ", valorMetroCuadrado=" + valorMetroCuadrado + ", valorAdministracion=" + valorAdministracion + ", fechaMaxPago=" + fechaMaxPago + ", totalPagar=" + totalPagar + '}';
    }

    
    
}
