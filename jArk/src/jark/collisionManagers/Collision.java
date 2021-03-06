/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.collisionManagers;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.AdvanceCollisionGroup;
import java.util.HashMap;

/**
 *
 * @author Дарья
 */
public class Collision extends AdvanceCollisionGroup{
    /**
     * Обработчик коллизий
     */
    private CollisionMan _collisionMan;
    
    /**
     * Конструктор
     * @param collisionMan обработчик коллизий
     */
    public Collision(CollisionMan collisionMan) {
        _collisionMan = collisionMan;
        pixelPerfectCollision = true;
    }

    @Override
    public void collided(Sprite sprite1, Sprite sprite2) {
        //передать в менеджер спрайты
        int countFaced = 1;
        for (Object ll : ((HashMap)this.getStorage()).values()) {
            countFaced = ((Sprite[]) ll).length;
        }
        _collisionMan.manageCollision(sprite1, sprite2, countFaced);
    }
    
}