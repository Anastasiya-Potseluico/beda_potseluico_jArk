/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

/**
 * Класс границы поля
 * @author Дарья
 */
public class BoundaryField extends ElementField {
    /**
     * Конструктор границ
     * @param weight вес границ
     */
    public BoundaryField (int weight) {
        super(weight);
    }

    @Override
    public void reactOnCollision(ElementField element) {
       
    }
}
