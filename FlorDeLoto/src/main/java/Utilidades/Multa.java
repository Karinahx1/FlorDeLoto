/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

/**
 *
 * @author karyj
 */
public class Multa {
    private String codigoMulta;
    private String fechaMulta;
    private String persona;
    private String numeroDocumento;
    private String lugarInfraccion;
    private String fechaInfraccion;
    private String descripcion;
    private String fechaMaxPago;
    private String totalPagar;

    public Multa() {
    }

    public Multa(String codigoMulta, String fechaMulta, String persona, String numeroDocumento, String lugarInfraccion, String fechaInfraccion, String descripcion, String fechaMaxPago, String totalPagar) {
        this.codigoMulta = codigoMulta;
        this.fechaMulta = fechaMulta;
        this.persona = persona;
        this.numeroDocumento = numeroDocumento;
        this.lugarInfraccion = lugarInfraccion;
        this.fechaInfraccion = fechaInfraccion;
        this.descripcion = descripcion;
        this.fechaMaxPago = fechaMaxPago;
        this.totalPagar = totalPagar;
    }

    public String getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(String totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getCodigoMulta() {
        return codigoMulta;
    }

    public void setCodigoMulta(String codigoMulta) {
        this.codigoMulta = codigoMulta;
    }

    public String getFechaMulta() {
        return fechaMulta;
    }

    public void setFechaMulta(String fechaMulta) {
        this.fechaMulta = fechaMulta;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getLugarInfraccion() {
        return lugarInfraccion;
    }

    public void setLugarInfraccion(String lugarInfraccion) {
        this.lugarInfraccion = lugarInfraccion;
    }

    public String getFechaInfraccion() {
        return fechaInfraccion;
    }

    public void setFechaInfraccion(String fechaInfraccion) {
        this.fechaInfraccion = fechaInfraccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaMaxPago() {
        return fechaMaxPago;
    }

    public void setFechaMaxPago(String fechaMaxPago) {
        this.fechaMaxPago = fechaMaxPago;
    }

    @Override
    public String toString() {
        return "Multa{" + "codigoMulta=" + codigoMulta + ", fechaMulta=" + fechaMulta + ", persona=" + persona + ", numeroDocumento=" + numeroDocumento + ", lugarInfraccion=" + lugarInfraccion + ", fechaInfraccion=" + fechaInfraccion + ", descripcion=" + descripcion + ", fechaMaxPago=" + fechaMaxPago + ", totalPagar=" + totalPagar + '}';
    }
    
    
}
