/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

/**
 * Класс кирпича
 * @author Дарья
 */
public abstract class Brick extends ElementField {
    /**
     * Конструктор кирпича
     * @param weight вес кирпича
     */
    public Brick(int weight) {
        super(weight);
    }
}
