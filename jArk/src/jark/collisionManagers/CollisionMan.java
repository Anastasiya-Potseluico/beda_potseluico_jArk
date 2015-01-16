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
    
    private Collision _collisionRacketBoundaries = new Collision(this);   
    private CollisionManager _collisionManagerRacketBoundaries = _collisionRacketBoundaries;
    
    private Collision _collisionBallsBarrier = new Collision(this);   
    private CollisionManager _collisionManagerBallsBarrier = _collisionBallsBarrier;
    
    private Collision _collisionBallsBalls = new Collision(this);   
    private CollisionManager _collisionManagerBallsBalls = _collisionBallsBalls;
    
    public void checkCollision () {
        _collisionManagerRacketBoundaries.checkCollision();
        _collisionManagerBallsBarrier.checkCollision();
        _collisionManagerBallsBalls.checkCollision();
    }
    
    public Collision collisionRacketBoundaries() {
        return _collisionRacketBoundaries;   
    }
    
    public Collision collisionBallsBarrier() {
        return _collisionBallsBarrier;
    }
    
    public Collision collisionBallsBalls() {
        return _collisionBallsBalls;
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