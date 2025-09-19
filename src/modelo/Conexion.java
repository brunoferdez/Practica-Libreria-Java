/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author bruno
 * 
 * Está clase establecerá la conexión con la base de datos
 */
public class Conexion {
    // Representar los datos de configuración definidos como costantes
    private static final String bd = "****"; // Específicar el nombre de la base de datos
    private static final String url = "****"+bd; // Específicar el url de conexión
    private static final String usuario = "****"; // Específicar el nombre de usuario de la base de datos
    private static final String contraseña = "****"; // Específicar la contraseña del usuario de la base de datos
    
    /**
     * Método para establecer la conexión con la base de datos
     * @return un objetos tipo Connection para determinar si se ha conectado con la base de datos
     */
    public static Connection conectar(){
        Connection con = null; 
        try {
             con = DriverManager.getConnection(url, usuario, contraseña);
        } catch (Exception e){
            System.out.println("Error al conectar o realizar operaciones en la base de datos: " + e.getMessage());
        }
        return con;
    }
}
