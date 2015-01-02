/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jark.model.BoundaryField.TYPE;
import java.util.ArrayList;

/**
 * Класс игрового поля
 * @author Дарья
 */
public class GameField {
    /** Мячи */
    private ArrayList <Ball> _balls = new ArrayList();
    /** Ракетка */
    private Racket _racket = new Racket();
    /** Рой */
    private ArrayList <Swarm> _swarms = new ArrayList();;
    /** Разрушаемые кирпичи */
    private ArrayList <DestructibleBrick> _dBricks = new ArrayList();
    /** Неразрушаемые кирпичи */
    private ArrayList <IndestructibleBrick> _iBricks = new ArrayList();
    /** Границы поля */
    private ArrayList <BoundaryField> _bondarysField = new ArrayList();
   
    /**
     * Конструктор
     */
    public GameField () {
    }

    /**
     * Добавить элемент поля
     * @param element добавляемый элемент
     * @return успех добавления
     */
    public boolean addElementField(ElementField element){
        if (element instanceof Ball) {
            _balls.add((Ball)element);
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
            _balls.remove((Ball)element);
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
    public ArrayList <Ball> balls() {
        return _balls;
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
    public ArrayList <Swarm> swarms () {
        return _swarms;
    }
    
    /**
     * Возвращает массив разрушаемых кирпичей
     * @return  массив элементов поля - разрушаемые кирпичи
     */
    public ArrayList <DestructibleBrick> destructibleBricks () {
        return _dBricks;
    }
    
    /**
     * Возвращает массив неразрушаемых кирпичей
     * @return  массив элементов поля - неразрушаемые кирпичи
     */
    public ArrayList <IndestructibleBrick> indestructibleBricks () {
        return _iBricks;
    }
    
    /**
     * Возвращает границы поля
     * @return возвращает массив элементов поля - границы поля
     */
    public ArrayList <BoundaryField> bondarysField () {
        return _bondarysField;
    }
    
    /**
     *
     * @param level
     */
    public void setField (int level) {
        this._dBricks.clear();
        this._iBricks.clear();
        this._swarms.clear();
        this._bondarysField.clear();
        switch(level){
            case 1: {
                
                this.addElementField(new DestructibleBrick(1));
                this.addElementField(new DestructibleBrick(2));
                this.addElementField(new DestructibleBrick(3));
                this.addElementField(new IndestructibleBrick());
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
        this.addElementField(new BoundaryField(TYPE.HORISONTAL));
        this.addElementField(new BoundaryField(TYPE.VERTICAL));
        this.addElementField(new BoundaryField(TYPE.VERTICAL));
        this.addElementField(new Ball());
        this.addElementField(new Ball());
        this.addElementField(new Racket());
    }
}
