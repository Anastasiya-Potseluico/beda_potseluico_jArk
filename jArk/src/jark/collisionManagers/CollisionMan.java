/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.collisionManagers;

import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.Sprite;
import jark.model.Ball;
import jark.model.ElementField;
import jark.specifications.Buffer;

/**
 * Класс обработчика коллизий
 *
 * @author пользователь
 */
public class CollisionMan {

    /**
     * Коллизия ракетки с границами поля
     */
    private Collision _collisionRacketBoundaries = new Collision(this);
    /**
     * Менеджер коллизии ракетки с границами поля
     */
    private CollisionManager _collisionManagerRacketBoundaries = _collisionRacketBoundaries;
    /**
     * Коллизия мяча с преградами
     */
    private Collision _collisionBallsBarrier = new Collision(this);
    /**
     * Менеджер коллизии мяча с преградами
     */
    private CollisionManager _collisionManagerBallsBarrier = _collisionBallsBarrier;
    /**
     * Коллизия мяча с мячами
     */
    private Collision _collisionBallsBalls = new Collision(this);
    /**
     * Менеджер коллизии мяча с мячами
     */
    private CollisionManager _collisionManagerBallsBalls = _collisionBallsBalls;

    /**
     * Тип коллизии
     */
    public enum TYPE {

        DEFAULT, PAIR
    };

    /**
     * Проверить коллизии
     */
    public void checkCollision() {
        _collisionManagerRacketBoundaries.checkCollision();
        _collisionManagerBallsBarrier.checkCollision();
        _collisionManagerBallsBalls.checkCollision();
    }

    /**
     * Возвращает коллизию ракетки с границами поля
     *
     * @return коллизия ракетки с границами поля
     */
    public Collision collisionRacketBoundaries() {
        return _collisionRacketBoundaries;
    }

    /**
     * Возвращает коллизию мяча с преградами
     *
     * @return коллизия мяча с преградами
     */
    public Collision collisionBallsBarrier() {
        return _collisionBallsBarrier;
    }

    /**
     * Возвращает коллизию мяча с мячами
     *
     * @return коллизия мяча с мячами
     */
    public Collision collisionBallsBalls() {
        return _collisionBallsBalls;
    }
    /**
     * Количество обработанных коллизий
     */
    private int _countReact = 0;

    private Sprite oldSprite1;
    private Sprite oldSprite2;

    /**
     * Метод для обработки коллизии
     *
     * @param sprite1 Спрайт, который столкнулся
     * @param sprite2 Спрайт, с которым столкнулись
     * @param countFaced Количество элементов, скоторым столкнулся sprite1
     */
    public void manageCollision(Sprite sprite1, Sprite sprite2, int countFaced) {
        if (oldSprite1 == null || (oldSprite1 != sprite2 || oldSprite2 != sprite1)) {
            ElementField first, second;
            first = Buffer.findElement(sprite1);
            second = Buffer.findElement(sprite2);
            TYPE type;
            if (countFaced > 1) {
                type = TYPE.PAIR;
            } else {
                type = TYPE.DEFAULT;
            }
            ElementField firstcopy = first.copy();
            if (_countReact == 0) {
                first.reactOnCollision(second, type);
            }
            second.reactOnCollision(firstcopy, type);
            Buffer.deleteElement(firstcopy);
            _countReact++;
            if (_countReact == countFaced) {
                _countReact = 0;
            }
        }
        oldSprite1 = sprite1;
        oldSprite2 = sprite2;
    }

}
