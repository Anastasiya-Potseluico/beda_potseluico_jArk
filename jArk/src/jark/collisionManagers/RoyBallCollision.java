/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.collisionManagers;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.*;

/**
 * Класс для разрешения коллизии типа "Рой - Мяч"
 * @author пользователь
 */
public class RoyBallCollision extends AdvanceCollisionGroup{

    /**
     * Метод для разрешения столкновения роя и ракетки. Обработка поведения ракетки
     * @param sprite - спрайт ракетки
     * @param sprite1 - спрайт мяча
     */
    @Override
    public void collided(Sprite sprite, Sprite sprite1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
