/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

/**
 *
 * @author karyj
 */
public class Persona {
    private String nombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private String edad;
    private String email;
    private String celular;
    private String propiedad;
    private String ocupacion;

    public Persona() {
    }

    public Persona(String nombre, String tipoDocumento, String numeroDocumento, String edad, String email, String celular, String propiedad, String ocupacion) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.edad = edad;
        this.email = email;
        this.celular = celular;
        this.propiedad = propiedad;
        this.ocupacion = ocupacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", edad=" + edad + ", email=" + email + ", celular=" + celular + ", propiedad=" + propiedad + ", ocupacion=" + ocupacion + '}';
    }

    
    
    
}
