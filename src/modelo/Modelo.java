/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 * 
 * En esta clase se crean los métodos necesarior para realizar las operaciones
 */
public class Modelo {
    // Una lista de tipo Libro para introducir libros
    List<Libro> libros = new ArrayList<>();
    
    /**
     * Método para obtener los datos de los libros
     * @return 
     */
    public List<Libro> obtenerLibros() {
        String consulta = "SELECT * FROM libro";
        Connection con = null;
        
        try {
            con = Conexion.conectar(); 
            Statement stmt = con.createStatement();
            ResultSet resultados = stmt.executeQuery(consulta);

            while (resultados.next()) {
                String id = resultados.getString("id");
                String titulo = resultados.getString("titulo");
                String autor = resultados.getString("autor");
                String leido = resultados.getString("leido");
                String fecha = resultados.getString("fecha");
                libros.add(new Libro(id, titulo, autor, leido, fecha));
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar o realizar operaciones en la base de datos: " + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
        return libros;
    }
    
    /**
     * Método para crear libros
     * @param id
     * @param titulo
     * @param autor
     * @param leido
     * @param fecha
     * @return 
     */
    public boolean crearLibros(String id, String titulo, String autor, String leido, String fecha) {
        String sentenciaSql = "INSERT INTO libro (id, titulo, autor, leido, fecha) VALUES (?, ?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean creador = false;
        
        try {
            con = Conexion.conectar(); 
            sentencia = con.prepareStatement(sentenciaSql);
            sentencia.setString(1, id);
            sentencia.setString(2, titulo);
            sentencia.setString(3, autor);
            sentencia.setString(4, leido);
            sentencia.setString(5, fecha);
            sentencia.executeUpdate();
            creador = true;
        } catch (SQLException sqle) {
            System.out.println("Error al insertar libro: " + sqle.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException sqle) {
                    System.out.println("Error al cerrar el PreparedStatement: " + sqle.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqle) {
                    System.out.println("Error al cerrar la conexión: " + sqle.getMessage());
                }
            }
        }
        return creador;
    }
    
    /**
     * Método para imprimir los datos de cada libro por consola
     * @param libros parámetro de tipo lista para representar el contenido de la lista de libros
     */
    public void imprimirLista(List<Libro> libros) {
        for(int i=0; i<libros.size(); i++){
            System.out.println(libros.get(i));
        }
    }
    
    /**
     * Método para imprimir los datos de cada libro en el JTextArea
     * @param libros parámetro de tipo lista para representar el contenido de la lista de libros
     * @return 
     */
    public String imprimirListaPantalla(List<Libro> libros) {
        String listado = "";
        for(int i=0; i<libros.size(); i++){
            listado += libros.get(i)+"\n";
        }
        return listado;
    }
    
    /**
     * Método para actualizar los datos de un libro
     * @param libros parámetro de tipo libro para representar el libro
     * @return 
     */
    public boolean actualizarLibro(Libro libros) {
        String consulta = "UPDATE libro SET titulo = ?, autor = ?, leido = ?, fecha = ? WHERE id = ?";
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean modificado = false;
        
        try {
            con = Conexion.conectar(); 
            sentencia = con.prepareStatement(consulta);
            sentencia.setString(1, libros.getTitulo());
            sentencia.setString(2, libros.getAutor());
            sentencia.setString(3, libros.getLeido());
            sentencia.setString(4, libros.getFecha());
            sentencia.setString(5, libros.getId());
            sentencia.executeUpdate();
            modificado = true;
        } catch (SQLException sqle) {
            System.out.println("Error al modificar libro: " + sqle.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException sqle) {
                    System.out.println("Error al cerrar el PreparedStatement: " + sqle.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqle) {
                    System.out.println("Error al cerrar la conexión: " + sqle.getMessage());
                }
            }
        }
        return modificado;
    }
    
    /**
     * Método para actualizar el estado de un libro
     * @param libros parámetro de tipo libro para representar el libro
     * @return 
     */
    public boolean estadoLibro(Libro libros) {
        String consulta = "UPDATE libro SET leido = ? WHERE id = ?";
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean modificado = false;
        
        try {
            con = Conexion.conectar(); 
            sentencia = con.prepareStatement(consulta);
            sentencia.setString(1, libros.getTitulo());
            sentencia.setString(2, libros.getAutor());
            sentencia.setString(3, libros.getLeido());
            sentencia.setString(4, libros.getFecha());
            sentencia.setString(5, libros.getId());
            sentencia.executeUpdate();
            modificado = true;
        } catch (SQLException sqle) {
            System.out.println("Error al modificar estado libro: " + sqle.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException sqle) {
                    System.out.println("Error al cerrar el PreparedStatement: " + sqle.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqle) {
                    System.out.println("Error al cerrar la conexión: " + sqle.getMessage());
                }
            }
        }
        return modificado;
    }
}
