/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import data_access.UsuarioAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Usuario;
/**
 *
 * @author Kevin
 */
@WebServlet(name = "CrearUsuario", urlPatterns = {"/create"})
public class CrearUsuario extends HttpServlet {

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
        String user = request.getParameter("inputUser");
        String password = request.getParameter("inputPassword");
        String nombre = request.getParameter("inputNombre");
        String email = request.getParameter("inputEmail");
        String rol = request.getParameter("selectRol");
        
        response.setContentType("application/json");
        Gson gson = new Gson();
        JsonObject object = new JsonObject();
        
        if(user.equals("") || password.equals("") || nombre.equals("") || email.equals("") || rol.equals("")){
            object.addProperty("error", Boolean.TRUE);
            object.addProperty("errormsg", "Todos los campos son obligatorios!"); 
        } else{
            Usuario usuario = new Usuario(email, rol, nombre, password, user);
            UsuarioAccess ua = new UsuarioAccess();
            int id = ua.create(usuario);
            ArrayList<Usuario> usuarios = UsuarioAccess.getAll();
            object.addProperty("error", Boolean.FALSE);
            object.addProperty("usuario", gson.toJson(usuario));
            object.addProperty("lastnum", usuarios.size());
            object.addProperty("id", id);
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
