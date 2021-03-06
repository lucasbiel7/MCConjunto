/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.model;

/**
 *
 * @author lucas
 * @param <X>
 * Representação de um par ordenado X
 * @param <Y>
 * Representacao de um par ordenado Y
 */
public class ParOrdenado<X extends Comparable,Y extends Comparable> implements Comparable<ParOrdenado<X,Y>>{
   
    private X x;
    private Y y;

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public Y getY() {
        return y;
    }

    public void setY(Y y) {
        this.y = y;
    }

    @Override

    public String toString() {
        return "("+getX()+","+getY()+")";
    }
    
    public int compareTo(ParOrdenado<X, Y> o) {
        if (this.getX().compareTo(o.getX())==0) {
            return this.getY().compareTo(o.getY());
        }
        return this.getX().compareTo(o.getX());
    }
}
