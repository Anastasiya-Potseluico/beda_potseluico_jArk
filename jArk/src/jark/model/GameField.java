/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jark.Buffer;
import java.util.ArrayList;

/**
 * Класс игрового поля
 * @author Дарья
 */
public class GameField {
   /** Буффер обмена между логическими и физическими объектами игры */
    private Buffer _buffer;
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
    
    /** Конструктор */
    public GameField (Buffer buffer) {
        _buffer = buffer;
    }
    
    /** Добавить элемент поля */
    public boolean addElementField(ElementField element){
        return true;
    }
    /** Удалить элемент поля */
    public boolean deleteElementField(ElementField element) {
        return true;
    }
}
