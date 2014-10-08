/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

import jark.model.BoundaryField;

/**
 * Класс физического представления границ поля
 * @author пользователь
 */
public class PhysicalBoundary extends PhysicalElementField {
    /** Логическое представление границы поля */
    private BoundaryField _boundaryField;
    
    /**
     * Конструктор
     * @param boundaryField логическое представление границы поля
     */
    public PhysicalBoundary (BoundaryField boundaryField) {
        _boundaryField = boundaryField;
    }
}
