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
        for (Character elemento : primeiroConjunto.getElementos()) {
            if(!perteceAoConjunto(segundoConjunto, elemento)){
                return false;
            }
        }
        return primeiroConjunto.getElementos().size()==segundoConjunto.getElementos().size();
    }

    @Override
    public Conjunto<Conjunto<Character>> conjuntoPotencia(Conjunto<Character> conjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean perteceAoConjunto(Conjunto<Character> conjunto, Character elemento) {
//     Implementação para verificar se a lista possui o elemento sem utilizar metodo já implementado
//       for (Character elemento1 : conjunto.getElementos()) {
//            if (elemento1.equals(elemento)) {
//                return true;
//            }
//        }
//        return false;
        return conjunto.getElementos().contains(elemento);
    }

    @Override
    public Conjunto<Character> conjuntoUniao(Conjunto<Character> primeiroConjunto, Conjunto<Character> segundoConjunto) {
        Conjunto<Character> novoConjunto=new Conjunto<>(primeiroConjunto.getNome()+UNIAO+segundoConjunto.getNome());
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

    @Override
    public String apresentarConjunto(Conjunto<Character> conjunto) {
        StringBuilder conjuntoString = new StringBuilder(conjunto.toString());
        conjuntoString.append(" = {");
        for (Character elemento : ordernarConjunto(conjunto,Order.CRESCENTE)) {
           conjuntoString.append(elemento);
           conjuntoString.append(", ");
        }
        if(!conjunto.getElementos().isEmpty())
            conjuntoString.delete(conjuntoString.toString().length()-2, conjuntoString.toString().length());
        conjuntoString.append("}");
        return conjuntoString.toString();
    }
}
