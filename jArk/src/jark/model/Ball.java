/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import com.golden.gamedev.object.Sprite;
import jark.collisionManagers.CollisionMan;
import jark.events.GameOverListener;
import jark.model.BoundaryField.TYPE;
import jark.specifications.Buffer;
import java.util.ArrayList;

/**
 * Класс мяча
 *
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
     *
     * @param _element Элемент,с которым произошло столкновение
     */
    @Override
    public void collideWithMovableElement(ElementField _element, CollisionMan.TYPE type) {

    }

    /**
     * Функция обработки столкновения с неподвижным объектом
     *
     * @param element Элемент,с которым произошло столкновение
     * @param type
     */
    @Override
    public void collideWithUnmovableElement(ElementField element, CollisionMan.TYPE type) {
        Sprite sp = Buffer.findSprite(this);
        Sprite el = Buffer.findSprite(element);
        if (type == CollisionMan.TYPE.PAIR) {
            setSpeed(sp.getHorizontalSpeed() * -1, sp.getVerticalSpeed() * -1);
        } else {
            if (element instanceof BoundaryField) {
                if (((BoundaryField) element).type() == TYPE.HORISONTAL) {
                    setSpeed(sp.getHorizontalSpeed(), sp.getVerticalSpeed() * -1);
                } else if (((BoundaryField) element).type() == TYPE.VERTICAL) {
                    setSpeed(sp.getHorizontalSpeed() * -1, sp.getVerticalSpeed());
                } else {
                    for (GameOverListener _listener : _listeners) {
                        _listener.gameOver();
                    }
                }
            } else {
                //мяч летит под прямым углом
                if (sp.getHorizontalSpeed() == 0) {
                    //элемент в движении, значит угол полета мяча изменится
                    if (el.getHorizontalSpeed() > 0) {
                        setSpeed(0.2, sp.getVerticalSpeed() * -1);
                    } else if (el.getHorizontalSpeed() < 0) {
                        setSpeed(-0.2, sp.getVerticalSpeed() * -1);
                    } 
                    //элемент не движется
                    else {
                        setSpeed(0, sp.getVerticalSpeed() * -1);
                    }
                } 
                // мяч летит под углом
                else {
                    //мяч летит на верхнюю или нижнюю поверхность элемента
                    if((sp.getX()+sp.getWidth()/2) > el.getX() &&
                            (sp.getX()+sp.getWidth()/2) < el.getX() + el.getWidth()) {
                        setSpeed(sp.getHorizontalSpeed(), sp.getVerticalSpeed() * -1);
                    } 
                    //мяч летит на боковые поверхности элемента
                    else {
                        setSpeed(sp.getHorizontalSpeed() * -1, sp.getVerticalSpeed());
                    }
                }
            }
        }
    }

    @Override
    public void reactOnCollision(ElementField element, CollisionMan.TYPE type) {
        if (_faced == null || !_faced.equals(element)) {
            if (element.mass() == MASS.INF_MASS) {
                collideWithUnmovableElement(element, type);
            } else {
                collideWithMovableElement(element, type);
            }
            _faced = element;
        }
    }
    private ArrayList<GameOverListener> _listeners = new ArrayList();

    /**
     * Метод для добавления слушателя кирпича
     *
     * @param listener слушатель змейки
     */
    public void addBallListener(GameOverListener listener) {
        _listeners.add(listener);
    }

    /**
     * Метод для получения слушателей кирпича
     *
     * @return список слушателей змейки
     */
    public ArrayList listeners() {
        return this._listeners;
    }
}
