/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jArk.physicalObjects.PhysicalGameField;
import java.util.ArrayList;

/**
 * Класс игрового поля
 * @author Дарья
 */
public class GameField {
    /** Мяч */
    private ElementField _ball;
    /** Ракетка */
    private ElementField _racket;
    /** Рой */
    private ElementField _swarm;
    /** Разрушаемые кирпичи */
    private ArrayList <ElementField> _dBricks;
    /** Неразрушаемые кирпичи */
    private ArrayList <ElementField> _iBricks;
    /** Границы поля */
    private ArrayList <ElementField> _bondarysField;
    /** Представление игрового поля */
    private PhysicalGameField _phGameField;
    
    /**
     * Конструктор
     */
    public GameField () {
        _phGameField = new PhysicalGameField(this);
    }
    
    /**
     * Добавить элемент поля
     * @param element добавляемый элемент
     * @return успех добавления
     */
    public boolean addElementField(ElementField element){
        return true;
    }
    
    /**
     * Удалить элемент поля
     * @param element удаляемый элемент
     * @return усрех удаления
     */
    public boolean deleteElementField(ElementField element) {
        return true;
    }
    
    /**
     * Возвращает мяч
     * @return элемент поля - мяч
     */
    public ElementField ball() {
        return _ball;
    }
    
    /**
     * Возвращает ракетку
     * @return элемент поля - ракетка
     */
    public ElementField racket() {
        return _racket;
    }
    
    /**
     * Возвращает рой
     * @return элемент поля - рой
     */
    public ElementField swarm () {
        return _swarm;
    }
    
    /**
     * Возвращает массив разрушаемых кирпичей
     * @return  массив элементов поля - разрушаемые кирпичи
     */
    public ArrayList <ElementField> destructibleBricks () {
        return _dBricks;
    }
    
    /**
     * Возвращает массив неразрушаемых кирпичей
     * @return  массив элементов поля - неразрушаемые кирпичи
     */
    public ArrayList <ElementField> indestructibleBricks () {
        return _iBricks;
    }
    
    /**
     * Возвращает границы поля
     * @return возвращает массив элементов поля - границы поля
     */
    public ArrayList <ElementField> bondarysField () {
        return _bondarysField;
    }
}
