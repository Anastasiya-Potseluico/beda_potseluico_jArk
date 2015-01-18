/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

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
        if (Buffer.findSprite(this).getX() <= 5) {
            return super.setSpeed(Math.abs(vX), vY);
        } else if (Buffer.findSprite(this).getX() >= 497) {
            return super.setSpeed(Math.abs(vX) * -1, vY);
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
}
