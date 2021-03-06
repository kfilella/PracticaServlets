/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access;
import java.sql.*;
import java.util.*;
import database.C_ConexionSQL;
import modelos.Usuario;
import com.mysql.jdbc.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiante.2016
 */
public class UsuarioAccess {
    
    public int create(Usuario user){
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "insert into practicaservlets.usuario (email,rol,nombre,password,user) values (?,?,?,?,?)";
        String sql2 = "select LAST_INSERT_ID() from practicaservlets.usuario";
        int id = 0;
        try {
            PreparedStatement query = (PreparedStatement) con.prepareStatement(sql);
            query.setString(1, user.getEmail());
            query.setString(2, user.getRol());
            query.setString(3, user.getNombre());                        
            query.setString(4, user.getPassword());
            query.setString(5, user.getUser());
            query.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioAccess.class.getName()).log(Level.SEVERE, null, ex);
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

    public void edit(int id, String nombre, String email, String password, String rol, String user){
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "update practicaservlets.usuario set email = ?, rol = ?, nombre = ?, password = ?, user = ?" + " where id = ?";
        try {
            PreparedStatement query = (PreparedStatement) con.prepareStatement(sql);
            query.setString(1, email);
            query.setString(2, rol);
            query.setString(3, nombre);                        
            query.setString(4, password);
            query.setString(5, user);
            query.setInt(6, id);
            query.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioAccess.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void delete(int id){
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "delete from practicaservlets.usuario where id = ?";
        try {
            PreparedStatement query = (PreparedStatement) con.prepareStatement(sql);
            query.setInt(1, id);
            query.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioAccess.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static ArrayList<Usuario> getAll(){
        ArrayList<Usuario> users = new ArrayList<>();
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "select * from practicaservlets.usuario";
        try {
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            while(rs.next()){
                Usuario user = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                users.add(user);
            }
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }  
    
    public static ArrayList<Usuario> getUsuarioById(int id){
        ArrayList<Usuario> users = new ArrayList<>();
        C_ConexionSQL connect = new C_ConexionSQL();
        Connection con = connect.Conexion_SQL();
        String sql = "select * from practicaservlets.usuario where id = " +id;
        try {
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            while(rs.next()){
                Usuario user = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                users.add(user);
            }
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
}
