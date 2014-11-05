/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

import jark.model.Racket;

/**
 * Класс физического представления ракетки
 * @author пользователь
 */
public class RacketView extends ElementFieldView{
    /** Логическое пердставление ракетки */
    private Racket _racket;
    
    /**
     * Устанавливает логическое предствление ракетки
     * @param racket логическое представление ракетки
     */
    public void setRacket (Racket racket) {
        _racket = racket;
    }
    
    /**
     * Возвращает логическое представление ракетки
     * @return логическое представление ракетки
     */
    public Racket racket() {
        return _racket;
    }
}
