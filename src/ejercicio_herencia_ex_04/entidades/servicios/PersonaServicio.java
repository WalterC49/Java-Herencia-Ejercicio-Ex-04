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
        listaTest.add(new Profesor("Matematicas", 1997, 38, "Jorge", "Perez", 21486263, EstadoCivil.VIUDO));
        listaTest.add(new PersonalDeServicio("Secretaria", 2021, 23, "Juliana", "Zelarayan", 38452148, EstadoCivil.CASADO));
        listaTest.add(new PersonalDeServicio("Biblioteca", 2005, 18, "Felipe", "Martorell", 35478852, EstadoCivil.SOLTERO));
        
        return listaTest;
    }
}
