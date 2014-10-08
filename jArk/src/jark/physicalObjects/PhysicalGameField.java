/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

import jark.Buffer;

/**
 * Класс физического представления игрового поля
 * @author пользователь
 */
public class PhysicalGameField {
    
    /**
    * Массив элементов, содержащихся на поле
    */
    private PhysicalElementField _field[];
    /** Буфер обмена между логическими и физическими объектами игры */
    private Buffer _buffer;
    
    public PhysicalGameField (Buffer buffer) {
        _buffer = buffer;
    }
    
}
