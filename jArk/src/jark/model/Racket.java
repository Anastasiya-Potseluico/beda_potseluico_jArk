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

    /**
     * Конструктор ракетки
     * @param weight вес ракетки
     */
    public Racket(int weight) {
        super(weight);
    }
    
    /**
     * Толкнуть мяч
     * @return успех толкания мяча
     */
    public boolean pushBall() {
        return true;
    }

    /**
     * Функция обработки столкновения с движимым объектом
     * @param _element Элемент,с которым произошло столкновение
     */
    @Override
    public void collideWithMovableElement(ElementField _element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Функция обработки столкновения с неподвижным объектом
     * @param _element Элемент,с которым произошло столкновение
     */
    @Override
    public void collideWithUnmovableElement(ElementField _element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reactOnCollision(ElementField element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
