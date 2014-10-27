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
    /** Позиция */
    protected Position _position;
    /** Размер */
    protected Size _size;
    /** Скорость */
    protected Speed _speed;
    /** Игровое поле */
    protected GameField _gamefield;
    
    /**
     * Функция реакции элемента на столкновение с другим элементом
     * @param element элемент, с которым произошло столкновение
     */
    public void reactOnCollision(ElementField element){
        
    }
}
