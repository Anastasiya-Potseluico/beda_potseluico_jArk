/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

import jark.model.DestructibleBrick;

/**
 * Класс физического представления разбиваемого кирпича
 * @author пользователь
 */
public class DestructibleBrickView extends ElementFieldView{
    /** Логическое представление разрушаемого кирпича */
    private DestructibleBrick _dBrick;
    
    /**
     * Конструктор
     * @param dBrick логическое представление разрушаемого кирпича
     */
    public DestructibleBrickView (DestructibleBrick dBrick) {
        _dBrick = dBrick;
    }
}
