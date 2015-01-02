/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

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
    /** Логическое представление разрушаемого кирпича */
    private DestructibleBrick _dBrick;
    
    /**
     * Конструктор
     */
    public DestructibleBrickView (DestructibleBrick dBrick) {
        _dBrick = dBrick;
    }
    
    public DestructibleBrickView (DestructibleBrick brick, int x, int y) {
        this._dBrick = brick;
        BufferedImage img = null;
        try 
        {
            switch (_dBrick.hadrness()) {
                case 1: {
                    img = ImageIO.read(new File("src\\jark\\brick.png"));
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
    
    /**
     * Возвращает логическое представление разрушаемого кирпича
     * @return разрушаемый кирпич
     */
    public DestructibleBrick dBrick () {
        return _dBrick;
    }
}
