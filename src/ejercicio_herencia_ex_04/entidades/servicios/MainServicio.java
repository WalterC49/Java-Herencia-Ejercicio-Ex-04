/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_04.entidades.servicios;

import ejercicio_herencia_ex_04.entidades.Persona;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Walter
 */
public class MainServicio {
    public static Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public static void Menu(ArrayList<Persona> personas){
        System.out.println("");
        System.out.println("Sistema Gestión Facultad - Menú."
                + "\n1- Probar programa con valores predefinidos."
                + "\n2- Ingresar un estudiante."
                + "\n3- Ingresar un profesor."
                + "\n4- Ingresar un personal de servicio."
                + "\n5- Cambiar estado civil de una persona."
                + "\n6- Reasignar despacho a un empleado."
                + "\n7- Matricular un alumno en un nuevo curso"
                + "\n8- Cambiar departamento a un profesor."
                + "\n9- Trasladar de sección a un empleado de servicio."
                + "\n10- Mostrar la información de todos los individuos dentro del sistema."
                + "\n11- Salir.");
        System.out.print("Opción: ");
        String op=leer.next();
        
        switch (op) {
            case "1":
                Menu2(PersonaServicio.ListaTest());
                Menu(personas);
                break;
            case "2":
                Menu(personas);
                break;
            case "3":
                Menu(personas);
                break;
            case "4":
                Menu(personas);
                break;
            case "5":
                Menu(personas);
                break;
            case "6":
                Menu(personas);
                break;
            case "7":
                Menu(personas);
                break;
            case "8":
                Menu(personas);
                break;
            case "9":
                Menu(personas);
            case "10":
                Menu(personas);
            case "11":
                System.out.println("Hasta prontos.");
                break;
            default:
                System.out.println("Opción no valida.");
                Menu(personas);
        }
    }
    
    public static void Menu2(ArrayList<Persona> listaTest){
        System.out.println("");
        System.out.println("Sistema Gestión Facultad - Menú para pruebas."
                + "\n1- Cambiar estado civil de una persona."
                + "\n2- Reasignar despacho a un empleado."
                + "\n3- Matricular un estudiante en un nuevo curso."
                + "\n4- Cambiar departamento a un profesor."
                + "\n5- Trasladar de sección a un empleado de servicio."
                + "\n6- Mostrar la información de todos los individuos dentro del sistema."
                + "\n7- Regresar al menú principal.");
        System.out.print("Opción: ");
        String op=leer.next();
        
        switch (op) {
            case "1":
                Menu2(listaTest);
            case "2":
                Menu2(listaTest);
            case "3":
                Menu2(listaTest);
            case "4":
                Menu2(listaTest);
            case "5":
                Menu2(listaTest);
            case "6":
                Menu2(listaTest);
            case "7":
                return;
            default:
                System.out.println("Opción no valida.");
                Menu2(listaTest);
        }
    }
    
}
