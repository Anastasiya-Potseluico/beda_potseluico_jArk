/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jArk.physicalObjects.PhysicalBoundary;

/**
 * Класс границы поля
 * @author Дарья
 */
public class BoundaryField extends ElementField {
    /**
     * Конструктор
     */
    public BoundaryField () {
        _phElementField = new PhysicalBoundary(this);
    }
}
