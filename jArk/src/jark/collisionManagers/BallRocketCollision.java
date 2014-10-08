/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jArk.collisionManagers;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.*;

/**
 *Класс для разрешения коллизии типа "Мяч - Ракетка"
 * @author пользователь
 */
public class BallRocketCollision extends AdvanceCollisionGroup {

    /**
     * Метод для обработки столкновения мяча и ракетки. Обработка поведения мяча
     * @param sprite - спрайт мяча
     * @param sprite1 - спрайт ракетки
     */
    @Override
    public void collided(Sprite sprite, Sprite sprite1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
