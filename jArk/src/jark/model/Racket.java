/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import com.golden.gamedev.object.Sprite;
import jark.collisionManagers.CollisionMan;
import jark.specifications.Buffer;

/**
 * Класс ракетки
 *
 * @author Дарья
 */
public class Racket extends ElementField {

    /**
     * Конструктор ракетки
     *
     * @param x координата по оси Х
     * @param y координата по оси У
     */
    public Racket(int x, int y) {
        super(MASS.INF_MASS, x, y);
    }

    /**
     * Установить скорость
     *
     * @param vX Горизонтальная скорость
     * @param vY Вертикальная скорость
     * @return Успех
     */
    @Override
    public boolean setSpeed(double vX, double vY) {
        if (Buffer.findSprite(this).getX() <= 10) {
            return super.setSpeed(Math.abs(vX)* 0.1, vY);
        } else if (Buffer.findSprite(this).getX() >= 492) {
            return super.setSpeed(Math.abs(vX) * -0.1, vY);
        } else {
            return super.setSpeed(vX, vY);
        }
    }

    /**
     * Функция реагирования на столкновение
     *
     * @param element Элемент,с которым произошло столкновение
     * @param type Тип столкновения
     */
    @Override
    public void reactOnCollision(ElementField element, CollisionMan.TYPE type) {
        if (element instanceof BoundaryField) {
            setSpeed(Buffer.findSprite(this).getHorizontalSpeed() * -1, 0);
        }
    }

    @Override
    public ElementField copy() {
        Racket racket = new Racket(_x, _y);
        Sprite sp = new Sprite(_x, _y);
        sp.setSpeed(Buffer.findSprite(this).getHorizontalSpeed(),
                Buffer.findSprite(this).getVerticalSpeed());
        Buffer.addElement(racket, sp);
        return racket;
    }
}
