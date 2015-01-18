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
 * Класс физического представления разрушаемого кирпича
 * @author пользователь
 */
public class DestructibleBrickView extends ElementFieldView{

    /**
     * Конструктор физического представления разрушаемого кирпича
     * @param hardness прочность кирпича
     * @param x координата х кирпича на поле
     * @param y координата у кирпича на поле
     */
    public DestructibleBrickView (int hardness, int x, int y) {
        BufferedImage img = null;
        try 
        {
            switch (hardness) { // Кирпичи с разной прочностью имеют разные спрайты
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
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
