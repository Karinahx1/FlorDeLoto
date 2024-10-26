/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDatos;

import Utilidades.Factura;
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
public class GestionFacturaPDF {
    private final String rutaArchivo = "RegistroFacturas.json";  // Solo manejamos el archivo JSON
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Método para guardar una nueva factura en JSON
    public void guardarFactura(String numeroFactura, String fechaFactura, String propietario, String numeroDocumento, String propiedad, String valorMetroCuadrado, String valorAdministracion, String fechaMaxPago, String totalPagar) {

        List<Factura> facturas = cargarFacturas();  // Cargar facturas existentes

        // Crear la nueva factura con los parámetros recibidos
        Factura nuevaFactura = new Factura(numeroFactura, fechaFactura, propietario, numeroDocumento, propiedad, valorMetroCuadrado, valorAdministracion, fechaMaxPago, totalPagar);

        facturas.add(nuevaFactura);  // Añadir la nueva factura a la lista

        try (Writer writer = new FileWriter(rutaArchivo)) {
            gson.toJson(facturas, writer);  // Guardar la lista en JSON
            System.out.println("Factura guardada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar la factura: " + e.getMessage());
        }

        // Generar el PDF de la factura
        generarPDFFactura(nuevaFactura);
    }

    // Método para cargar facturas desde el archivo JSON
    private List<Factura> cargarFacturas() {
        try (Reader reader = new FileReader(rutaArchivo)) {
            Type listType = new TypeToken<ArrayList<Factura>>() {}.getType();
            return gson.fromJson(reader, listType);  // Devolver la lista de facturas
        } catch (IOException e) {
            System.err.println("Error al cargar las facturas: " + e.getMessage());
            return new ArrayList<>();  // Si hay error, devolver lista vacía
        }
    }

    // Método para generar un PDF de una factura
    private void generarPDFFactura(Factura factura) {
        String nombrePDF = "Factura_" + factura.getNumeroFactura() + ".pdf";
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(nombrePDF));
            document.open();

            // Agregar los datos de la factura al PDF
            document.add(new Paragraph("Número factura : " + factura.getNumeroFactura()));
            document.add(new Paragraph("Fecha: " + factura.getFechaFactura()));
            document.add(new Paragraph("Propietario: " + factura.getPropietario()));
            document.add(new Paragraph("Número documento: " + factura.getNumeroDocumento()));
            document.add(new Paragraph("Propiedad: " + factura.getPropiedad()));
            document.add(new Paragraph("Valor metro cuadrado: " + factura.getValorMetroCuadrado()));
            document.add(new Paragraph("Valor de administración: " + factura.getValorAdministracion()));
            document.add(new Paragraph("Fecha máxima de pago: " + factura.getFechaMaxPago()));
            document.add(new Paragraph("Total a pagar: $" + factura.getTotalPagar()));

            System.out.println("PDF creado exitosamente: " + nombrePDF);
        } catch (DocumentException | IOException e) {
            System.err.println("Error al generar el PDF: " + e.getMessage());
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }
    }
    
    public Factura buscarFacturaParaGestion(String numeroPropiedad) {
        List<Factura> facturas = cargarFacturas(); // Cargar todas las facturas

        for (Factura factura : facturas) {
            // Verificar si la propiedad no es nula y coincide con el número ingresado
            if (factura.getPropiedad() != null && factura.getPropiedad().equals(numeroPropiedad)) {
                return factura; // Retorna la factura encontrada
            }
        }
        return null; // Retorna null si no encuentra la propiedad
    }


    
    public List<Factura> buscarFacturasPorPropiedad(String numeroPropiedad) {
        List<Factura> facturas = cargarFacturas(); // Cargar todas las facturas
        List<Factura> facturasEncontradas = new ArrayList<>();

        for (Factura factura : facturas) {
            if (factura.getPropiedad() != null && 
                factura.getPropiedad().equalsIgnoreCase(numeroPropiedad)) {
                facturasEncontradas.add(factura); // Añadir las facturas encontradas a la lista
            }
        }

        return facturasEncontradas; // Retornar todas las facturas de la propiedad
    }
    
}
