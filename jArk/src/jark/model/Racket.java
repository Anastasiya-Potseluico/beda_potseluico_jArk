/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import com.golden.gamedev.object.Sprite;
import jark.collisionManagers.CollisionMan;
import jark.specifications.Buffer;

/**
 * Класс ракетки
 * @author Дарья
 */
public class Racket extends ElementField{

    boolean _hasBall;
    /**
     * Конструктор ракетки
     */
    public Racket(int x, int y) {
        super(MASS.INF_MASS,x,y);
    }

    @Override
    public boolean setSpeed(double x, double y) {
        if(Buffer.findSprite(this).getX() <= 5)
            return super.setSpeed(Math.abs(x), y);
        else if (Buffer.findSprite(this).getX() >= 497)
            return super.setSpeed(Math.abs(x)*-1, y);
        else
            return super.setSpeed(x, y);        
    }

    @Override
    public void reactOnCollision(ElementField element, CollisionMan.TYPE type) {
        if(element instanceof BoundaryField) {
            setSpeed(Buffer.findSprite(this).getHorizontalSpeed()*-1, 0); 
        }
    }
}
