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
     * @param x координата х кирпича на поле
     * @param y координата у кирпича на поле
     */
    public IndestructibleBrick(int x, int y) {
        super(MASS.INF_MASS, x, y);
    }
    
    /**
     * Метод реакции кирпича на коллизию (в дальнейшем возможно добавление реакции)
     * @param element элемент, с которым столкнулся кирпич
     * @param type тип коллизии
     */
    @Override
    public void reactOnCollision(ElementField element, CollisionMan.TYPE type) {
        
    }
    
}
