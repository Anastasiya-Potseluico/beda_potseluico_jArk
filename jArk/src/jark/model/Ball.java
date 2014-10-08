/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jArk.physicalObjects.PhysicalBall;

/**
 * Класс мяча
 * @author Дарья
 */
public class Ball extends ElementField {
    
    /**
     * Конструктор
     */
    public Ball() {
        _phElementField = new PhysicalBall(this);             
    }
    
    /**
     * Отскочить от элемента поля
     * @param element элемент поля, от которого отскакивает мяч
     * @return результат отскока
     */
    public boolean rebound(ElementField element) {
        return true;
    }
}
