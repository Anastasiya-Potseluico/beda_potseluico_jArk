/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jArk.specifications.Position;
import jArk.specifications.Size;
import jArk.specifications.Speed;

/**
 * Логическое представление элемента поля
 * @author Дарья
 */
public abstract class ElementField {
    /** Размер */
    protected Size _size;
    /** Игровое поле */
    protected GameField _gamefield;
    /** Вес элемента */
    protected int _weight;
    
    /**
     * Конструктор элемента поля
     * @param weight вес элемента (постоянен)
     */
    public ElementField(int weight){
        this._weight = weight;
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
    public int weight(){
        return this._weight;
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
        return _size;
    }
    
    /**
     * Возвращает игровое поле, на котором находится элемент
     * @return игровое поле
     */
    public GameField gameField () {
        return _gamefield;
    }
}
