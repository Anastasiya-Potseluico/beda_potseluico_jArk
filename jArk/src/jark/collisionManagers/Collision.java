/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.collisionManagers;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.AdvanceCollisionGroup;
import jArk.physicalObjects.GameFieldView;

/**
 *
 * @author Дарья
 */
public class Collision extends AdvanceCollisionGroup{
    
    private CollisionMan _collisionMan;
    
    
    public Collision(CollisionMan collisionMan) {
        _collisionMan = collisionMan;
    }

    @Override
    public void collided(Sprite sprite, Sprite sprite1) {
        //передать в менеджер спрайты
        _collisionMan.manageCollision(sprite, sprite1);
    }
    
}
