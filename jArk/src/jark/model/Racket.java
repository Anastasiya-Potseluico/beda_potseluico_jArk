/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import com.golden.gamedev.object.Sprite;
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
        super(MASS.INF_MASS, x, y);
        _hasBall = true;
    }
    
    public boolean hasBall() {
        return _hasBall;
    }
    
    public void resetBall() {
        _hasBall = false;
    }

    @Override
    public void reactOnCollision(ElementField element) {
        Sprite sp = Buffer.findSprite(this);
        Sprite ss = Buffer.findSprite(element);
        if(element instanceof BoundaryField) {
            double f = sp.getHorizontalSpeed();
            setSpeed(sp.getHorizontalSpeed()*-1, 0); 
        }
    }
}
