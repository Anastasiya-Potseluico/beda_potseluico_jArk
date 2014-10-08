/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

import jark.model.GameField;

/**
 * Класс физического представления игрового поля
 * @author пользователь
 */
public class PhysicalGameField {
    
    /**
    * Массив элементов, содержащихся на поле
    */
    private PhysicalElementField _field[];
    /** Логическое представление игрового поля */
    private GameField _gameField;
    
    public PhysicalGameField (GameField gameField) {
        _gameField = gameField;
    }
    
}
