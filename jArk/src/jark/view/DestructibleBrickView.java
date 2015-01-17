/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jark.view;

import com.golden.gamedev.object.Sprite;
import jark.model.BoundaryField;
import jark.model.DestructibleBrick;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Класс физического представления разбиваемого кирпича
 * @author пользователь
 */
public class DestructibleBrickView extends ElementFieldView{

    public DestructibleBrickView (int hardness, int x, int y) {
        BufferedImage img = null;
        try 
        {
            switch (hardness) {
                case 1: {
                    double rand = (Math.random() * 1);
                    if(Math.round(rand) == 0)
                    img = ImageIO.read(new File("src\\jark\\brick.png"));
                    else img = ImageIO.read(new File("src\\jark\\brick3.png"));
                    break;
                } case 2: {
                    img = ImageIO.read(new File("src\\jark\\brick1.png"));
                    break;
                } case 3: {
                    img = ImageIO.read(new File("src\\jark\\brick2.png"));
                    break;
                }
            }
            this._elementSprite = new Sprite(img,x,y);
            this._elementSprite.setID(3);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

}