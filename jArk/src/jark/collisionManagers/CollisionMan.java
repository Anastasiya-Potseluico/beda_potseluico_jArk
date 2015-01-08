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
import jark.model.DestructibleBrick;
import jark.model.ElementField;
import jark.model.IndestructibleBrick;
import jark.model.Racket;
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
        ElementField first, second;
        first = findElement(sprite);
        second = findElement(sprite1);
        if(second instanceof Ball) {
            
        } else if (second instanceof DestructibleBrick) {
            ((DestructibleBrick)second).reactOnCollision((Ball)first);
        } else if (second instanceof Racket) {
            ((Racket)second).collideWithMovableElement((Ball)first);//  ????
        } 
        
    }
    
    private ElementField findElement (Sprite sprite) {
        ElementField founded;
        int i;
        switch (sprite.getID()) {
            case 1: { //Id для мячей
                for(i = 0; i < this._fieldView.ballsView().size(); i++) {
                    if(this._fieldView.ballsView().get(i).sprite() == sprite) {
                        founded = this._fieldView.ballsView().get(i).ball();
                        return founded;
                    }
                }
                break;
            } case 2: { //Id для границ
                for(i = 0; i < this._fieldView.boundariesView().size(); i++) {
                    if(this._fieldView.boundariesView().get(i).sprite() == sprite) {
                        founded = this._fieldView.boundariesView().get(i).boundaryField();
                        return founded;
                    }
                }
                break;
            } case 3: { //Id для разрушаемых кирпичей
                for(i = 0; i < this._fieldView.dBricksView().size(); i++) {
                    if(this._fieldView.dBricksView().get(i).sprite() == sprite) {
                        founded = this._fieldView.dBricksView().get(i).dBrick();
                        return founded;
                    }
                }
                break;
            } case 4: { //Id для неразрушаемых кирпичей
                for(i = 0; i < this._fieldView.iBricksView().size(); i++) {
                    if(this._fieldView.iBricksView().get(i).sprite() == sprite) {
                        founded = this._fieldView.iBricksView().get(i).iBrick();
                        return founded;
                    }
                }
                break;
            } case 5: { //Id для ракетки
                founded = this._fieldView.racketView().racket();
                return founded;
            } case 6: { //Id для элементов роя
                break;
            }
            
        }
        return new Ball();
    }
}
