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
     */
    public IndestructibleBrick() {
        super(_weight.INF_MASS);
    }

    @Override
    public void reactOnCollision(ElementField element) {
       
    }
    
}
