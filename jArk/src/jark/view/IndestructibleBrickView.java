/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jark.view;

import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Класс физического представления неразбиваемого кирпича
 * @author пользователь
 */
public class IndestructibleBrickView extends ElementFieldView{
    /**
     * Конструктор физического представления разрушаемого кирпича
     * @param x координата х кирпичана поле
     * @param y координата у кирпичана поле
     */
    public IndestructibleBrickView (int x, int y) {
        BufferedImage img = null;
        try 
        {
            img = ImageIO.read(new File("src\\jark\\ibrick.png"));
            this._elementSprite = new Sprite(img,x,y);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
