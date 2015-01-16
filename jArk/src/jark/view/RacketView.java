/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jark.view;

import com.golden.gamedev.object.Sprite;
import jark.model.Racket;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Класс физического представления ракетки
 * @author пользователь
 */
public class RacketView extends ElementFieldView{
    
    public RacketView(int x, int y) {
        BufferedImage img = null;
        try 
        {
            img = ImageIO.read(new File("src\\jark\\racket.png"));
            this._elementSprite = new Sprite(img, x, y);
            this._elementSprite.setID(5);
            _elementSprite.setSpeed(0, 0);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

}
