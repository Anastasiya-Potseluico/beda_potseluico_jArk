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
 * Класс границы поля
 *
 * @author Дарья
 */
public class BoundaryField extends ElementField {

    /**
     * Перечисление типов границ
     */
    public enum TYPE {

        HORISONTAL, VERTICAL, BOTTOM
    };

    /**
     * Тип границы
     */
    private TYPE _type;

    /**
     * Конструктор границ
     *
     * @param type тип границы
     * @param x координата х границы на поле
     * @param y координата у границы на поле
     */
    public BoundaryField(TYPE type, int x, int y) {
        super(MASS.INF_MASS, x, y);
        _type = type;
    }

    /**
     * Метод реакции границы на коллизию (в дальнейшем возможно добавление
     * реакции)
     *
     * @param element элемент, с которым столкнулся кирпич
     * @param type тип коллизии
     */
    @Override
    public void reactOnCollision(ElementField element, CollisionMan.TYPE type) {

    }

    /**
     * Метод для получения типа границы
     *
     * @return тип границы
     */
    public TYPE type() {
        return _type;
    }

    @Override
    public ElementField copy() {
        BoundaryField bf = new BoundaryField(_type, _x, _y);
        Sprite sp = new Sprite(_x, _y);
        sp.setSpeed(Buffer.findSprite(this).getHorizontalSpeed(),
                Buffer.findSprite(this).getVerticalSpeed());
        Buffer.addElement(bf, sp);
        return bf;
    }
}
