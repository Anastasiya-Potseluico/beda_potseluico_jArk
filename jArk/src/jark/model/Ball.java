/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;


/**
 * Класс мяча
 * @author Дарья
 */
public class Ball extends ElementField implements Collide {
    
    /**
     * Конструктор
     * @param weight Вес мяча
     */
    public Ball(int weight) {
        super(weight);
    }
    
    /**
     * Отскочить от элемента поля
     * @param element элемент поля, от которого отскакивает мяч
     * @return результат отскока
     */
    private boolean rebound(ElementField element) {
        
        return true;
    }

    /**
     * Функция обработки столкновения с движимым объектом
     * @param _element Элемент,с которым произошло столкновение
     */
    @Override
    public void collideWithMovableElement(ElementField _element) {
        if(_element instanceof Racket) {
            collideWithRacket((Racket) _element);
        } else if (_element instanceof Ball) {
            collideWithBall((Ball) _element);
        } else if (_element instanceof Swarm) {
            collideWithSwarm((Swarm) _element);
        }
    }

    /**
     * Функция обработки столкновения с неподвижным объектом
     * @param _element Элемент,с которым произошло столкновение
     */
    @Override
    public void collideWithUnmovableElement(ElementField _element) {
        rebound(_element);
    }

    @Override
    public void reactOnCollision(ElementField element) {
        //TODO from elementfield
    }


    private void collideWithRacket(Racket racket) {
        //TODO
    }
    
    private void collideWithBall(Ball ball) {
        //TODO
    }
    
    private void collideWithSwarm(Swarm swarm) {
        //TODO
    }
}
