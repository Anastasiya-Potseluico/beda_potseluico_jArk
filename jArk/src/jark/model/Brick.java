/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

/**
 * Класс кирпича (абстрактный кирпич)
 * @author Дарья
 */
public abstract class Brick extends ElementField {
    /**
     * Конструктор кирпича
     * @param mass масса кирпича
     * @param x координата х кирпича на поле
     * @param y координата у кирпича на поле
     */
    public Brick(MASS mass, int x, int y) {
        super(mass, x, y);
    }
}
