package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    //variables para la conexion a la base de datos

    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_blogg";
    static String usuario = "root";
    static String password = "";

    protected Connection conn = null;

    public ConexionDB() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion exitosa");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error en driver" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar:" + e.getMessage());
        }
    }

    //metodo que devuelve la variable para conectar
    public Connection conectar() {
        return conn;
    }

    //metodo para realizar la desconexion de la base de datos
    public void desconectar() {
        //System.out.println("Cerrado la BD:" +conn);
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion:");
        }
    }
}
