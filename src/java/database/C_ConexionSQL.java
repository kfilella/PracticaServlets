
package database;

import java.sql.*;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class C_ConexionSQL {
    
    public Connection Conexion_SQL(){
        Connection conexion=null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/practicaservlets", "root", "");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de Conexion");
        }
        return conexion;      
    }
}
