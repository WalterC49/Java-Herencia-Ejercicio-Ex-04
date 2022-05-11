/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_04.entidades.servicios;

import ejercicio_herencia_ex_04.entidades.Estudiante;
import ejercicio_herencia_ex_04.entidades.Persona;
import ejercicio_herencia_ex_04.enumeraciones.EstadoCivil;
import java.util.ArrayList;

/**
 *
 * @author Walter
 */
public class EstudianteServicio {

    public static Estudiante NuevoEstudiante(String nombre, String apellido, Integer numeroDeID, EstadoCivil estadoCivil){
        String curso;
        
        System.out.print("Curso: ");
        curso=MainServicio.leer.next();
        return new Estudiante(curso, nombre, apellido, numeroDeID, estadoCivil);
    }
    
    private static Estudiante SeleccionarEstudiante(ArrayList<Persona> personas){
        //CREO UNA LISTA AUXILIAR DE ESTUDIANTES
        ArrayList<Estudiante> estudiantes = new ArrayList();
        for (Persona persona : personas) {
            if (persona instanceof Estudiante) {
                Estudiante estudiante = (Estudiante) persona;
                estudiantes.add(estudiante);
            }
        }
        
        System.out.println("\nSeleccione un estudiante.");
        
        int i=1;
        for (Estudiante estudiante : estudiantes) {
            System.out.println("\n" +i+ "º Estudiante: ");
            System.out.println(estudiante);
            i++;
        }

        boolean continuar;
        String respuesta;
        do {            
            continuar=false;
            System.out.print("\nEstudiante número: ");
            respuesta=MainServicio.leer.next();
            
            continuar = !MainServicio.ConfirmarNumEntero(respuesta, estudiantes.size());
            
            if(continuar){
                System.out.println("Ingreso no valido.");
            }
        } while (continuar);
        
        return estudiantes.get(Integer.parseInt(respuesta)-1);
    }
    
    public static ArrayList<Persona> MatricularEnNuevoCurso(ArrayList<Persona> personas){
        Estudiante estudiante = SeleccionarEstudiante(personas);
        System.out.println("\nEstudiante selecionado:");
        System.out.println(estudiante);
        
        boolean continuar;
        String respuesta;
        do {   
            continuar=false;
            System.out.print("\n¿Quiere seleccionar a otro estudiante?(S/N) ");
            respuesta=MainServicio.leer.next().toUpperCase();
            switch (respuesta) {
                case "S":
                    MatricularEnNuevoCurso(personas);
                    break;
                case "N":
                    break;
                default:
                    continuar=true;
                    System.out.println("Ingreso no valido");
            }
        } while (continuar);
        
        System.out.print("\nIngrese el nuevo curso para matricular: ");
        respuesta=MainServicio.leer.next();
        
        estudiante.setCurso(respuesta);
        
        System.out.println("\nMatriculación completada.");
        return personas;
    }
}
