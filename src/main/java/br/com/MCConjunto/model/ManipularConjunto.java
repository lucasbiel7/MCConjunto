/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.model;

/**
 *
 * @author berna
 */


public  class ManipularConjunto implements IManipularConjunto<Character>{

    @Override
    public boolean compararConjunto(Conjunto<Character> primeiroConjunto, Conjunto<Character> segundoConjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conjunto<Conjunto<Character>> conjuntoPotencia(Conjunto<Character> conjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean perteceAoConjunto(Conjunto<Character> conjunto, Character elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conjunto<Character> conjuntoUniao(Conjunto<Character> primeiroConjunto, Conjunto<Character> segundoConjunto) {
        Conjunto<Character> novoConjunto=new Conjunto<>(primeiroConjunto.getNome()+"U"+segundoConjunto.getNome());
        novoConjunto.getElementos().addAll(primeiroConjunto.getElementos());
        novoConjunto.getElementos().addAll(segundoConjunto.getElementos());
        return novoConjunto;
    }

    @Override
    public Conjunto<Character> conjuntoIntersecao(Conjunto<Character> primeiroConjunto, Conjunto<Character> segundoConjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conjunto<Character> conjuntoDiferenca(Conjunto<Character> primeiroConjunto, Conjunto<Character> segundoConjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conjunto<ParOrdenado<Character, Character>> produtoCartesiano(Conjunto<Character> primeiroConjunto, Conjunto<Character> segundoConjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
