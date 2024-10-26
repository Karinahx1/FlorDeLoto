/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDatos;

import Ventanas.Administrador;
import Ventanas.Comprador;
import Ventanas.Empleado;
import Ventanas.Propietario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author karyj
 */
public class ControlUsuarios {
    
    public void autenticarUsuario(String nombreUsuario, String clave, JFrame ventanaActual) {
        String rolUsuario = obtenerRolUsuario(nombreUsuario, clave); 

        if (rolUsuario != null) {
            mostrarVentana(rolUsuario, ventanaActual); 
        } else {
            mostrarMensajeError("Usuario o contraseña incorrectos", ventanaActual);
        }
    }

    private String obtenerRolUsuario(String nombreUsuario, String clave) {
        // datos quemados
        if (nombreUsuario.equals("empleado@gmail.com") && clave.equals("empleado021")) {
            return "Empleado";
        } else if (nombreUsuario.equals("administrador@gmail.com") && clave.equals("administrador022")) {
            return "Administrador";
        } else if (nombreUsuario.equals("propietario@gmail.com") && clave.equals("propietario023")) {
            return "Propietario";
        } else if (nombreUsuario.equals("comprador@gmail.com") && clave.equals("comprador024")) {
            return "Comprador";
        }
        return null; 
    }

    private void mostrarVentana(String rol, JFrame ventanaActual) {
        ventanaActual.setVisible(false);

        switch (rol) {
            case "Empleado":
                new Empleado().setVisible(true);
                break;
            case "Administrador":
                new Administrador().setVisible(true);
                break;
            case "Propietario":
                new Propietario().setVisible(true);
                break;
            case "Comprador": // Agregando el caso para futuro comprador
                new Comprador().setVisible(true);
                break;
            default:
                mostrarMensajeError("Rol no reconocido", ventanaActual);
                break;
        }
    }

    private void mostrarMensajeError(String mensaje, JFrame ventanaActual) {
        JOptionPane.showMessageDialog(ventanaActual, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    
}
