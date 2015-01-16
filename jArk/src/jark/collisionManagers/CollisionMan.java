/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.collisionManagers;

import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.Sprite;
import jark.model.ElementField;
import jark.specifications.Buffer;

/**
 * Класс обработчика коллизий
 * @author пользователь
 */
public class CollisionMan{
    
    private Collision _collision = new Collision(this);
    
    private CollisionManager _collisionManager = _collision;

    public void checkCollision () {
        _collisionManager.checkCollision();
    }
    
    public Collision collision() {
        return this._collision;
    }
    
    public void setPerfectCollision(boolean isPerfCollision) {
        _collision.pixelPerfectCollision = isPerfCollision;
    }
    /**
     * Метод для обработки коллизии
     */
    public void manageCollision(Sprite sprite1, Sprite sprite2){
        ElementField first, second;
        first = Buffer.findElement(sprite1);
        second = Buffer.findElement(sprite2);
        first.reactOnCollision(second);
        second.reactOnCollision(first);
    }
    
    
}
