/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Empleados {
    private int idEmpleado;
    private String nombre, apellidos, direccion, telefono, puesto, correo;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public boolean insertarEmpleado(){
        boolean insercion = false;
        
        //Se conecta con la base de datos de predial
        ConexionMySQL mysql = new ConexionMySQL();
        Connection conexion = null;
        conexion = mysql.conectar();
        PreparedStatement manejadorQuery = null;
        
        String query = "INSERT INTO empleado (nombre, apellidos, direccion, telefono, puesto, correo)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            manejadorQuery = conexion.prepareCall(query);
            manejadorQuery.setString(1, nombre);
            manejadorQuery.setString(2, apellidos);
            manejadorQuery.setString(3, direccion);
            manejadorQuery.setString(4, telefono);
            manejadorQuery.setString(5, puesto);
            manejadorQuery.setString(6, correo);
            
            int resultado = manejadorQuery.executeUpdate();
            
            if(resultado >0){
                insercion = true;
            }else{
                insercion = false;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }     
        finally{//Se utiliza para cerrar la conexion a la BD
            if(manejadorQuery != null){
                try {
                    manejadorQuery.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conexion != null){
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return insercion;
    }
    
    public boolean editarEmpleado(){
        boolean insercion = false;
        
        //Se conecta con la base de datos de predial
        ConexionMySQL mysql = new ConexionMySQL();
        Connection conexion = null;
        conexion = mysql.conectar();
        PreparedStatement manejadorQuery = null;
        
      //  String query = "UPDATE empleado SET (nombre, apellidos, direccion, telefono, puesto, correo)"
      //          + " VALUES (?, ?, ?, ?, ?, ?) WHERE id_empleado='"+idEmpleado+"'";
        
        String query = "UPDATE empleado SET nombre = ?, apellidos = ?, direccion = ? ,"
                + " telefono = ?, puesto = ?, correo = ?"
                + "  WHERE id_empleado='"+idEmpleado+"'";
        
        try {
            manejadorQuery = conexion.prepareCall(query);
            
            manejadorQuery.setString(1, nombre);
            manejadorQuery.setString(2, apellidos);
            manejadorQuery.setString(3, direccion);
            manejadorQuery.setString(4, telefono);
            manejadorQuery.setString(5, puesto);
            manejadorQuery.setString(6, correo);
            
            int resultado = manejadorQuery.executeUpdate();
            
            if(resultado >0){
                insercion = true;
            }else{
                insercion = false;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }     
        finally{//Se utiliza para cerrar la conexion a la BD
            if(manejadorQuery != null){
                try {
                    manejadorQuery.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conexion != null){
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return insercion;
    }
    
    
}