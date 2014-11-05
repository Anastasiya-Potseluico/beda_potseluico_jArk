/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

import jark.model.Ball;

/**
 * Класс физического представления мяча
 * @author пользователь
 */
public class BallView extends ElementFieldView{
   /** Логическое представление мяча */
    private Ball _ball;
    
    /**
    * Конструктор
    */ 
    public BallView() {
    }
    
    /**
     * Возвращает логич.представление мяча
     * @return мяч
     */
    public Ball ball(){
        return _ball;
    }
    
    /**
     * Установить логич. представление мяча
     * @param ball мяч
     */
    public void setBall(Ball ball) {
        _ball = ball;
    }
}
