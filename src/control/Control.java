/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Libro;
import modelo.Modelo;
import vista.Vista1;

/**
 *
 * @author bruno
 * 
 * En esta clase se realizan las operaciones
 */
public class Control implements ActionListener {
    // Objetos de tipo Libro, Modelo y Vista1 para representar datos y manejar consultas
    private Libro modelo;
    private Modelo consultas;
    private Vista1 vista;
    
    /**
     * Constructor con parámetros que recibe los objetos modelo, consultas y vista
     * Relacionar los listeners para manejar los eventos
     * @param modelo
     * @param consultas
     * @param vista 
     */
    public Control(Libro modelo, Modelo consultas, Vista1 vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        asociarListeners((ActionListener) this);
    }
    
    /**
     * Método para relacionar un ActionListener a cada botón
     * @param l parámetro de tipo ActionListener que se ejecutara al hacer clic en el botón
     */
    private void asociarListeners(ActionListener l) {
        vista.actionListenerBtn1(l);
        vista.actionListenerBtn2(l);
        vista.actionListenerBtn3(l);
        vista.actionListenerBtn4(l);
    }
    
    /**
     * Método que se ejecutara cuando se realice un evento de acción
     * @param e representa el evento que tiene cada botón
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "OBTENER TODOS LOS LIBROS":
                vista.pantalla.setText(consultas.imprimirListaPantalla(consultas.obtenerLibros()));
                consultas.imprimirLista(consultas.obtenerLibros());
                vista.limpiar();
                break;
            case "CREAR LIBRO":
                modelo.setId(vista.getId());
                modelo.setTitulo(vista.getTitulo());
                modelo.setAutor(vista.getAutor());
                modelo.setLeido("No leido");
                modelo.setFecha(vista.getFecha());
                if(consultas.crearLibros(modelo.getId(), modelo.getTitulo(), modelo.getAutor(), modelo.getLeido(), modelo.getFecha())){
                    System.out.println("Insertando libro con estos datos: "+modelo.getId()+" "+modelo.getTitulo()+" "+modelo.getAutor()+" "+modelo.getLeido()+" "+modelo.getFecha());
                }
                else{
                    System.out.println("No se pudo insertar el libro.");
                }
                vista.limpiar();
                break;
            case "ACTUALIZAR LIBRO":
                modelo.setId(vista.getId());
                modelo.setTitulo(vista.getTitulo());
                modelo.setAutor(vista.getAutor());
                modelo.setLeido("No leido");
                modelo.setFecha(vista.getFecha());
                if(consultas.actualizarLibro(modelo)){
                    System.out.println("Modificando libro con id: "+modelo.getId());
                }
                else{
                    System.out.println("No se pudo modificar el libro.");
                }
                vista.limpiar();
                break;
            case "ESTADO":
                modelo.setId(vista.getId());
                modelo.setLeido("Leido");
                if(consultas.actualizarLibro(modelo)){
                    System.out.println("Modificando estado del libro con id: "+modelo.getId());
                }
                else{
                    System.out.println("No se pudo modificar el estado libro.");
                }
                vista.limpiar();
                vista.limpiar();
                break;
        }
    }
    
    /**
     * Método que permite aparecer la vista
     */
    public void iniciar(){
        vista.setTitle("Librería");
        this.vista.setVisible(true);
    }
}
