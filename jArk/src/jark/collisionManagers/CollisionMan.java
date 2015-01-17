/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.collisionManagers;

import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.Sprite;
import jark.model.Ball;
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
    
    public enum TYPE {DEFAULT, PAIR, BALLS};
    
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
    private int _countReact = 0;
    /**
     * Метод для обработки коллизии
     * @param sprite1
     * @param sprite2
     * @param countFaced
     */
    public void manageCollision(Sprite sprite1, Sprite sprite2, int countFaced){
        ElementField first, second;
        first = Buffer.findElement(sprite1);
        second = Buffer.findElement(sprite2);
        TYPE type = TYPE.DEFAULT;
        switch(countFaced) {
            case 2: {
                if(!(second instanceof Ball)) {
                    type = TYPE.PAIR;
                } else {
                    type = TYPE.BALLS;
                }
                break;
            }       
        }
        if(_countReact == 0) 
            first.reactOnCollision(second, type);
        second.reactOnCollision(first, type);
        _countReact++;
        if(_countReact == countFaced)
            _countReact = 0;
    }
    
    
}