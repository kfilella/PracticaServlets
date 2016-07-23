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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kevin
 */
@WebServlet(name = "EditarUsuario", urlPatterns = {"/edit"})
public class EditarUsuario extends HttpServlet {

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

        response.setContentType("application/json");
        Gson gson = new Gson();
        JsonObject object = new JsonObject();

        String idUser = request.getParameter("editID");
        int id = Integer.parseInt(idUser);
        String user = request.getParameter("editUser");
        String password = request.getParameter("editPassword");
        String nombre = request.getParameter("editNombre");
        String email = request.getParameter("editEmail");
        String rol = request.getParameter("editRol");
            
        if(user.equals("") || password.equals("") || nombre.equals("") || email.equals("") || rol.equals("")){
            object.addProperty("error", Boolean.TRUE);
            object.addProperty("errormsg", "Todos los campos son obligatorios!"); 
        } else{
            UsuarioAccess ua = new UsuarioAccess();
            ua.edit(id, nombre, email, password, rol, user);
            object.addProperty("error", Boolean.FALSE);
            object.addProperty("url", "home");
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
