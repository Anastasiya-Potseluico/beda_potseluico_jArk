/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jark.collisionManagers.CollisionMan;

/**
 * Класс неразрушаемого кирпича
 * @author Дарья
 */
public class IndestructibleBrick extends Brick {

    /**
     * Конструктор неразрушаемого кирпича
     */
    public IndestructibleBrick(int x, int y) {
        super(MASS.INF_MASS, x, y);
    }

    @Override
    public void reactOnCollision(ElementField element, CollisionMan.TYPE type) {
       
    }
    
}
