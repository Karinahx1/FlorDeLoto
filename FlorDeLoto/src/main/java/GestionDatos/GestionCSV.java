/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDatos;

import Utilidades.ZonaComun;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karyj
 */
public class GestionCSV {
    // Lista que contiene las zonas comunes registradas
    private List<ZonaComun> zonasComunes;

    public GestionCSV() {
        zonasComunes = new ArrayList<>();  // Inicialización de la lista
    }

    // Método para registrar una nueva zona común y guardar la información en un archivo CSV
    public void registrarZona(String nombreZona, String horaInicio, String horaFinal, String disponibilidad) {
        String archivo = "RegistroZonasComunes.csv";  // Ruta del archivo

        // Crear un nuevo objeto de tipo ZonaComun con los datos ingresados
        ZonaComun nuevaZona = new ZonaComun(nombreZona, horaInicio, horaFinal, disponibilidad);

        // Añadir la zona a la lista de registros
        zonasComunes.add(nuevaZona);

        // Verificar si el archivo ya existe
        File file = new File(archivo);
        boolean existeArchivo = file.exists();

        // Guardar los datos en el archivo CSV
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            // Escribir encabezado si el archivo es nuevo
            if (!existeArchivo) {
                bw.write("Nombre_Zona;Hora_Inicio;Hora_Final;¿Disponible?\n");
            }
            // Guardar el nuevo registro en formato CSV
            bw.write(String.join(";", nuevaZona.getNombreZona(), nuevaZona.getHoraInicio(), 
                    nuevaZona.getHoraFinal(), nuevaZona.getDisponibilidad()) + "\n");
        } catch (IOException e) {
            e.printStackTrace();  // Manejo de excepciones
        }
    }

    // Método para cargar los registros desde un archivo CSV
    public void importarZonas(String archivo) {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            br.readLine();  // Saltar la primera línea (encabezado)
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";", -1);
                ZonaComun zona = new ZonaComun(campos[0], campos[1], campos[2], campos[3]);
                zonasComunes.add(zona);  // Añadir a la lista
            }
        } catch (IOException e) {
            e.printStackTrace();  // Manejo de excepciones
        }
    }

    // Obtener la lista completa de zonas registradas
    public List<ZonaComun> obtenerZonas() {
        return zonasComunes;
    }

    // Buscar una zona específica por su nombre
    public ZonaComun encontrarZona(String nombre) {
        for (ZonaComun zona : zonasComunes) {
            if (zona.getNombreZona().equals(nombre)) {
                return zona;  // Devolver la zona encontrada
            }
        }
        return null;  // Retornar null si no se encuentra la zona
    }
    
    public void eliminarZona(ZonaComun zona) {
        // Eliminar la zona de la lista
        zonasComunes.remove(zona);
        // También podrías actualizar el archivo CSV si es necesario
        actualizarArchivo();
    }

    private void actualizarArchivo() {
        String archivo = "RegistroZonasComunes.csv";

        // Sobreescribir el archivo con la lista actualizada
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write("Nombre_Zona;Hora_Inicio;Hora_Final;¿Disponible?\n");  // Encabezado

            // Guardar todas las zonas restantes en el archivo CSV
            for (ZonaComun zona : zonasComunes) {
                bw.write(String.join(";", zona.getNombreZona(), zona.getHoraInicio(),
                        zona.getHoraFinal(), zona.getDisponibilidad()) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();  // Manejo de excepciones
        }
    }
    
}
