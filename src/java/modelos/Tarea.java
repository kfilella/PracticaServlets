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
public class Tarea {
    private int id, id_proyecto;
    private String titulo, estado;

    public Tarea(int id, int id_proyecto, String titulo, String estado) {
        this.id = id;
        this.id_proyecto = id_proyecto;
        this.titulo = titulo;
        this.estado = estado;
    }
    
    public Tarea(int id_proyecto, String titulo, String estado) {
        this.id_proyecto = id_proyecto;
        this.titulo = titulo;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
