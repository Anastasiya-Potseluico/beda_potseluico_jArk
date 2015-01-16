/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jark.events.DestructionEvent;
import jark.events.DestructionListener;
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
            return _balls.add((Ball)element);
        } else if (element instanceof BoundaryField) {
            return _bondarysField.add((BoundaryField)element);
        } else if (element instanceof Racket) {
            _racket = (Racket)element;
            return true;
        }
        return false;
    }
    
    /**
     * Удалить элемент поля
     * @param element удаляемый элемент
     * @return 
     */
    public boolean deleteElementField(ElementField element) {
        if (element instanceof Ball) {
            return _balls.remove((Ball)element);
        } else if (element instanceof BoundaryField) {
            return _bondarysField.remove((BoundaryField)element);
        } else if (element instanceof Racket) {
            _racket = null;
            return true;
        }
        return false;
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
        this._bondarysField.clear();
        this._balls.clear();
        for (int i = 0; i < level; i++) {
            this.addElementField(new Ball());
        }
        this.addElementField(new BoundaryField(TYPE.HORISONTAL));
        this.addElementField(new BoundaryField(TYPE.VERTICAL));
        this.addElementField(new BoundaryField(TYPE.VERTICAL));
        this.addElementField(new Racket());
    }
    
    public class removeBrick implements DestructionListener {
        /*@Override
        public void brickHitted(DestructionEvent e, DestructibleBrick dBrick) {
            if(dBrick.hadrness() == 0) {
                _dBricks.remove(dBrick);
            }
        } */
    }
}
