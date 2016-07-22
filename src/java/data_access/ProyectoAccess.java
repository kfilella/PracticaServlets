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
    
    public void create(Proyecto proy){
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "insert into practicaservlets.proyecto (id_usuario,nombre,descripcion) values (?,?,?)";
        try {
            PreparedStatement query = (PreparedStatement) con.prepareStatement(sql);
            query.setInt(1, proy.getId_usuario());
            query.setString(2, proy.getNombre());
            query.setString(3, proy.getDescripcion());                        
            query.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(ProyectoAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public static List<Proyecto> getAll(){
        List<Proyecto> proys = new LinkedList<>();
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
}