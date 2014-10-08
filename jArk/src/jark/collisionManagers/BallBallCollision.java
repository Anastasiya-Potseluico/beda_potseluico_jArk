/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package jArk.collisionManagers;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.*;
/**
 * Класс для разрешения коллизии типа "Мяч - мяч"
 * @author пользователь
 */
public class BallBallCollision extends AdvanceCollisionGroup{

    /**
     * Метод для обработки столкновения двух мячей
     * @param sprite - спрайт первого мяча
     * @param sprite1 - спрайт второго мяча
     */
    @Override
    public void collided(Sprite sprite, Sprite sprite1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
