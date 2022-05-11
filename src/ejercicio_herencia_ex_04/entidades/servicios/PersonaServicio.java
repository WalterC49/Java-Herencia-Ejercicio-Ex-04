/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_04.entidades.servicios;

import ejercicio_herencia_ex_04.entidades.Estudiante;
import ejercicio_herencia_ex_04.entidades.Persona;
import ejercicio_herencia_ex_04.entidades.PersonalDeServicio;
import ejercicio_herencia_ex_04.entidades.Profesor;
import ejercicio_herencia_ex_04.enumeraciones.EstadoCivil;
import java.util.ArrayList;

/**
 *
 * @author Walter
 */
public class PersonaServicio {
    
    public static ArrayList<Persona> ListaTest(){
        ArrayList<Persona> listaTest = new ArrayList();
        
        listaTest.add(new Estudiante("Sistemas", "Raúl", "Acosta", 25789741, EstadoCivil.CASADO));
        listaTest.add(new Estudiante("Informatica", "Juan", "Gomez", 15489258, EstadoCivil.DIVORCIADO));
        listaTest.add(new Profesor("Lengua", 1988, 55, "Marcos", "Crespín", 21456963, EstadoCivil.SOLTERO));
        listaTest.add(new Profesor("Matematicas", 1997, 38, "Jorge", "Pérez", 21486263, EstadoCivil.VIUDO));
        listaTest.add(new PersonalDeServicio("Secretaria", 2021, 23, "Juliana", "Zelarayan", 38452148, EstadoCivil.CASADO));
        listaTest.add(new PersonalDeServicio("Biblioteca", 2005, 18, "Felipe", "Martorell", 35478852, EstadoCivil.SOLTERO));
        
        return listaTest;
    }
    
    public static void MostrarPersonas(ArrayList<Persona> personas){
        System.out.println("\nPersonas dentro del sistema.");
        
        for (Persona persona : personas) {
            System.out.println("");
            
            if (persona instanceof Estudiante) {
                Estudiante estudiante = (Estudiante) persona;
                System.out.println("Estudiante:");
                System.out.println(estudiante);
                continue;
            }
            
            if (persona instanceof Profesor) {
                Profesor profesor = (Profesor) persona;
                System.out.println("Profesor:");
                System.out.println(profesor);
                continue;
            }

            if (persona instanceof PersonalDeServicio) {
                PersonalDeServicio personalDeServicio = (PersonalDeServicio) persona;
                System.out.println("Personal de Servicio:");
                System.out.println(personalDeServicio);
            }
        }
    }
    
    public static Persona IngresarNuevaPersona(ArrayList<Persona> personas, String op){
        String nombre;
        String apellido;
        Integer numeroDeID;
        EstadoCivil estadoCivil=null;
        
        switch (op) {
            case "2":
                System.out.println("\nIngrese la información del estudiante:");
                break;
            case "3":
                System.out.println("\nIngrese la información del profesor:");
                break;
            default:
                System.out.println("\nIngrese la información del personal de servicio:");
        }
        
        System.out.print("\nNombre: ");
        nombre=MainServicio.leer.next();
        System.out.print("Apellido:");
        apellido=MainServicio.leer.next();
        
        boolean continuar;
        String respuesta;
        do {            
            continuar=false;
            System.out.print("Número de identificación: ");
            respuesta=MainServicio.leer.next();
            continuar = !MainServicio.ConfirmarNumEntero(respuesta, Integer.MAX_VALUE);
            
            if(continuar){
                System.out.println("Ingreso no valido.");
            }
            
        } while (continuar);
        
        numeroDeID=Integer.parseInt(respuesta);
        
        do {   
            continuar=false;
            System.out.println("Seleccione el estado civil: ");
        
            int i=1;
            for (EstadoCivil estadocivil : EstadoCivil.values()) {
                System.out.println(i+"- "+estadocivil.getValor());
                i++;
            }
            
            System.out.print("\nOpción: ");
            respuesta=MainServicio.leer.next();
            switch (respuesta) {
                case "1":
                    estadoCivil=EstadoCivil.SOLTERO;
                    break;
                case "2":
                    estadoCivil=EstadoCivil.CASADO;
                    break;
                case "3":
                    estadoCivil=EstadoCivil.DIVORCIADO;
                    break;
                case "4":
                    estadoCivil=EstadoCivil.VIUDO;
                    break;
                default:
                    continuar=true;
                    System.out.println("Ingreso no valido.");
            }
        } while (continuar);
        
        switch (op) {
            case "3":
            case "4":
                return EmpleadoServicio.NuevoEmpleado(nombre, apellido, numeroDeID, estadoCivil, op);
            default:
                return EstudianteServicio.NuevoEstudiante(nombre, apellido, numeroDeID, estadoCivil);
        }
    }
    
