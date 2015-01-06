/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.collisionManagers;

import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.AdvanceCollisionGroup;
import jArk.physicalObjects.ElementFieldView;
import jArk.physicalObjects.GameFieldView;
import jark.model.Ball;
import jark.model.ElementField;
import java.util.ArrayList;

/**
 * Класс обработчика коллизий
 * @author пользователь
 */
public class CollisionMan{
    
    private Collision _collision = new Collision(this);
    
    private CollisionManager _collisionManager = _collision;
   
    private GameFieldView _fieldView; //Под вопросом правильность данной связи
    
    public CollisionMan (GameFieldView fieldView) {
        _fieldView = fieldView;
    }
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
    public void manageCollision(Sprite sprite, Sprite sprite1){
        if(sprite!=sprite1) {
            sprite.setHorizontalSpeed(0.1);
        }
    }
    
    private ElementField findElement (Sprite sprite) {
        return new Ball();
    }
}
