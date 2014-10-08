/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jArk.specifications;

/**
 * Позиция элемента поля
 * @author Дарья
 */
public class Position {
    /** Х координата */
    private double _x;
    /** У координата */
    private double _y;
    
    /**
     * Изменить позицию
     * @param x Х координата
     * @param y У координата
     * @return результат изменения позиции
     */
    public boolean setPosition (double x, double y) {
        return true;
    }
    
    /**
     * Возвращает Х координату
     * @return Х координата
     */
    public double x () {
        return _x;
    }
    
    /**
     * Возвращает У координату
     * @return У координата
     */
    public double y () {
        return _y;
    }
}
