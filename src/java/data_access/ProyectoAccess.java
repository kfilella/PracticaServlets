/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access;
import java.sql.*;
import java.util.*;
import database.C_ConexionSQL;
import modelos.Proyecto;
import com.mysql.jdbc.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiante.2016
 */
public class ProyectoAccess {
    
    public int create(Proyecto proy){
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "insert into practicaservlets.proyecto (id_usuario,nombre,descripcion) values (?,?,?)";
        String sql2 = "select LAST_INSERT_ID() from practicaservlets.proyecto";
        int id = 0;
        try {
            PreparedStatement query = (PreparedStatement) con.prepareStatement(sql);
            query.setInt(1, proy.getId_usuario());
            query.setString(2, proy.getNombre());
            query.setString(3, proy.getDescripcion());                        
            query.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(ProyectoAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           ResultSet rs = con.prepareStatement(sql2).executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public void edit(int id, int id_usuario, String nombre, String descripcion){
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "update practicaservlets.proyecto set id_usuario = ?, nombre = ?, descripcion = ?" + " where id = ?";
        try {
            PreparedStatement query = (PreparedStatement) con.prepareStatement(sql);
            query.setInt(1, id_usuario);
            query.setString(2, nombre);                        
            query.setString(3, descripcion);
            query.setInt(4, id);
            query.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(ProyectoAccess.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void delete(int id){
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "delete from practicaservlets.proyecto where id = ?";
        try {
            PreparedStatement query = (PreparedStatement) con.prepareStatement(sql);
            query.setInt(1, id);
            query.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(ProyectoAccess.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static ArrayList<Proyecto> getAll(){
        ArrayList<Proyecto> proys = new ArrayList<>();
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "select * from practicaservlets.proyecto";
        try {
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            while(rs.next()){
                Proyecto proy = new Proyecto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                proys.add(proy);
            }
        }catch (SQLException ex) {
            Logger.getLogger(ProyectoAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proys;
    }   
    
    public static ArrayList<Proyecto> getProyectoById(int id){
        ArrayList<Proyecto> proyectos = new ArrayList<>();
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "select * from practicaservlets.proyecto where id = " +id;
        try {
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            while(rs.next()){
                Proyecto proy = new Proyecto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                proyectos.add(proy);
            }
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(proyectos);
        return proyectos;
    }
}
