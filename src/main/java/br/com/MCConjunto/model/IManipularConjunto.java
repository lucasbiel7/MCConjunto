/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author lucas
 * @param <Entidade>
 * Parametro criado para generalizar os tipos de conjuntos
 */
public interface IManipularConjunto<Entidade extends Comparable> {
    
    public static final String UNIAO="∪";
    public static final String INTERSECAO="∩";
    public static final String PERTENCE="∈";
    public static final String DIFERENCA="-";
    public static final String VAZIO="Ø";
    
    
    boolean compararConjunto(Conjunto<Entidade> primeiroConjunto,Conjunto<Entidade> segundoConjunto);
    Conjunto<Conjunto<Entidade>> conjuntoPotencia(Conjunto<Entidade> conjunto);
    boolean perteceAoConjunto(Conjunto<Entidade> conjunto,Entidade elemento);
    Conjunto<Entidade> conjuntoUniao(Conjunto<Entidade> primeiroConjunto,Conjunto<Entidade> segundoConjunto);
    Conjunto<Entidade> conjuntoIntersecao(Conjunto<Entidade> primeiroConjunto,Conjunto<Entidade> segundoConjunto);
    Conjunto<Entidade> conjuntoDiferenca(Conjunto<Entidade> primeiroConjunto,Conjunto<Entidade> segundoConjunto);
    Conjunto<ParOrdenado<Entidade,Entidade>> produtoCartesiano(Conjunto<Entidade> primeiroConjunto,Conjunto<Entidade> segundoConjunto);
    String apresentarConjunto(Conjunto<Entidade> conjunto);
    
    //Metodo Generico para ordenação 
    default List<Entidade> ordernarConjunto(Conjunto<Entidade> conjunto,Order order){
        List<Entidade> entidade=conjunto.getElementos().stream().collect(Collectors.toList());
        entidade.sort((Entidade e1,Entidade e2) -> e1.compareTo(e2));
        return entidade;
    }
}
