/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author bruno
 * 
 * Está clase representará los datos de cada libro
 */
public class Libro {
    // Variables para representar cada dato
    private String id;
    private String titulo;
    private String autor;
    private String leido;
    private String fecha;

    /**
     * Un constructor vacío para crear instancias y posteriormente establecer los datos de cada libro
     */
    public Libro() {
    }

    /**
     * Un constructor con parámetros para iniciar directamente cada atributo
     * @param id
     * @param titulo
     * @param autor
     * @param leido
     * @param fecha 
     */
    public Libro(String id, String titulo, String autor, String leido, String fecha) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.leido = leido;
        this.fecha = fecha;
    }

    /**
     * Métodos getter y setter para recibir o modificar el contenido de cada String
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLeido() {
        return leido;
    }

    public void setLeido(String leido) {
        this.leido = leido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * 
     * @return devuelve una cadena con los datos de cada libro
     */
    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", leido=" + leido + ", fecha=" + fecha + '}';
    }
}
