/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jark.collisionManagers.CollisionMan;
import jark.specifications.Buffer;

/**
 * Логическое представление элемента поля
 *
 * @author Дарья
 */
enum MASS {

    FIN_MASS, INF_MASS, OTHER
};

public abstract class ElementField {

    /**
     * Элемент, с которым было последнее столкновение
     */
    protected ElementField _faced;
    /**
     * Масса элемента
     */
    protected MASS _mass;
    /**
     * Координата по оси Х
     */
    int _x;
    /**
     * Координата по оси У
     */
    int _y;

    /**
     * Конструктор элемента поля
     *
     * @param mass вес элемента (постоянен)
     * @param x Координата по оси Х
     * @param y Координата по оси У
     */
    public ElementField(MASS mass, int x, int y) {
        this._mass = mass;
        _x = x;
        _y = y;
        _faced = null;
    }

    /**
     * Функция реагирования на столкновение
     *
     * @param element Элемент,с которым произошло столкновение
     * @param type Тип столкновения
     */
    public abstract void reactOnCollision(ElementField element, CollisionMan.TYPE type);

    /**
     * Функция для получения веса элемента
     *
     * @return вес элемента
     */
    public MASS mass() {
        return this._mass;
    }

    /**
     * Возвращает координату по оси Х
     *
     * @return Координата по оси Х
     */
    public int x() {
        return _x;
    }

    /**
     * Возвращает координату по оси У
     *
     * @return Координата по оси У
     */
    public int y() {
        return _y;
    }

    /**
     * Установить скорость
     *
     * @param vX Горизонтальная скорость
     * @param vY Вертикальная скорость
     * @return Успех
     */
    public boolean setSpeed(double vX, double vY) {
        if (Buffer.findSprite(this) != null) {
            Buffer.findSprite(this).setSpeed(vX, vY);
            return true;
        } else {
            return false;
        }
    }
}
