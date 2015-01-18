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
 * Класс физического представления ракетки
 *
 * @author пользователь
 */
public class RacketView extends ElementFieldView {

    /**
     * Конструктор
     *
     * @param x координата по оси Х
     * @param y координата по оси У
     */
    public RacketView(int x, int y) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src\\jark\\racket.png"));
            _elementSprite = new Sprite(img, x, y);
            _elementSprite.setSpeed(0, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
