/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jArk.specifications.Size;
import jark.specifications.Buffer;

/**
 * Логическое представление элемента поля
 * @author Дарья
 */
enum MASS {FIN_MASS, INF_MASS, OTHER};

public abstract class ElementField {
          
    protected MASS _mass;
     
    int _x;
    
    int _y;
    /**
     * Конструктор элемента поля
     * @param weight вес элемента (постоянен)
     */
    public ElementField(MASS mass, int x, int y){
        this._mass = mass;
        _x = x;
        _y = y;
    }
   
    public abstract void reactOnCollision(ElementField element);
    /**
     * Функция для получения веса элемента
     * @return вес элемента
     */
    public MASS mass(){
        return this._mass;
    }
    
    public int x() {
        return _x;
    }
    
    public int y() {
        return _y;
    }
    
    public boolean setSpeed(double x, double y) {
        Buffer.findSprite(this).setSpeed(x, y);
        return true;
    }
}
