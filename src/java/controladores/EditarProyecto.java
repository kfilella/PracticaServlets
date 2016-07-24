/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import data_access.ProyectoAccess;
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
@WebServlet(name = "EditarProyecto", urlPatterns = {"/editproy"})
public class EditarProyecto extends HttpServlet {

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

        String idProy = request.getParameter("proyID");
        //int id = Integer.parseInt(idProy);
        String nombre = request.getParameter("proyNombre");
        String descripcion = request.getParameter("proyDescripcion");
        int id_usuario = 0;
        String idUser = request.getParameter("proyUser");
        id_usuario = Integer.parseInt(idUser);
          
        if(id_usuario == 0 || nombre.equals("") || descripcion.equals("")){
            object.addProperty("error", Boolean.TRUE);
            object.addProperty("errormsg", "Todos los campos son obligatorios!"); 
        } else{
            ProyectoAccess pa = new ProyectoAccess();
            pa.edit(Integer.parseInt(idProy), id_usuario, nombre, descripcion);
            object.addProperty("error", Boolean.FALSE);
            object.addProperty("url", "proyectos");
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
