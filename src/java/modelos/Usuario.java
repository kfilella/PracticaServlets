/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author estudiante.2016
 */
public class Usuario {
    private int id;
    private String nombre, email, password, rol, user;

    public Usuario(int id, String email, String rol, String nombre, String password, String user) {
        this.id = id;
        this.email = email;
        this.rol = rol;
        this.nombre = nombre;
        this.password = password;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }
    
    public String getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    
}