    private static Persona SeleccionarPersona(ArrayList<Persona> personas){
        System.out.println("\nSeleccione una personas.");
        
        int i=1;
        for (Persona persona : personas) {
            System.out.print("\n" +i+ "º Persona: ");
            
            if (persona instanceof Estudiante) {
                Estudiante estudiante = (Estudiante) persona;
                System.out.println("Estudiante:");
                System.out.println(estudiante);
                i++;
                continue;
            }
            
            if (persona instanceof Profesor) {
                Profesor profesor = (Profesor) persona;
                System.out.println("Profesor:");
                System.out.println(profesor);
                i++;
                continue;
            }

            if (persona instanceof PersonalDeServicio) {
                PersonalDeServicio personalDeServicio = (PersonalDeServicio) persona;
                System.out.println("Personal de Servicio:");
                System.out.println(personalDeServicio);
                i++;
            }
        }

        boolean continuar;
        String respuesta;
        do {            
            continuar=false;
            System.out.print("\nPersona número: ");
            respuesta=MainServicio.leer.next();
            
            continuar = !MainServicio.ConfirmarNumEntero(respuesta, personas.size());
            
            if(continuar){
                System.out.println("Ingreso no valido.");
            }
            
        } while (continuar);
        
        return personas.get(Integer.parseInt(respuesta)-1);
    }
    
    public static ArrayList<Persona> CambiarEstadoCivil(ArrayList<Persona> personas){
        Persona persona = SeleccionarPersona(personas);
        System.out.println("\nPersona selecionada:");
        System.out.println(persona);
        
        boolean continuar;
        String respuesta;
        do {   
            continuar=false;
            System.out.print("\n¿Quiere seleccionar a otra persona?(S/N) ");
            respuesta=MainServicio.leer.next().toUpperCase();
            switch (respuesta) {
                case "S":
                    CambiarEstadoCivil(personas);
                    break;
                case "N":
                    break;
                default:
                    continuar=true;
                    System.out.println("Ingreso no valido.");
            }
        } while (continuar);
        
        do {   
            continuar=false;
            System.out.println("\nSeleccione el nuevo estado civil.");
        
            int i=1;
            for (EstadoCivil estadocivil : EstadoCivil.values()) {
                System.out.println(i+"- "+estadocivil.getValor());
                i++;
            }
            
            System.out.print("\nOpción: ");
            respuesta=MainServicio.leer.next();
            switch (respuesta) {
                case "1":
                    persona.setEstadoCivil(EstadoCivil.SOLTERO);
                    break;
                case "2":
                    persona.setEstadoCivil(EstadoCivil.CASADO);
                    break;
                case "3":
                    persona.setEstadoCivil(EstadoCivil.DIVORCIADO);
                    break;
                case "4":
                    persona.setEstadoCivil(EstadoCivil.VIUDO);
                    break;
                default:
                    continuar=true;
                    System.out.println("Ingreso no valido");
            }
        } while (continuar);
        
        System.out.println("\nCambio de estado civil hecho.");
        return personas;
    }
}
