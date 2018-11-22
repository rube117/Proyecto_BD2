/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jc.controlador;

import com.jc.modelo.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author campitos
 */
public class ServletAutenticar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            String algo=request.getParameter("usuario");
            String otro=request.getParameter("password");
            
            Connection con=      Conexion.conectarse(otro, algo,"xe" );
            
            RequestDispatcher despachar=request.getRequestDispatcher("/index.jsp");
            despachar.forward(request, response);
            
        } catch (Exception ex) {
             RequestDispatcher despachar=request.getRequestDispatcher("/error.jsp");
            despachar.forward(request, response);
            
        }
            
      
        }
            
         
          
            
       
    
}