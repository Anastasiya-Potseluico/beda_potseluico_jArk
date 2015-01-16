/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jark.view;

import com.golden.gamedev.object.Sprite;
import jark.model.Ball;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Класс физического представления мяча
 * @author пользователь
 */
public class BallView extends ElementFieldView{
    /**
    * Конструктор
     * @param ball
    */ 
    public BallView(Ball ball, int x, int y) {
        this._elementField = ball;
        BufferedImage img = null;
        try 
        {
            img = ImageIO.read(new File("src\\jark\\ball.png"));
            this._elementSprite = new Sprite(img, x, y);
            this._elementSprite.setID(1);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Возвращает логич.представление мяча
     * @return мяч
     */
    public Ball ball(){
        return (Ball)_elementField;
    }
    
    /**
     * Установить логич. представление мяча
     * @param ball мяч
     */
    public void setBall(Ball ball) {
        _elementField = ball;
    }
}
