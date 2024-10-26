/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDatos;
import Utilidades.Multa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karyj
 */
public class GestionMultaPDF {
    
    private final String rutaArchivoJSON = "RegistroMultas.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Método para guardar una nueva multa en JSON
    public void guardarMulta(String codigoMulta, String fechaMulta, String persona, String numeroDocumento, String lugarInfraccion, String fechaInfraccion, String descripcion, String fechaMaxPago, String totalPagar) {

        List<Multa> multas = cargarMultas();

        // Crear una nueva instancia de Multa con los valores en el orden correcto
        Multa nuevaMulta = new Multa(codigoMulta, fechaMulta, persona, numeroDocumento, lugarInfraccion, fechaInfraccion, descripcion, fechaMaxPago, totalPagar);
        multas.add(nuevaMulta);

        // Guardar la lista actualizada en el archivo JSON
        try (Writer writer = new FileWriter(rutaArchivoJSON)) {
            gson.toJson(multas, writer);
            System.out.println("Multa guardada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar la multa: " + e.getMessage());
        }
    }

    // Método para cargar todas las multas desde el archivo JSON
    private List<Multa> cargarMultas() {
        try (Reader reader = new FileReader(rutaArchivoJSON)) {
            Type listType = new TypeToken<ArrayList<Multa>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.err.println("Error al cargar las multas: " + e.getMessage());
            return new ArrayList<>(); // Retorna una lista vacía si no se encuentra el archivo
        }
    }

    // Método para buscar una multa por su código
    public Multa buscarMulta(String codigoMulta) {
        List<Multa> multas = cargarMultas();
        for (Multa multa : multas) {
            if (multa.getCodigoMulta().equals(codigoMulta)) {
                return multa;
            }
        }
        System.out.println("Multa no encontrada.");
        return null;
    }

    // Método para generar un PDF con los datos de una multa
    public void generarPDFMulta(Multa multa) {
        if (multa == null) {
            System.out.println("No se pudo generar el PDF. La multa es nula.");
            return;
        }

        String archivoPDF = "Multa_" + multa.getCodigoMulta() + ".pdf";
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(archivoPDF));
            document.open();

            // Agregar los atributos en el orden correcto
            document.add(new Paragraph("Código de Multa: " + multa.getCodigoMulta()));
            document.add(new Paragraph("Fecha de Multa: " + multa.getFechaMulta()));
            document.add(new Paragraph("Persona: " + multa.getPersona()));
            document.add(new Paragraph("Número de Documento: " + multa.getNumeroDocumento()));
            document.add(new Paragraph("Lugar de Infracción: " + multa.getLugarInfraccion()));
            document.add(new Paragraph("Fecha de Infracción: " + multa.getFechaInfraccion()));
            document.add(new Paragraph("Descripción: " + multa.getDescripcion()));
            document.add(new Paragraph("Fecha Máxima de Pago: " + multa.getFechaMaxPago()));
            document.add(new Paragraph("Total a Pagar: $" + multa.getTotalPagar()));

            System.out.println("PDF creado exitosamente: " + archivoPDF);
        } catch (DocumentException | IOException e) {
            System.err.println("Error al generar el PDF: " + e.getMessage());
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }
    }
    
    public List<Multa> obtenerMultasPorDocumento(String documento) {
        List<Multa> listaMultas = cargarMultas(); // Cargar todas las multas
        List<Multa> multasAsociadas = new ArrayList<>();

        for (Multa sancion : listaMultas) {
            // Verificar si el documento no es nulo y coincide con el ingresado
            if (sancion.getNumeroDocumento() != null && sancion.getNumeroDocumento().equalsIgnoreCase(documento)) {
                multasAsociadas.add(sancion); // Añadir la multa a la lista
            }
        }

        return multasAsociadas; // Retornar todas las multas asociadas al documento
    }

    
}
