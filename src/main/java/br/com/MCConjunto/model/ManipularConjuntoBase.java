/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.model;

import static br.com.MCConjunto.model.IManipularConjunto.VAZIO;
import java.util.stream.Collectors;

/**
 *
 * Classe implementa a interface generica
 * 
 * @author Lucas Gabriel
 * 
 * @param <Entidade>
 * Parametro generico que precisa do comparable para ser possível ordernar
 * 
 */
public abstract class ManipularConjuntoBase<Entidade extends Comparable> implements IManipularConjunto<Entidade>{
    
    @Override
    public boolean compararConjunto(Conjunto<Entidade> primeiroConjunto, Conjunto<Entidade> segundoConjunto) {
        for (Entidade elemento : primeiroConjunto.getElementos()) {
            if(!perteceAoConjunto(segundoConjunto, elemento)){
                return false;
            }
        }
        return primeiroConjunto.getElementos().size()==segundoConjunto.getElementos().size();
    }
    
    @Override
    public boolean perteceAoConjunto(Conjunto<Entidade> conjunto, Entidade elemento) {
        return conjunto.getElementos().contains(elemento);
    }
    
    @Override
    public String apresentarConjunto(Conjunto<Entidade> conjunto) {
        StringBuilder conjuntoString = new StringBuilder(conjunto.toString());
        if(!conjunto.getNome().isEmpty())
            conjuntoString.append(" = ");
        if(conjunto.getElementos().isEmpty())
            conjuntoString.append(VAZIO);
        else{
            conjuntoString.append("{");
            conjuntoString.append(String.join(", ", conjunto.getElementos().stream().sorted((Entidade t1,Entidade t2)-> t1.compareTo(t2)).map((Entidade t) -> t.toString()).collect(Collectors.toList())));
            conjuntoString.append("}");
        }
        return conjuntoString.toString();
    }
    
    @Override
    public Conjunto<Entidade> conjuntoDiferenca(Conjunto<Entidade> primeiroConjunto, Conjunto<Entidade> segundoConjunto) {
        Conjunto<Entidade> novoConjunto=new Conjunto<>("("+primeiroConjunto+DIFERENCA+segundoConjunto+")");
        novoConjunto.getElementos().addAll(primeiroConjunto.getElementos());
        novoConjunto.getElementos().removeAll(segundoConjunto.getElementos());
        return novoConjunto;
    }
    
    @Override
    public Conjunto<Entidade> conjuntoUniao(Conjunto<Entidade> primeiroConjunto, Conjunto<Entidade> segundoConjunto) {
        Conjunto<Entidade> novoConjunto=new Conjunto<>("("+primeiroConjunto.getNome()+UNIAO+segundoConjunto.getNome()+")");
        //Utilizando a estrutura set para fazer a união
        novoConjunto.getElementos().addAll(primeiroConjunto.getElementos());
        novoConjunto.getElementos().addAll(segundoConjunto.getElementos());
        return novoConjunto;
    }
    
     @Override
    public Conjunto<Entidade> conjuntoIntersecao(Conjunto<Entidade> primeiroConjunto, Conjunto<Entidade> segundoConjunto) {
        Conjunto<Entidade> novoConjunto=new Conjunto<>("("+primeiroConjunto+INTERSECAO+segundoConjunto+")");
        for (Entidade elementos1: primeiroConjunto.getElementos()){
            if(perteceAoConjunto(segundoConjunto, elementos1)){
                novoConjunto.getElementos().add(elementos1);
            }
        }   
        return novoConjunto;
    }
    
    @Override
    public Conjunto<ParOrdenado<Entidade, Entidade>> produtoCartesiano(Conjunto<Entidade> primeiroConjunto, Conjunto<Entidade> segundoConjunto) {
        Conjunto<ParOrdenado<Entidade,Entidade>> num=new Conjunto<>(primeiroConjunto.getNome()+"x"+segundoConjunto.getNome());
        for(Entidade goku: primeiroConjunto.getElementos()){
            for(Entidade vegeta: segundoConjunto.getElementos()){
                ParOrdenado<Entidade,Entidade> alg=new ParOrdenado<>();
                alg.setX(goku);
                alg.setY(vegeta);
                num.getElementos().add(alg);
                //Chegou o Vegetto.
            }
        }
        return num;
    }

    @Override
    public Conjunto<Conjunto<Entidade>> conjuntoPotencia(Conjunto<Entidade> conjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
