/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jArk.specifications.Size;

/**
 * Логическое представление элемента поля
 * @author Дарья
 */
enum MASS {FIN_MASS, INF_MASS, OTHER};

public abstract class ElementField {
    /** Игровое поле */
    protected GameField _gamefield;
    /** Вес элемента */      
    protected MASS _mass;
     
    /**
     * Конструктор элемента поля
     * @param mass
     */
    public ElementField(MASS mass){
        this._mass = mass;
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
    
    /**
     * Изменить размер элемента
     * @param size размер
     * @return успех изменения размера
     */
    public boolean setSize(Size size) {
        //TODO
        return true;
    }
    
    /**
     * Возвращает размер элемента поля
     * @return размер элемента поля
     */
    public Size size() {
        return new Size();
    }
}
