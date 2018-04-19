/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionMySQL {
    //Para conectar Java con MySQL se necesitan principalmente 4 parametros
    //El primero es el nombre de la base de datos
    public String db = "almacenraise";
    //El segundo es la url del servidor de base de satos en donde se encuentra alojada
    public String url = "jdbc:mysql://localhost/"+db;
    //El terero es el usaurio de la base de datos
    public String user = "root";
    //EL cuarto es la contraseña de la base de datos
    public String pass = "";
    
    public Connection conectar()
    {
        Connection link = null;
        
        try
        {
            Class.forName("org.gjt.mm.mysql.Driver");            
            link = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return link;
    }
    
}
