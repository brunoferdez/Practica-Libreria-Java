/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicalibreria;
import control.Control;
import modelo.Libro;
import modelo.Modelo;
import vista.Vista1;

/**
 *
 * @author bruno
 */
public class PracticaLibreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Libro modelo = new Libro();
        Modelo consultas = new Modelo();
        Vista1 vista = new Vista1();
        Control control = new Control(modelo, consultas, vista);
        control.iniciar();
    }
    
}
