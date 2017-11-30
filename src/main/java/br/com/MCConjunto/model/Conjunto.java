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
public class Conjunto<Entidade extends Comparable> implements Comparable<Conjunto<Entidade>> {

    private String nome;
    private Set<Entidade> elementos;

    public Conjunto() {
        nome = "";
        elementos = new HashSet<>();
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
        return getNome();
    }

    @Override
    public int compareTo(Conjunto<Entidade> comparado) {
        IManipularConjunto<Entidade> manipularConjunto = new IManipularConjunto<Entidade>() {
            @Override
            public boolean compararConjunto(Conjunto<Entidade> primeiroConjunto, Conjunto<Entidade> segundoConjunto) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Conjunto<Conjunto<Entidade>> conjuntoPotencia(Conjunto<Entidade> conjunto) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean perteceAoConjunto(Conjunto<Entidade> conjunto, Entidade elemento) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Conjunto<Entidade> conjuntoUniao(Conjunto<Entidade> primeiroConjunto, Conjunto<Entidade> segundoConjunto) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Conjunto<Entidade> conjuntoIntersecao(Conjunto<Entidade> primeiroConjunto, Conjunto<Entidade> segundoConjunto) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Conjunto<Entidade> conjuntoDiferenca(Conjunto<Entidade> primeiroConjunto, Conjunto<Entidade> segundoConjunto) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Conjunto<ParOrdenado<Entidade, Entidade>> produtoCartesiano(Conjunto<Entidade> primeiroConjunto, Conjunto<Entidade> segundoConjunto) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String apresentarConjunto(Conjunto<Entidade> conjunto) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        if (this.getElementos().size() < comparado.getElementos().size()) {
            return -1;
        } else if (this.getElementos().size() == comparado.getElementos().size()) {
            for (int i = 0; i < this.getElementos().size(); i++) {
                int val = manipularConjunto.ordernarConjunto(this, Order.CRESCENTE).get(i).compareTo(manipularConjunto.ordernarConjunto(comparado, Order.CRESCENTE).get(i));
                if (val == 0) {
                    continue;
                } else {
                    return val;
                }
            }
            return 0;
        } else {
            return 1;
        }
    }
}
