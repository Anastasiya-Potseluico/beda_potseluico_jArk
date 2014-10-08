/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jArk.specifications;

/**
 * Размер объекта игрового поля
 * @author Дарья
 */
public class Size {
    /** Ширина */
    private double _width;
    /** Высота */
    private double _height;
    
    /**
     * Изменить размер
     * @param width ширина
     * @param height высота
     * @return успех изменения размера
     */
    public boolean setSize (double width, double height) {
        _width = width;
        _height = height;
        return true;
    }
    
    /**
     * Возвращает ширину
     * @return ширина
     */
    public double width() {
        return _width;
    }
    
    /**
     * Возвращает высоту
     * @return высота
     */
    public double height () {
        return _height;
    }
    
}
