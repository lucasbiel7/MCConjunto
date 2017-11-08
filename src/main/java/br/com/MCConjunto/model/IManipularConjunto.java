/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.model;

/**
 *
 * @author lucas
 * @param <Entidade>
 * Parametro criado para generalizar os tipos de conjuntos
 */
public interface IManipularConjunto<Entidade extends Object> {
    
    boolean compararConjunto(Conjunto<Entidade> primeiroConjunto,Conjunto<Entidade> segundoConjunto);
    Conjunto<Conjunto<Entidade>> conjuntoPotencia(Conjunto<Entidade> primeiroCojunto,Conjunto<Entidade> segundoConjunto);
    boolean perteceAoConjunto(Conjunto<Entidade> conjunto,Entidade elemento);
    Conjunto<Entidade> conjuntoUniao(Conjunto<Entidade> primeiroConjunto,Conjunto<Entidade> segundoConjunto);
    Conjunto<Entidade> conjuntoIntersecao(Conjunto<Entidade> primeiroConjunto,Conjunto<Entidade> segundoConjunto);
    Conjunto<Entidade> conjuntoDiferenca(Conjunto<Entidade> primeiroConjunto,Conjunto<Entidade> segundoConjunto);
    Conjunto<ParOrdenado<Entidade,Entidade>> produtoCartesiano(Conjunto<Entidade> primeiroConjunto,Conjunto<Entidade> segundoConjunto);
    
}
