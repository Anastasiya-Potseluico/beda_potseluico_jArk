/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

/**
 * Класс неразрушаемого кирпича
 * @author Дарья
 */
public class IndestructibleBrick extends Brick {

    /**
     * Конструктор неразрушаемого кирпича
     * @param weight вес кирпича
     */
    public IndestructibleBrick(int weight) {
        super(weight);
    }

    @Override
    public void reactOnCollision(ElementField element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
