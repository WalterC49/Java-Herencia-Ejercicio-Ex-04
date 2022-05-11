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
public class Profesor extends Empleado{
    private String departamento;

    public Profesor() {
    }

    public Profesor(String departamento, Integer anioIncorporacion, Integer numDespacho, String nombre, String apellido, Integer numeroDeID, EstadoCivil estadoCivil) {
        super(anioIncorporacion, numDespacho, nombre, apellido, numeroDeID, estadoCivil);
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Profesor{" + "departamento=" + departamento + '}';
    }
}
