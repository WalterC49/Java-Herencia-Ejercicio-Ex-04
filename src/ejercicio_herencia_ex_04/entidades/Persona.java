/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_04.entidades;

import ejercicio_herencia_ex_04.enumeraciones.EstadoCivil;

/**
 *
 * @author Walter
 */
public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected Integer numeroDeID;
    protected EstadoCivil estadoCivil;

    public Persona() {
    }

    public Persona(String nombre, String apellido, Integer numeroDeID, EstadoCivil estadoCivil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDeID = numeroDeID;
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", numeroDeID=" + numeroDeID + ", estadoCivil=" + estadoCivil.getValor()
                + '}';
    }
}
