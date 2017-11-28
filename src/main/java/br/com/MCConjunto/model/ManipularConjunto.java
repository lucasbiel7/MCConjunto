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
 */


public class ManipularConjunto implements IManipularConjunto<Character>{

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
        Conjunto<Character> novoConjunto=new Conjunto<>("("+primeiroConjunto.getNome()+UNIAO+segundoConjunto.getNome()+")");
        //Utilizando a estrutura set para fazer a união
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
        Conjunto<Character> novoConjunto=new Conjunto<>("("+primeiroConjunto+DIFERENCA+segundoConjunto+")");
        novoConjunto.getElementos().addAll(primeiroConjunto.getElementos());
        novoConjunto.getElementos().removeAll(segundoConjunto.getElementos());
        return novoConjunto;
    }

    @Override
    public Conjunto<ParOrdenado<Character, Character>> produtoCartesiano(Conjunto<Character> primeiroConjunto, Conjunto<Character> segundoConjunto) {
        Conjunto<ParOrdenado<Character,Character>> num=new Conjunto<>(primeiroConjunto.getNome()+"x"+segundoConjunto.getNome());
        for(Character goku: primeiroConjunto.getElementos()){
            for(Character vegeta: segundoConjunto.getElementos()){
                ParOrdenado<Character,Character> alg=new ParOrdenado<>();
                alg.setX(goku);
                alg.setY(vegeta);
                num.getElementos().add(alg);
                //Chegou o Vegetto.
            }
            
        }
        return num;
    }

    @Override
    public String apresentarConjunto(Conjunto<Character> conjunto) {
        StringBuilder conjuntoString = new StringBuilder(conjunto.toString());
        if(!conjunto.getNome().isEmpty())
            conjuntoString.append(" = ");
        conjuntoString.append("{");
        for (Character elemento : ordernarConjunto(conjunto,Order.CRESCENTE)) {
           conjuntoString.append(elemento);
           conjuntoString.append(", ");
        }
        conjuntoString.delete(conjuntoString.toString().length()-(conjunto.getElementos().isEmpty()?1:2), conjuntoString.toString().length());
        if(conjunto.getElementos().isEmpty())
            conjuntoString.append(VAZIO);
        else
            conjuntoString.append("}");
        return conjuntoString.toString();
    }
}
