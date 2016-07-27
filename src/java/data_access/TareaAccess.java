/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access;
import java.sql.*;
import java.util.*;
import database.C_ConexionSQL;
import modelos.Tarea;
import com.mysql.jdbc.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiante.2016
 */
public class TareaAccess {
    
    public int create(Tarea tarea){
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "insert into practicaservlets.tarea (id_proyecto,titulo,estado) values (?,?,?)";
        String sql2 = "select LAST_INSERT_ID() from practicaservlets.tarea";
        int id = 0;
        try {
            PreparedStatement query = (PreparedStatement) con.prepareStatement(sql);
            query.setInt(1, tarea.getId_proyecto());
            query.setString(2, tarea.getTitulo());
            query.setString(3, tarea.getEstado());                        
            query.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(TareaAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           ResultSet rs = con.prepareStatement(sql2).executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
        }catch (SQLException ex) {
            Logger.getLogger(TareaAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public void edit(int id, int id_proyecto, String titulo, String estado){
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "update practicaservlets.tarea set id_proyecto = ?, titulo = ?, estado = ?" + " where id = ?";
        try {
            PreparedStatement query = (PreparedStatement) con.prepareStatement(sql);
            query.setInt(1, id_proyecto);
            query.setString(2, titulo);                        
            query.setString(3, estado);
            query.setInt(4, id);
            query.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(TareaAccess.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void delete(int id){
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "delete from practicaservlets.tarea where id = ?";
        try {
            PreparedStatement query = (PreparedStatement) con.prepareStatement(sql);
            query.setInt(1, id);
            query.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(TareaAccess.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static ArrayList<Tarea> getAll(){
        ArrayList<Tarea> tareas = new ArrayList<>();
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "select * from practicaservlets.tarea";
        try {
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            while(rs.next()){
                Tarea tarea = new Tarea(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                tareas.add(tarea);
            }
        }catch (SQLException ex) {
            Logger.getLogger(TareaAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tareas;
    }   
    
    public static ArrayList<Tarea> getTareaById(int id){
        ArrayList<Tarea> tareas = new ArrayList<>();
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "select * from practicaservlets.tarea where id = " +id;
        try {
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            while(rs.next()){
                Tarea tarea = new Tarea(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                tareas.add(tarea);
            }
        }catch (SQLException ex) {
            Logger.getLogger(TareaAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tareas;
    }
}
