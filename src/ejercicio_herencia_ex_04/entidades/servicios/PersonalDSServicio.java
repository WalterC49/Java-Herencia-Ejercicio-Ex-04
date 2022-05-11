/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_04.entidades.servicios;

import ejercicio_herencia_ex_04.entidades.Persona;
import ejercicio_herencia_ex_04.entidades.PersonalDeServicio;
import ejercicio_herencia_ex_04.enumeraciones.EstadoCivil;
import java.util.ArrayList;

/**
 *
 * @author Walter
 */
public class PersonalDSServicio {

    public static PersonalDeServicio NuevoPersonalDS(Integer anioIncorporacion, Integer numDespacho, String nombre, String apellido, Integer numeroDeID, EstadoCivil estadoCivil){
        String seccion;
        
        System.out.print("Sección(biblioteca, decanato, secretaría, etc): ");
        seccion=MainServicio.leer.next();
        
        return new PersonalDeServicio(seccion, anioIncorporacion, numDespacho, nombre, apellido, numeroDeID, estadoCivil);
    }
    
    private static PersonalDeServicio SeleccionarPersonalDeServicio(ArrayList<Persona> personas){
        //CREO UNA LISTA AUXILIAR DEl PERSONAL DE SERVICIO
        ArrayList<PersonalDeServicio> personasDS = new ArrayList();
        for (Persona persona : personas) {
            if (persona instanceof PersonalDeServicio) {
                PersonalDeServicio personaDS = (PersonalDeServicio) persona;
                personasDS.add(personaDS);
            }
        }
        
        System.out.println("\nSeleccione un profesor.");
        
        int i=1;
        for (PersonalDeServicio personaDS : personasDS) {
            System.out.println("\n" +i+ "º Personal de servicio: ");
            System.out.println(personaDS);
            i++;
        }

        boolean continuar;
        String respuesta;
        do {            
            continuar=false;
            System.out.print("\nPersonal de servicio número: ");
            respuesta=MainServicio.leer.next();
            
            continuar = !MainServicio.ConfirmarNumEntero(respuesta, personasDS.size());
            
            if(continuar){
                System.out.println("Ingreso no valido.");
            }
        } while (continuar);
        
        return personasDS.get(Integer.parseInt(respuesta)-1);
    }
    
    public static ArrayList<Persona> TrasladarSeccion(ArrayList<Persona> personas){
        PersonalDeServicio personaDS = SeleccionarPersonalDeServicio(personas);
        System.out.println("\nPersonal de servicio selecionado:");
        System.out.println(personaDS);
        
        boolean continuar;
        String respuesta;
        do {   
            continuar=false;
            System.out.print("\n¿Quiere seleccionar a otro personal de servicio?(S/N) ");
            respuesta=MainServicio.leer.next().toUpperCase();
            switch (respuesta) {
                case "S":
                    TrasladarSeccion(personas);
                    break;
                case "N":
                    break;
                default:
                    continuar=true;
                    System.out.println("Ingreso no valido");
            }
        } while (continuar);
        
        System.out.print("\nIngrese la nueva sección para trasladar: ");
        respuesta=MainServicio.leer.next();
        
        personaDS.setSeccion(respuesta);
        
        System.out.println("\nTraslado de sección completado.");
        return personas;
    }
}
