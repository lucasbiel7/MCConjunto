/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.model;

/**
 *
 * @author lucas
 */
public enum Order {

    CRESCENTE, DESCRESCENTE;

    public int getValue() {
        switch (this) {
            case CRESCENTE:
                return 1;
            case DESCRESCENTE:
                return -1;
            default:
                return 0;
        }
    }
}
