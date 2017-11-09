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


public class ManipularConjunto implements IManipularConjunto<String>{

    @Override
    public boolean compararConjunto(Conjunto<String> primeiroConjunto, Conjunto<String> segundoConjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conjunto<Conjunto<String>> conjuntoPotencia(Conjunto<String> primeiroCojunto, Conjunto<String> segundoConjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean perteceAoConjunto(Conjunto<String> conjunto, String elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conjunto<String> conjuntoUniao(Conjunto<String> primeiroConjunto, Conjunto<String> segundoConjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conjunto<String> conjuntoIntersecao(Conjunto<String> primeiroConjunto, Conjunto<String> segundoConjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conjunto<String> conjuntoDiferenca(Conjunto<String> primeiroConjunto, Conjunto<String> segundoConjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conjunto<ParOrdenado<String, String>> produtoCartesiano(Conjunto<String> primeiroConjunto, Conjunto<String> segundoConjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
