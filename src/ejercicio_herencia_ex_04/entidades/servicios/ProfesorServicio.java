/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_04.entidades.servicios;

import ejercicio_herencia_ex_04.entidades.Persona;
import ejercicio_herencia_ex_04.entidades.Profesor;
import ejercicio_herencia_ex_04.enumeraciones.EstadoCivil;
import java.util.ArrayList;

/**
 *
 * @author Walter
 */
public class ProfesorServicio {

    public static Profesor NuevoProfesor(Integer anioIncorporacion, Integer numDespacho, String nombre, String apellido, Integer numeroDeID, EstadoCivil estadoCivil){
        String departamento;
        
        System.out.print("Departamento(lenguajes, matemáticas, arquitectura, etc): ");
        departamento=MainServicio.leer.next();
        
        return new Profesor(departamento, anioIncorporacion, numDespacho, nombre, apellido, numeroDeID, estadoCivil);
    }
    
    private static Profesor SeleccionarProfesor(ArrayList<Persona> personas){
        //CREO UNA LISTA AUXILIAR DE ESTUDIANTES
        ArrayList<Profesor> profesores = new ArrayList();
        for (Persona persona : personas) {
            if (persona instanceof Profesor) {
                Profesor profesor = (Profesor) persona;
                profesores.add(profesor);
            }
        }
        
        System.out.println("\nSeleccione un profesor.");
        
        int i=1;
        for (Profesor profesor : profesores) {
            System.out.println("\n" +i+ "º Profesor: ");
            System.out.println(profesor);
            i++;
        }

        boolean continuar;
        String respuesta;
        do {            
            continuar=false;
            System.out.print("\nProfesor número: ");
            respuesta=MainServicio.leer.next();
            
            continuar = !MainServicio.ConfirmarNumEntero(respuesta, profesores.size());
            
            if(continuar){
                System.out.println("Ingreso no valido.");
            }
        } while (continuar);
        
        return profesores.get(Integer.parseInt(respuesta)-1);
    }
    
    public static ArrayList<Persona> CambiarDepartamento(ArrayList<Persona> personas){
        Profesor profesor = SeleccionarProfesor(personas);
        System.out.println("\nProfesor selecionado:");
        System.out.println(profesor);
        
        boolean continuar;
        String respuesta;
        do {   
            continuar=false;
            System.out.print("\n¿Quiere seleccionar a otro profesor?(S/N) ");
            respuesta=MainServicio.leer.next().toUpperCase();
            switch (respuesta) {
                case "S":
                    CambiarDepartamento(personas);
                    break;
                case "N":
                    break;
                default:
                    continuar=true;
                    System.out.println("Ingreso no valido");
            }
        } while (continuar);
        
        System.out.print("\nIngrese el nuevo departamento para cambiar: ");
        respuesta=MainServicio.leer.next();
        
        profesor.setDepartamento(respuesta);
        
        System.out.println("\nCambio de departamento completado.");
        return personas;
    }
}
