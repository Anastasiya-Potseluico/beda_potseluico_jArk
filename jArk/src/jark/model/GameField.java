/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jark.view.GameFieldView;
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
    private Racket _racket;
    /** Границы поля */
    private ArrayList <BoundaryField> _bondarysField = new ArrayList();
    /** */
    private GameFieldView _gameFieldView;
    /**
     * Конструктор
     */
    public GameField () {
        _gameFieldView = new GameFieldView();
        addElementField(new BoundaryField(TYPE.HORISONTAL, 0, 0));
        addElementField(new BoundaryField(TYPE.VERTICAL, 0, 0));
        addElementField(new BoundaryField(TYPE.VERTICAL, 635, 0));
        addElementField(new Racket(250, 500));
    }
    
    /**
     * 
     * @return 
     */
    public GameFieldView gameFieldView() {
        return _gameFieldView;
    }

    /**
     * Добавить элемент поля
     * @param element добавляемый элемент
     * @return успех добавления
     */
    public boolean addElementField(ElementField element){
        gameFieldView().addElementFieldView(element);
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
        this._balls.clear();
        this.addElementField(new Ball(295, 464));
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
