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
    * @param ball логическое представление мяча
    */ 
    public BallView(Ball ball) {
        _ball = ball;
    }
}
