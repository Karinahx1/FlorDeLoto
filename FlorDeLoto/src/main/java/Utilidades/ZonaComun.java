/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

/**
 *
 * @author karyj
 */
public class ZonaComun {
    private String nombreZona;
    private String horaInicio;
    private String horaFinal;
    private String disponibilidad;

    public ZonaComun() {
    }

    public ZonaComun(String nombreZona, String horaInicio, String horaFinal, String disponibilidad) {
        this.nombreZona = nombreZona;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.disponibilidad = disponibilidad;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    @Override
    public String toString() {
        return "ZonaComun{" + "nombreZona=" + nombreZona + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + ", disponibilidad=" + disponibilidad + '}';
    }
    
}
