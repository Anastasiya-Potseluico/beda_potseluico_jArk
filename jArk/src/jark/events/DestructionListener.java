/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.events;

import jark.model.DestructibleBrick;
import java.util.EventListener;

/**
 *
 * @author пользователь
 */
public interface DestructionListener extends EventListener{
    void brickDestroyed(DestructionEvent e, DestructibleBrick dBrick);
}
