/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_herencia_ex_04.enumeraciones;

/**
 *
 * @author Walter
 */
public enum EstadoCivil {
    SOLTERO("Soltero/a"), CASADO("Casado/a"), DIVORCIADO("Divorciado/a"), VIUDO("Viudo");
    
    private String valor;

    private EstadoCivil() {
    }
    
    private EstadoCivil(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}
