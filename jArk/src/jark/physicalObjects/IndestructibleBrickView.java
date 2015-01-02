/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

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
      /** Логическое представление разрушаемого кирпича */
    private IndestructibleBrick _iBrick;
    
    /**
     * Конструктор
     */
    public IndestructibleBrickView (IndestructibleBrick iBrick) {
        _iBrick = iBrick;
    }
    
    public IndestructibleBrickView (IndestructibleBrick brick, int x, int y) {
        this._iBrick = brick;
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
    
    /**
     * Возвращает логическое представление разрушаемого кирпича
     * @return разрушаемый кирпич
     */
    public IndestructibleBrick dBrick () {
        return _iBrick;
    }
}
