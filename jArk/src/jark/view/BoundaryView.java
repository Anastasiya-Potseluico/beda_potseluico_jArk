/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jark.view;

import jark.model.*;
import com.golden.gamedev.object.Sprite;
import jark.model.BoundaryField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 * Класс физического представления границ поля
 * @author пользователь
 */
public class BoundaryView extends ElementFieldView {
    /**
     * Конструктор
     */
    public BoundaryView (BoundaryField.TYPE type,int x, int y) {
        BufferedImage img = null;
        try 
        {
            if(type == BoundaryField.TYPE.HORISONTAL)
                img = ImageIO.read(new File("src\\jark\\h_board.png"));
            else 
                img = ImageIO.read(new File("src\\jark\\v_board.png"));
            this._elementSprite = new Sprite(img, x, y);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
