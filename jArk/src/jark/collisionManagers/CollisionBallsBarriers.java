/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.collisionManagers;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.AdvanceCollisionGroup;

/**
 *
 * @author Дарья
 */
public class CollisionBallsBarriers extends AdvanceCollisionGroup{
    
    private CollisionMan _collisionMan;
    
    
    public CollisionBallsBarriers(CollisionMan collisionMan) {
        _collisionMan = collisionMan;
        pixelPerfectCollision = true;
    }

    @Override
    public void collided(Sprite sprite1, Sprite sprite2) {
        //передать в менеджер спрайты
        _collisionMan.manageCollision(sprite1, sprite2);
    }
    
}
