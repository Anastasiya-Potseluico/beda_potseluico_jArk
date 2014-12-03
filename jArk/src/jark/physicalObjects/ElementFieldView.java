/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

import com.golden.gamedev.object.Sprite;
import jark.model.ElementField;
import java.awt.Graphics2D;

/**
 * Класс физического представления элемента поля
 * @author пользователь
 */
public abstract class ElementFieldView{
    
    /** Логика элемента поля */
    protected ElementField _elementField;
    
    protected Sprite _elementSprite;
    
    /**
     * Установить логич.представление элемента поля
     * @param element логическое представление элемента поля
     */
    public void setElemenetField (ElementField element) {
        _elementField = element;
    }
    
   /**
    * Метод обновления спрайта
    * @param elapsedTime период обновления
    */
    public void update(int elapsedTime){
       _elementSprite.update(elapsedTime);
    }
    
    /**
     * Метод для перерисовки спрайта
     * @param g 
     */
    public void render (Graphics2D g){
        _elementSprite.render(g);
    }
    
    
    public void setSpeed(double vX, double vY){
        _elementSprite.setSpeed(vX, vY);
    }
    
    
    /**
     * Возвращает логическое представление элемента поля
     * @return элемент поля
     */
    public  ElementField elementField() {
        return _elementField;
    }
}
