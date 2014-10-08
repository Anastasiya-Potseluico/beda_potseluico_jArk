/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jArk.physicalObjects.PhysicalElementField;
import jArk.specifications.Position;
import jArk.specifications.Size;
import jArk.specifications.Speed;

/**
 * Логическое представление элемента поля
 * @author Дарья
 */
public abstract class ElementField {
    /** Позиция */
    private Position _position;
    /** Размер */
    private Size _size;
    /** Скорость */
    private Speed _speed;
    /** Игровое поле */
    private GameField _gamefield;
    /** Представление элемента поля */
    private PhysicalElementField _phElementField;
}
