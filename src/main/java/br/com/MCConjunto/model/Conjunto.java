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
 * @author lucas
 * @param <Entidade> Parametro generico para diferentes tipos de conjunto
 */
public class Conjunto<Entidade extends Object> {

    private String nome;
    private Set<Entidade> elementos;

    public Conjunto() {
    }

    public Conjunto(String nome) {
        this.nome = nome;
        this.elementos = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Entidade> getElementos() {
        return elementos;
    }

    public void setElementos(Set<Entidade> elementos) {
        this.elementos = elementos;
    }

    @Override
    public String toString() {
        StringBuilder conjuntoString = new StringBuilder(getNome());
        conjuntoString.append("={");
        for (Entidade elemento : elementos) {
           conjuntoString.append(elemento);
           conjuntoString.append(",");
        }
        if(!elementos.isEmpty())
            conjuntoString.reverse();
        conjuntoString.append("}");
        return conjuntoString.toString();
    }

}
