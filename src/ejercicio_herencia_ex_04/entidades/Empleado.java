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
public class Empleado extends Persona{
    protected Integer anioIncorporacion;
    protected Integer numDespacho;

    public Empleado() {
    }

    public Empleado(Integer anioIncorporacion, Integer numDespacho, String nombre, String apellido, Integer numeroDeID, EstadoCivil estadoCivil) {
        super(nombre, apellido, numeroDeID, estadoCivil);
        this.anioIncorporacion = anioIncorporacion;
        this.numDespacho = numDespacho;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Empleado{" + "anioIncorporacion=" + anioIncorporacion + ", numDespacho=" + numDespacho + '}';
    }
}
