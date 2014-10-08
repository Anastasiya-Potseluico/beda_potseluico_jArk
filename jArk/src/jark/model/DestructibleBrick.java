/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jArk.physicalObjects.PhysicalDestructibleBrick;

/**
 * Класс разрушаемого кирпича
 * @author Дарья
 */
public class DestructibleBrick extends Brick{
    /**
     * Конструктор
     */
    public DestructibleBrick() {
        _phElementField = new PhysicalDestructibleBrick(this);
    }
}
