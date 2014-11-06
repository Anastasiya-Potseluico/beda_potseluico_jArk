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
    public void reactOnCollision(ElementField element){
        
    }
    
    /**
     * Изменить позицию элемента
     * @param pos позиция
     * @return успех изменения позиции
     */
    public boolean setPosition(Position pos) {
        //TODO
        return true;
    }
    
    /**
     * Функция для получения веса элемента
     * @return вес элемента
     */
    public int getWeight(){
        return this._weight;
    }
    
    /**
     * Возвращает позицию элемента поля
     * @return позиция элемента поля
     */
    public Position position() {
        return _position;
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
     * Изменить скорость элемента
     * @param speed скорость
     * @return успех изменения скорости
     */
    public boolean setSpeed(Speed speed) {
        //TODO
        return true;
    }
    
    /**
     * Возвращает скорость элемента поля
     * @return скорость элемента поля
     */
    public Speed speed() {
        return _speed;
    }
    
    /**
     * Возвращает игровое поле, на котором находится элемент
     * @return игровое поле
     */
    public GameField gameField () {
        return _gamefield;
    }
}
