/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jArk.specifications.Size;
import jark.specifications.Buffer;
import jark.view.ElementFieldView;

/**
 * Логическое представление элемента поля
 * @author Дарья
 */
enum MASS {FIN_MASS, INF_MASS, OTHER};

public abstract class ElementField {
    /** Вес элемента */      
    protected MASS _mass;
    protected int _x;
    protected int _y;
     
    /**
     * Конструктор элемента поля
     * @param mass
     * @param x
     * @param y
     */
    public ElementField(MASS mass, int x, int y){
        this._mass = mass;
        _x = x;
        _y = y;
    }
    
    /**
     * Функция реакции элемента на столкновение с другим элементом
     * @param element элемент, с которым произошло столкновение
     */
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
    /**
     * Изменить размер элемента
     * @param size размер
     * @return успех изменения размера
     */
    public boolean setSpeed(double x, double y) {
        Buffer.findSprite(this).setSpeed(x, y);
        return true;
    }
}
