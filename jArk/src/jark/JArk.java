/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jark;

import com.golden.gamedev.GameLoader;
import java.awt.Dimension;
import java.io.File;

/**
 * Главный класс игры
 * @author пользователь
 */
public class JArk {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameLoader game = new GameLoader();
        game.setup(new JarkGame(), new Dimension(640,550), false);
        game.start();
    }
    
}
