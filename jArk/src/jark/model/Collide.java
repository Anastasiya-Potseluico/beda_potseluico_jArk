/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jark.collisionManagers.CollisionMan;

/**
 *
 * @author пользователь
 */
public interface Collide {
    public void collideWithMovableElement(ElementField _element, CollisionMan.TYPE type);
    public void collideWithUnmovableElement(ElementField _element, CollisionMan.TYPE type);
}
