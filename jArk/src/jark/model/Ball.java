/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import com.golden.gamedev.object.Sprite;
import jark.model.BoundaryField.TYPE;
import jark.specifications.Buffer;

/**
 * Класс мяча
 * @author Дарья
 */
public class Ball extends ElementField implements Collide {
    /**
     * Конструктор
     */
    public Ball(int x, int y) {
        super(MASS.FIN_MASS, x, y);
    }

    /**
     * Функция обработки столкновения с движимым объектом
     * @param _element Элемент,с которым произошло столкновение
     */
    @Override
    public void collideWithMovableElement(ElementField element) {
        
    }

    /**
     * Функция обработки столкновения с неподвижным объектом
     * @param element Элемент,с которым произошло столкновение
     */
    @Override
    public void collideWithUnmovableElement(ElementField element) {
        Sprite sp = Buffer.findSprite(this);
        if(element instanceof BoundaryField) {
            if(((BoundaryField)element).type() == TYPE.HORISONTAL) 
              setSpeed(sp.getHorizontalSpeed(), sp.getVerticalSpeed()*-1); 
            else
                setSpeed(sp.getHorizontalSpeed()*-1, sp.getVerticalSpeed());
        } else if(element instanceof Racket) {
            double delta = 0;
            if(sp.getHorizontalSpeed() == 0) {
                    if (Buffer.findSprite(element).getHorizontalSpeed() > 0 )
                        delta = 0.3;
                    else if (Buffer.findSprite(element).getHorizontalSpeed() < 0)
                        delta = -0.3;
            } else if ((Buffer.findSprite(element).getHorizontalSpeed() < 0 && sp.getHorizontalSpeed() > 0) ||
                    (Buffer.findSprite(element).getHorizontalSpeed() > 0 && sp.getHorizontalSpeed() < 0))
                        delta = sp.getHorizontalSpeed() * -1;
            else
                delta = sp.getHorizontalSpeed();
            setSpeed(delta, sp.getVerticalSpeed()*-1);
        }
    }

    @Override
    public void reactOnCollision(ElementField element) {
        if(_faced == null || !_faced.equals(element)) {
            if(element.mass() == MASS.INF_MASS) {
                collideWithUnmovableElement(element);
            } else {
                collideWithMovableElement(element);
            }
            _faced = element;
        } else {
            _faced = null;
        }
    }
}
