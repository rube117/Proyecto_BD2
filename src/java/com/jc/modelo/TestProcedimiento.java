/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jc.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author campitos
 */
public class TestProcedimiento {

    public static void main(String args[]) throws Exception {
       
    //Invocamos el procedimiento
    basico();
    
        
    }

    public static void basico() throws Exception {
       
        Connection con = Conexion.conectarse("system", "system", "xe");
        CallableStatement callate = con.prepareCall("{call guardar_almacen(?,?)}");
        callate.setInt(1,-3);
        callate.setString(2,"almacen unitec" );
  
 
        callate.execute();
  
      
        System.out.println("El registro se guardo con exito!!! ");
    }

    public static void tablaGuardarPelicula() throws Exception {
        Conexion c = new Conexion();
        Connection con = c.conectarse();
        CallableStatement callate = con.prepareCall("{call guardar_pelicula(?,?,?)}");
        callate.registerOutParameter(1, java.sql.Types.INTEGER);
        callate.setString(2, "jurassic park");
        callate.setString(3, "Promete ser buena");

        callate.execute();
        int pk = callate.getInt(1);
        System.out.println("El id ingresado es:" + pk);
    }

}
