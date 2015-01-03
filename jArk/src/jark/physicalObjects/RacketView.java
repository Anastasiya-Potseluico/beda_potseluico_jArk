/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

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
    /** Логическое представление ракетки */
    private Racket _racket;
    
    public RacketView(Racket racket, int x, int y) {
        this._elementField = racket;
        BufferedImage img = null;
        try 
        {
            img = ImageIO.read(new File("src\\jark\\racket.png"));
            this._elementSprite = new Sprite(img, x, y);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Возвращает логическое представление ракетки
     * @return логическое представление ракетки
     */
    public Racket racket() {
        return _racket;
    }
}
