/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jark.collisionManagers.CollisionMan;

/**
 * Класс элемента роя
 *
 * @author Дарья
 */
public class ElementSwarm extends ElementField {

    public ElementSwarm(int x, int y) {
        super(MASS.OTHER, x, y);
    }

    @Override
    public void reactOnCollision(ElementField element, CollisionMan.TYPE type) {

    }

    @Override
    public ElementField copy() {
        return null;
    }

}
