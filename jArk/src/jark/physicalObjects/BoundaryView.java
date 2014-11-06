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
public class BoundaryView extends ElementFieldView {
    /** Логическое представление границы поля */
    private BoundaryField _boundaryField;
    
    /**
     * Конструктор
     */
    public BoundaryView () {
    }
    
    /**
     * Устанавливает логическое представление границы поля
     * @param boundaryField логическое представление границы поля
     */
    public void setBoundaryView (BoundaryField boundaryField) {
        _boundaryField = boundaryField;
    }
    
    /**
     * Возвращает логическое рпедставление границы поля
     * @return граница поля
     */
    public BoundaryField boundaryField () {
        return _boundaryField;
    }
    
    /**
     * Функция для проверки, принадлежит ли элемент границам поля
     * @param _element элемент, который надо проверить
     * @return признак принадлежности
     */
    public boolean isInBoundary(ElementFieldView _element){
        return true;
    }
}
