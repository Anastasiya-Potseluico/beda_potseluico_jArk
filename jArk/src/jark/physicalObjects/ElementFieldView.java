/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

import jark.model.ElementField;

/**
 * Класс физического представления элемента поля
 * @author пользователь
 */
public abstract class ElementFieldView{
    
    /** Логика элемента поля */
    protected ElementField _elementField;
    
    /**
     * Установить логич.представление элемента поля
     * @param element логическое представление элемента поля
     */
    public void setElemenetField (ElementField element) {
        _elementField = element;
    }
    
    /**
     * Возвращает логическое представление элемента поля
     * @return элемент поля
     */
    public  ElementField elementField() {
        return _elementField;
    }
}
