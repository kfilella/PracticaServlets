/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import database.C_ConexionSQL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author estudiante.2016
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        response.setContentType("application/json");
        
        Gson gson = new Gson();
        JsonObject object = new JsonObject();
        
        if (usuario.equals("admin") && password.equals("1234")){
            /*
            C_ConexionSQL connect=new C_ConexionSQL();
            Connection con=connect.Conexion_SQL();
            try {
                PreparedStatement query = (PreparedStatement) con.prepareStatement("insert into practicaservlets.usuario (email,rol,nombre,password) values (?,?,?,?)");
                query.setString(1, "email@email.com");
                query.setString(2, "rol");
                query.setString(3, "nombre");                        
                query.setString(4, "password");
                query.executeUpdate();
                object.addProperty("error", Boolean.FALSE);
                object.addProperty("url", "home.jsp");
            }catch(SQLException e){
                object.addProperty("error", Boolean.TRUE);
                object.addProperty("errormsg", "Error SQL");  
            }
            */
            object.addProperty("error", Boolean.FALSE);
            object.addProperty("url", "home.jsp");
        }else{
            object.addProperty("error", Boolean.TRUE);
            object.addProperty("errormsg", "Usuario o contraseña incorrecta");            
        }

 
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(object));
        out.flush();
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
