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
public final class Estudiante extends Persona{
    private String curso;

    public Estudiante() {
    }

    public Estudiante(String curso, String nombre, String apellido, Integer numeroDeID, EstadoCivil estadoCivil) {
        super(nombre, apellido, numeroDeID, estadoCivil);
        this.curso = curso;
    }

    
    public void setCurso(String curso){
        this.curso = curso;
    }
    
    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Curso: " + curso;
    }
}
