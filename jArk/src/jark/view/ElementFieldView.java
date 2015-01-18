/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.view;

import com.golden.gamedev.object.Sprite;
import java.awt.Graphics2D;

/**
 * Класс физического представления элемента поля
 *
 * @author пользователь
 */
public abstract class ElementFieldView {

    /**
     * Спрайт элемента
     */
    protected Sprite _elementSprite;

    /**
     * Метод обновления спрайта
     *
     * @param elapsedTime период обновления
     */
    public void update(int elapsedTime) {
        _elementSprite.update(elapsedTime);
    }

    /**
     * Метод для перерисовки спрайта
     *
     * @param g
     */
    public void render(Graphics2D g) {
        _elementSprite.render(g);
    }

    /**
     * Установить скорость спрайта
     *
     * @param vX горизонтальная скорость
     * @param vY вертикальная скорость
     */
    public void setSpeed(double vX, double vY) {
        _elementSprite.setSpeed(vX, vY);
    }

    /**
     * Возвращает спрайт элемента
     *
     * @return спрайт
     */
    public Sprite sprite() {
        return this._elementSprite;
    }
}
