/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDatos;


import javax.swing.JOptionPane;




/**
 *
 * @author karyj
 */
public class Validacion {
    
    public boolean validarDatosRegistro(String nombre, String tipoDocumento, String numeroDocumento, String edad, 
                                         String email, String celular, String propiedad, String ocupacion) {

        // Validar que todos los campos estén llenos
        if (estaVacio(nombre, tipoDocumento, numeroDocumento, edad, email, celular, propiedad, ocupacion)) {
            mostrarError("Todos los campos son obligatorios.");
            return false;
        }

        // Validar que el nombre solo contenga letras y espacios
        if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            mostrarError("El nombre solo debe contener letras y espacios.");
            return false;
        }

        // Validar que la edad sea numérica y esté entre 1 y 100 años
        if (!esNumerico(edad)) {
            mostrarError("La edad debe ser un número entero.");
            return false;
        }

        // Validar que el tipo de documento no sea "Seleccionar"
        if (tipoDocumento.equalsIgnoreCase("Seleccionar")) {
            mostrarError("Debe seleccionar un tipo de documento válido.");
            return false;
        }

        // Validar que el documento sea numérico y no exceda 10 dígitos
        if (!esNumerico(numeroDocumento) || numeroDocumento.length() > 10) {
            mostrarError("El documento debe ser un número de máximo 10 dígitos.");
            return false;
        }

        // Validar el formato del correo
        if (!esCorreoValido(email)) {
            mostrarError("El correo electrónico no tiene un formato válido.");
            return false;
        }

        // Validar que el celular sea numérico y tenga entre 7 y 15 dígitos
        if (!esNumerico(celular) || celular.length() < 7 || celular.length() > 15) {
            mostrarError("El celular debe contener solo números y tener entre 7 y 15 dígitos.");
            return false;
        }

        // Validar que la propiedad no esté vacía
        if (propiedad.trim().isEmpty()) {
            mostrarError("La propiedad no puede estar vacía.");
            return false;
        }

        // Validar que la ocupación solo contenga letras y espacios
        if (!ocupacion.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            mostrarError("La ocupación solo debe contener letras y espacios.");
            return false;
        }

        // Si todas las validaciones pasan
        return true;
    }

    // Validar datos de la clase Factura
    public boolean validarDatosFactura(String numeroFactura, String fechaFactura, String propietario, 
                                        String numeroDocumento, String propiedad, String valorMetroCuadrado, 
                                        String valorAdministracion, String fechaMaxPago, String totalPagar) {

        // Verificar si algún campo está vacío
        if (estaVacio(numeroFactura, fechaFactura, propietario, numeroDocumento, 
                      propiedad, valorMetroCuadrado, valorAdministracion, 
                      fechaMaxPago, totalPagar)) {
            mostrarError("Todos los campos son obligatorios.");
            return false;
        }

        // Validar que el número de factura sea numérico
        if (!esNumerico(numeroFactura)) {
            mostrarError("El número de factura debe ser numérico.");
            return false;
        }

        // Validar el formato de la fecha de la factura (dd/MM/yyyy)
        if (!esFechaValida(fechaFactura)) {
            mostrarError("La fecha de la factura no tiene un formato válido (dd/MM/yyyy).");
            return false;
        }

        // Validar que el propietario solo contenga letras y espacios
        if (!propietario.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            mostrarError("El nombre del propietario solo debe contener letras y espacios.");
            return false;
        }

        // Validar que el número de documento sea numérico y tenga máximo 10 dígitos
        if (!esNumerico(numeroDocumento) || numeroDocumento.length() > 10) {
            mostrarError("El número de documento debe ser numérico y de máximo 10 dígitos.");
            return false;
        }

        // Validar que el valor del metro cuadrado sea numérico y positivo
        if (!esDecimalPositivo(valorMetroCuadrado)) {
            mostrarError("El valor por metro cuadrado debe ser un número positivo.");
            return false;
        }

        // Validar que el valor de la administración sea numérico y positivo
        if (!esDecimalPositivo(valorAdministracion)) {
            mostrarError("El valor de la administración debe ser un número positivo.");
            return false;
        }

        // Validar el formato de la fecha máxima de pago (dd/MM/yyyy)
        if (!esFechaValida(fechaMaxPago)) {
            mostrarError("La fecha máxima de pago tiene un formato válido (dd/MM/yyyy).");
            return false;
        }

        // Validar que el total a pagar sea numérico y positivo
        if (!esDecimalPositivo(totalPagar)) {
            mostrarError("El total a pagar debe ser un número positivo.");
            return false;
        }

        // Si todas las validaciones pasan
        return true;
    }

    // Validar datos de la clase Multa
    public boolean validarDatosMulta(String codigoMulta, String fechaMulta, String persona, String numeroDocumento, 
                                      String lugarInfraccion, String fechaInfraccion, String descripcion, 
                                      String fechaMaxPago, String totalPagar) {

        // Verificar si los campos están vacíos
        if (codigoMulta.isEmpty() || fechaMulta.isEmpty() || persona.isEmpty() || numeroDocumento.isEmpty() ||
            lugarInfraccion.isEmpty() || fechaInfraccion.isEmpty() || descripcion.isEmpty() || fechaMaxPago.isEmpty() || 
            totalPagar.isEmpty()) {
            mostrarError("Todos los campos son obligatorios.");
            return false;
        }

        // Verificar que el código de multa sea numérico
        if (!esNumerico(codigoMulta)) {
            mostrarError("El código de multa debe ser un número válido.");
            return false;
        }

        // Validar el formato de la fecha (Ejemplo: "dd/MM/yyyy")
        if (!esFechaValida(fechaMulta) || !esFechaValida(fechaInfraccion) || !esFechaValida(fechaMaxPago)) {
            mostrarError("Las fechas deben tener el formato dd/MM/yyyy.");
            return false;
        }

        // Verificar que el valor total a pagar sea numérico
        if (!esDecimalPositivo(totalPagar)) {
            mostrarError("El total a pagar debe ser un número positivo.");
            return false;
        }

        // Si todas las validaciones pasan
        return true;
    }

    // Métodos de apoyo (ejemplo)
    private boolean estaVacio(String... campos) {
        for (String campo : campos) {
            if (campo == null || campo.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
    }

    private boolean esNumerico(String cadena) {
        return cadena != null && cadena.matches("\\d+");
    }

    private boolean esCorreoValido(String correo) {
        return correo != null && correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    private boolean esFechaValida(String fecha) {
        // Implementa la validación de la fecha aquí
        return true; // Placeholder
    }

    private boolean esDecimalPositivo(String valor) {
        return valor != null && valor.matches("\\d+(\\.\\d+)?") && Double.parseDouble(valor) > 0;
    }

}
