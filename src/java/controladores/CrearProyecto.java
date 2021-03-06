/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import data_access.ProyectoAccess;
import data_access.UsuarioAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Proyecto;
import modelos.Usuario;

/**
 *
 * @author Kevin
 */
@WebServlet(name = "CrearProyecto", urlPatterns = {"/createp"})
public class CrearProyecto extends HttpServlet {

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
        int id_usuario = 0;
        String idUser = request.getParameter("selectUser");
        id_usuario = Integer.parseInt(idUser);
        String nombre = request.getParameter("proyNombre");
        String descripcion = request.getParameter("proyDescripcion");
        
        response.setContentType("application/json");
        Gson gson = new Gson();
        JsonObject object = new JsonObject();
        
        if(id_usuario == 0 || nombre.equals("") || descripcion.equals("")){
            object.addProperty("error", Boolean.TRUE);
            object.addProperty("errormsg", "Todos los campos son obligatorios!"); 
        } else{
            Proyecto proy = new Proyecto(id_usuario, nombre, descripcion);
            ProyectoAccess pa = new ProyectoAccess();
            int id = pa.create(proy);
            ArrayList<Proyecto> proyectos = ProyectoAccess.getAll();
            ArrayList<Usuario> usuario = UsuarioAccess.getUsuarioById(id_usuario);
            object.addProperty("error", Boolean.FALSE);
            object.addProperty("proyecto", gson.toJson(proy));
            object.addProperty("usuario", gson.toJson(usuario.get(0)));
            object.addProperty("lastnum", proyectos.size());
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
