/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.model;

/**
 *
 * @author bernardo
 */
public class Intersecao<Conjunto1, Conjunto2> {
    private Conjunto1 conjunto1;
    private Conjunto2 conjunto2;
    
    public Conjunto1 getConjunto1(){
        return conjunto1;
    }
    
    public void SetConjunto1(Conjunto1 conjunto1){
        this.conjunto1 = conjunto1;
    }
    
    public Conjunto2 getConjunto2(){
        return conjunto2;
    }
    
    public void SetConjunto2(Conjunto2 conjunto2){
        this.conjunto2 = conjunto2;
    }
// peguei os elementos, agora tenho que ver quais elementos são iguais para os conjuntos.
}
