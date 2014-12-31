/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

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
    private ArrayList <ElementField> _swarms;
    /** Разрушаемые кирпичи */
    private ArrayList <ElementField> _dBricks;
    /** Неразрушаемые кирпичи */
    private ArrayList <ElementField> _iBricks;
    /** Границы поля */
    private ArrayList <ElementField> _bondarysField;
    
    /**
     * Конструктор
     */
    public GameField (int level) {
        
    }

    /**
     * Добавить элемент поля
     * @param element добавляемый элемент
     * @return успех добавления
     */
    public boolean addElementField(ElementField element){
        if (element instanceof Ball) {
            if (_ball == null) {
                _ball = (Ball)element;
                return true;
            } else return false;
        } else if (element instanceof DestructibleBrick) {
            _dBricks.add((DestructibleBrick)element);
        } else if (element instanceof BoundaryField) {
            _bondarysField.add((BoundaryField)element);
        } else if (element instanceof Swarm) {
            _swarms.add((Swarm)element);
        } else if (element instanceof IndestructibleBrick) {
            _iBricks.add((IndestructibleBrick)element);
        } else if (element instanceof Racket) {
            if (_racket == null) {
                _racket = (Racket)element;
                return true;
            } else return false;
        }
        return true;
    }
    
    /**
     * Удалить элемент поля
     * @param element удаляемый элемент
     */
    public void deleteElementField(ElementField element) {
        if (element instanceof Ball) {
            _ball = null;
        } else if (element instanceof DestructibleBrick) {
            _dBricks.remove((DestructibleBrick)element);
        } else if (element instanceof BoundaryField) {
            _bondarysField.remove((BoundaryField)element);
        } else if (element instanceof Swarm) {
            _swarms.remove((Swarm)element);
        } else if (element instanceof IndestructibleBrick) {
            _iBricks.remove((IndestructibleBrick)element);
        } else if (element instanceof Racket) {
            _racket = null;
        }
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
    public ArrayList <ElementField> swarms () {
        return _swarms;
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
    
    public void setField (int level) {
        this._dBricks.clear();
        this._iBricks.clear();
        this._swarms.clear();
        this._bondarysField.clear();
        
        this._bondarysField.add(new BoundaryField(TYPE.HORISONTAL));
        this._bondarysField.add(new BoundaryField(TYPE.HORISONTAL));
        this._bondarysField.add(new BoundaryField(TYPE.VERTICAL));
        this._bondarysField.add(new BoundaryField(TYPE.VERTICAL));
        switch(level){
            case 1: {
                
                break;
            } case 2: {
                
                break;
            } case 3: {
                
                break;
            } case 4: {
                
                break;
            } case 5: {
                
                break;
            }
           
            
        }
    }
}
