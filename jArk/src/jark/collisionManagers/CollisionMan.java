/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.collisionManagers;

import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.Sprite;
import jArk.physicalObjects.GameFieldView;
import jark.model.ElementField;

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
    public void manageCollision(Sprite sprite1, Sprite sprite2){
        ElementField first, second;
        first = findElement(sprite1);
        second = findElement(sprite2);
        first.reactOnCollision(second);
        second.reactOnCollision(first);
        /*if(second instanceof Ball) {
            ((Ball)second).collideWithMovableElement((Ball)first);
        } else if (second instanceof BoundaryField) {
            ((BoundaryField)second).reactOnCollision((Ball)first);
        } else if (second instanceof Racket) {
            ((Racket)second).collideWithMovableElement((Ball)first);//  ????
        }*/
                
        
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
            } case 3: { //Id для ракетки
                founded = this._fieldView.racketView().racket();
                return founded;
            }
            
        }
        return null;
    }
}
