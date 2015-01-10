/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

/**
 * Класс ракетки
 * @author Дарья
 */
public class Racket extends ElementField implements Collide {

    boolean _hasBall;
    /**
     * Конструктор ракетки
     */
    public Racket() {
        super(MASS.INF_MASS);
        _hasBall = true;
    }
    
    public boolean hasBall() {
        return _hasBall;
    }
    
    public void resetBall() {
        _hasBall = false;
    }

    /**
     * Функция обработки столкновения с движимым объектом
     * @param _element Элемент,с которым произошло столкновение
     */
    @Override
    public void collideWithMovableElement(ElementField _element) {
        
    }

    /**
     * Функция обработки столкновения с неподвижным объектом
     * @param _element Элемент,с которым произошло столкновение
     */
    @Override
    public void collideWithUnmovableElement(ElementField _element) {
        //Ограничить движение пользователя
    }

    @Override
    public void reactOnCollision(ElementField element) {
        
    }
}
