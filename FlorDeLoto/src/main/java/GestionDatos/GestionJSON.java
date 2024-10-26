/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDatos;

import Utilidades.Persona;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karyj
 */
public class GestionJSON {

    public List<Persona> leerJSON(String rutaArchivo) {
        
        List<Persona> propietarios = new ArrayList<>();
        
        try (FileReader reader = new FileReader("RegistroPropietarios.json")) {
            Gson gson = new Gson();
            Type propietariosListType = new TypeToken<ArrayList<Persona>>() {}.getType();
            propietarios = gson.fromJson(reader, propietariosListType);
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
        return propietarios;
    }
        

    private List<Persona> cargarPersonas() {
        List<Persona> personas = new ArrayList<>();
        try {
            FileReader reader = new FileReader("RegistroPropietarios.json");
            Type personaListType = new TypeToken<ArrayList<Persona>>() {}.getType();
            Gson gson = new Gson();
            personas = gson.fromJson(reader, personaListType);
            reader.close();
        } catch (IOException e) {
            System.out.println("No se encontró el archivo. Se creará uno nuevo.");
        }
        return personas;
    }
        

    public void guardarJson(String nombre, String tipoDocumento, String documento, String edad, String correo, String celular, String propiedad, String ocupacion) {

        List<Persona> personas = cargarPersonas();
        Persona nuevaPersona = new Persona(nombre, tipoDocumento, documento, edad, correo, celular, propiedad, ocupacion);
        personas.add(nuevaPersona);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(personas);

        try (FileWriter file = new FileWriter("RegistroPropietarios.json")) {
            file.write(json);
            file.flush();
            System.out.println("Archivo JSON actualizado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public List<String> obtenerOcupacionesCercanas(String propiedadIngresada) {
        List<Persona> listaPersonas = cargarPersonas();
        List<String> ocupacionesCercanas = new ArrayList<>();

        try {
            int propiedad = Integer.parseInt(propiedadIngresada);

            String ocupacionPrevio = "No encontrada";
            String ocupacionActual = "No encontrada";
            String ocupacionSiguiente = "No encontrada";

            for (Persona persona : listaPersonas) {
                int codigoPropiedad = Integer.parseInt(persona.getPropiedad());

                if (codigoPropiedad == propiedad - 1) {
                    ocupacionPrevio = persona.getOcupacion();
                } else if (codigoPropiedad == propiedad) {
                    ocupacionActual = persona.getOcupacion();
                } else if (codigoPropiedad == propiedad + 1) {
                    ocupacionSiguiente = persona.getOcupacion();
                }
            }

            ocupacionesCercanas.add(ocupacionPrevio);
            ocupacionesCercanas.add(ocupacionActual);
            ocupacionesCercanas.add(ocupacionSiguiente);
        } catch (NumberFormatException e) {
            System.err.println("Error: la propiedad ingresada no es un número válido.");
        }

        return ocupacionesCercanas;
    }
    
    public List<String> obtenerOcupacionesDeVecinos(String propiedadIngresada) {
        List<Persona> listaPersonas = cargarPersonas(); // Cargar todas las personas
        List<String> ocupacionesVecinos = new ArrayList<>();

        try {
            int propiedadIngresadaInt = Integer.parseInt(propiedadIngresada);
            int contador = 1; // Contador para los vecinos

            for (Persona persona : listaPersonas) {
                int propiedadPersona = Integer.parseInt(persona.getPropiedad());

                // Omitir la ocupación de la propiedad ingresada
                if (propiedadPersona != propiedadIngresadaInt) {
                    String ocupacion = persona.getOcupacion();
                    if (ocupacion != null && !ocupacion.isEmpty()) {
                        ocupacionesVecinos.add("Vecino " + contador + ": " + ocupacion);
                        contador++; // Incrementar el contador
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: la propiedad ingresada no es un número válido.");
        }

        return ocupacionesVecinos;
    }





}
