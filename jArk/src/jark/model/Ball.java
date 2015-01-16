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
    public enum AXIS {X, Y}; //Оси, относительно которых мяч будет отскакивать
    /**
     * Конструктор
     */
    public Ball(int x, int y) {
        super(MASS.FIN_MASS, x, y);
    }
    
    //!!!!!!!!!!!!!!!!
    //TODO Даш, тут проблема возникает. У модели нет ни координат, ни скорости. 
    // возможно, методы отскоков нужно перенести в представление, я не знаю, как лучше
    /**
     * Отскочить от элемента поля
     * @param element элемент поля, от которого отскакивает мяч
     * @return результат отскока
     */
    private boolean rebound(ElementField element, AXIS axis) {
        
        return true;
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
     * @param _element Элемент,с которым произошло столкновение
     */
    @Override
    public void collideWithUnmovableElement(ElementField element) {
        Sprite sp = Buffer.findSprite(this);
        if(element instanceof BoundaryField) {
            if(((BoundaryField)element).type() == TYPE.HORISONTAL) 
              setSpeed(sp.getHorizontalSpeed(), sp.getVerticalSpeed()*-1); 
            else
                setSpeed(sp.getHorizontalSpeed()*-1, sp.getVerticalSpeed());
        }
        
        //rebound(_element);
    }

    @Override
    public void reactOnCollision(ElementField element) {
        if(element.mass() == MASS.INF_MASS) {
            collideWithUnmovableElement(element);
        } else {
            collideWithMovableElement(element);
        }
    }
}
