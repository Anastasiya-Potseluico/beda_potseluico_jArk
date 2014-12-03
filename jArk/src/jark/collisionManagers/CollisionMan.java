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
import jark.model.Ball;
import jark.model.ElementField;
import java.util.ArrayList;

/**
 * Класс обработчика коллизий
 * @author пользователь
 */
public class CollisionMan{
    
    private CollisionManager _collisionManager = new Collision(this);
    
    public void checkCollision () {
        _collisionManager.checkCollision();
    }
    
    /**
     * Метод для обработки коллизии
     */
    public void manageCollision(Sprite sprite, Sprite sprite1){
        //преобразовать спрайты в модели
        
    }
    
    /**
     * Метод для добавления групп коллизий (чтобы менеджер не обращался к полю)
     * @param elements
     */
    public void setCollisionGroups(ArrayList <ElementField> elements){
        SpriteGroup group1 = null;
        SpriteGroup group2 = null;
        //преобразовать модель в sprite
        //мяч+ракетка против всех
       _collisionManager.setCollisionGroup(group1, group2);
    }

    private Sprite elementToSprite(ElementField element){
        return new Sprite();
    }
    
    private ElementField spriteToElement (Sprite sprite) {
        return new Ball();
    }
}
