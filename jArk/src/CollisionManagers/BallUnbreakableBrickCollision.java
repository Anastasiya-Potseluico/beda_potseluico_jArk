/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CollisionManagers;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.*;
/**
 * Класс для разрешения коллизии типа "Мяч - Неразрушаемый кирпич"
 * @author пользователь
 */
public class BallUnbreakableBrickCollision extends AdvanceCollisionGroup{

    /**
     * Метод для обработки столкновения мяча и неразрушаемого кирпича 
     * @param sprite - спрайт мяча
     * @param sprite1 - спрайт неразрушаемого кирпича
     */
    @Override
    public void collided(Sprite sprite, Sprite sprite1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
