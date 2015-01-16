/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jark.view;

import com.golden.gamedev.object.Sprite;
import jark.model.IndestructibleBrick;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Класс физического представления неразбиваемого кирпича
 * @author пользователь
 */
public class IndestructibleBrickView extends ElementFieldView{
    
    public IndestructibleBrickView (int x, int y) {
        BufferedImage img = null;
        try 
        {
            img = ImageIO.read(new File("src\\jark\\ibrick.png"));
            this._elementSprite = new Sprite(img,x,y);
            this._elementSprite.setID(4);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

}
