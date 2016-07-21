/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Kevin
 */
public class Proyecto {
    private int id, id_usuario;
    private String nombre, descripcion;

    public Proyecto(int id, int id_usuario, String nombre, String descripcion) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
