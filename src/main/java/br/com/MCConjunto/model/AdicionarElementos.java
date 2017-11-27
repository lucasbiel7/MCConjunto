/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.model;

import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author bernardo
 * @param <Entidade>
 */
public class AdicionarElementos<Entidade extends Object> {
    private Set<Entidade> elementos;
    
        public AdicionarElementos() {
        elementos=new HashSet<>();
    }
        
 public Set<Entidade> getElementos() {
        return elementos;
    }

    public void setElementos(Set<Entidade> elementos) {
        this.elementos = elementos;
    }        
}
