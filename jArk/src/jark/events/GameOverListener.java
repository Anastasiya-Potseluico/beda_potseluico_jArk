/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.events;

import jark.model.Ball;
import java.util.EventListener;

/**
 *
 * @author Дарья
 */
public interface GameOverListener extends EventListener{
    void delBall(Ball ball);
}
