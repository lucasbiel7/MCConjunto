/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.model;

import static br.com.MCConjunto.model.IManipularConjunto.INTERSECAO;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author bernardo
 */

public  class ManipularConjunto extends ManipularConjuntoBase<Character>{
    
    @Override
    public Conjunto<Conjunto<Character>> conjuntoPotencia(Conjunto<Character> conjunto) {
        Conjunto<Conjunto<Character>> resultado=new Conjunto<>("P("+conjunto+")");
        resultado.getElementos().add(new Conjunto<>());
        for (Character elemento : conjunto.getElementos()) {
            Conjunto<Character> conjuntoUnidade=new Conjunto<>();
            conjuntoUnidade.getElementos().add(elemento);
            resultado.getElementos().add(conjuntoUnidade);
            Set<Character> outrosElementos=new HashSet<>();
            outrosElementos.addAll(conjunto.getElementos());
            outrosElementos.remove(elemento);
            if(!outrosElementos.isEmpty()){
                conjuntosProvenientes(resultado,conjuntoUnidade,outrosElementos);
            }
        }
        return resultado;
    }
    
     private void conjuntosProvenientes(Conjunto<Conjunto<Character>> resultado, Conjunto<Character> conjuntoUnidade,Set<Character> elementosNaoUsado) {
         for (Character character : elementosNaoUsado) {
            Conjunto<Character> novoConjunto=new Conjunto<>();
            novoConjunto.getElementos().addAll(conjuntoUnidade.getElementos());
            novoConjunto.getElementos().add(character);
            if(validarConjunto(novoConjunto,resultado.getElementos()))
                resultado.getElementos().add(novoConjunto);
            Set<Character> outrosElementos=new HashSet<>();
            outrosElementos.addAll(elementosNaoUsado);
            outrosElementos.remove(character);
            if(!outrosElementos.isEmpty()){
                conjuntosProvenientes(resultado, novoConjunto, outrosElementos);
            }
         }
     }
     
    public boolean validarConjunto(Conjunto<Character> conjunto,Set<Conjunto<Character>> conjuntos){
         for (Conjunto<Character> conjuntoVerificar : conjuntos) {
             if(compararConjunto(conjunto, conjuntoVerificar)){
                 return false;
             }
         }
         return true;
    }
    
}
