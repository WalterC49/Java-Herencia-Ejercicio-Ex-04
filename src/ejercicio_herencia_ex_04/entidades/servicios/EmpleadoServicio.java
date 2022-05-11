/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_04.entidades.servicios;

import ejercicio_herencia_ex_04.entidades.Empleado;
import ejercicio_herencia_ex_04.entidades.Persona;
import ejercicio_herencia_ex_04.entidades.PersonalDeServicio;
import ejercicio_herencia_ex_04.entidades.Profesor;
import ejercicio_herencia_ex_04.enumeraciones.EstadoCivil;
import java.util.ArrayList;

/**
 *
 * @author Walter
 */
public class EmpleadoServicio {

    public static Empleado NuevoEmpleado(String nombre, String apellido, Integer numeroDeID, EstadoCivil estadoCivil, String op){
        Integer anioIncorporacion;
        Integer numDespacho;
        
        //AÑO DE INCORPORACIÓN
        boolean continuar;
        String respuesta;
        do {            
            continuar=false;
            System.out.print("Año de incorporacción: ");
            respuesta=MainServicio.leer.next();
            continuar = !MainServicio.ConfirmarNumEntero(respuesta, Integer.MAX_VALUE);
            
            if(continuar){
                System.out.println("Ingreso no valido.");
            }
        } while (continuar);
        
        anioIncorporacion=Integer.parseInt(respuesta);
        
        //NÚMERO DE DESPACHO
        do {            
            continuar=false;
            System.out.print("Número de despacho: ");
            respuesta=MainServicio.leer.next();
            continuar = !MainServicio.ConfirmarNumEntero(respuesta, Integer.MAX_VALUE);
            
            if(continuar){
                System.out.println("Ingreso no valido.");
            }
        } while (continuar);
        
        numDespacho=Integer.parseInt(respuesta);
        
        switch (op) {
            case "3":
                return ProfesorServicio.NuevoProfesor(anioIncorporacion, numDespacho, nombre, apellido, numeroDeID, estadoCivil);
            default:
                return PersonalDSServicio.NuevoPersonalDS(anioIncorporacion, numDespacho, nombre, apellido, numeroDeID, estadoCivil);
        }
    }
    
    private static Empleado SeleccionarEmpleado(ArrayList<Persona> personas){
        //CREO UNA LISTA AUXILIAR DE EMPLEADOS
        ArrayList<Empleado> empleados = new ArrayList();
        for (Persona persona : personas) {
            if (persona instanceof Empleado) {
                Empleado empleado = (Empleado) persona;
                empleados.add(empleado);
            }
        }
        
        System.out.println("\nSeleccione un empleado.");
        
        int i=1;
        for (Empleado empleado : empleados) {
            System.out.print("\n" +i+ "º Empleado: ");
            
            if (empleado instanceof Profesor) {
                Profesor profesor = (Profesor) empleado;
                System.out.println("Profesor");
                System.out.println(profesor);
                i++;
            }
           
            if (empleado instanceof PersonalDeServicio) {
                PersonalDeServicio personalDeServicio = (PersonalDeServicio) empleado;
                System.out.println("Personal de Servicio:");
                System.out.println(personalDeServicio);
                i++;
            }
        }

        boolean continuar;
        String respuesta;
        do {            
            continuar=false;
            System.out.print("\nEmpleado número: ");
            respuesta=MainServicio.leer.next();
            
            continuar = !MainServicio.ConfirmarNumEntero(respuesta, empleados.size());
            
            if(continuar){
                System.out.println("Ingreso no valido.");
            }
        } while (continuar);
        
        return empleados.get(Integer.parseInt(respuesta)-1);
    }
    
    public static ArrayList<Persona> ReasignarDespacho(ArrayList<Persona> personas){
        Empleado empleado = SeleccionarEmpleado(personas);
        System.out.println("\nEmpleado selecionado:");
        System.out.println(empleado);
        
        boolean continuar;
        String respuesta;
        do {   
            continuar=false;
            System.out.print("\n¿Quiere seleccionar a otro empleado?(S/N) ");
            respuesta=MainServicio.leer.next().toUpperCase();
            switch (respuesta) {
                case "S":
                    ReasignarDespacho(personas);
                    break;
                case "N":
                    break;
                default:
                    continuar=true;
                    System.out.println("Ingreso no valido");
            }
        } while (continuar);
        
        do {   
            continuar=false;
            System.out.print("\nIngrese el nuevo número de despacho: ");
            respuesta=MainServicio.leer.next();
            
            continuar = !MainServicio.ConfirmarNumEntero(respuesta, Integer.MAX_VALUE);
            
        } while (continuar);
        
        empleado.setNumDespacho(Integer.parseInt(respuesta));
        
        System.out.println("\nReasignación completada.");
        return personas;
    }
}
