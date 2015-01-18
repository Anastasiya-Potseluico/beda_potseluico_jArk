/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.view;

import com.golden.gamedev.object.PlayField;
import jark.model.Ball;
import jark.model.BoundaryField;
import jark.model.DestructibleBrick;
import jark.model.ElementField;
import jark.model.IndestructibleBrick;
import jark.model.Racket;
import jark.specifications.Buffer;
import java.util.ArrayList;

/**
 * Класс физического представления игрового поля
 *
 * @author пользователь
 */
public class GameFieldView extends PlayField {

    /**
     * Массив разрушаемых кирпичей, содержащихся на поле
     */
    private ArrayList<DestructibleBrickView> _dBricksView = new ArrayList();
    /**
     * Массив неразрушаемых кирпичей, содержащихся на поле
     */
    private ArrayList<IndestructibleBrickView> _iBricksView = new ArrayList();
    /**
     * Массив мячей, содержащихся на поле
     */
    private ArrayList<BallView> _ballsView = new ArrayList();
    /**
     * Массив границ поля, содержащихся на поле
     */
    private ArrayList<BoundaryView> _boundariesView = new ArrayList();
    /**
     * Ракетка
     */
    private RacketView _racketView;

    /**
     * Конструктор
     */
    public GameFieldView() {

    }

    /**
     * Возвращает массив разрушаемых кирпичей
     *
     * @return массив разрушаемых кирпичей
     */
    public ArrayList<DestructibleBrickView> dBricksView() {
        return _dBricksView;
    }

    /**
     * Возвращает массив неразрушаемых кирпичей
     *
     * @return массив неразрушаемых кирпичей
     */
    public ArrayList<IndestructibleBrickView> iBricksView() {
        return _iBricksView;
    }

    /**
     * Возвращает массив мячей
     *
     * @return массив мячей
     */
    public ArrayList<BallView> ballsView() {
        return _ballsView;
    }

    /**
     * Возвращает массив границ поля
     *
     * @return массив границ поля
     */
    public ArrayList<BoundaryView> boundariesView() {
        return _boundariesView;
    }

    /**
     * Возвращает ракетку
     *
     * @return ракетка
     */
    public RacketView racketView() {
        return _racketView;
    }

    /**
     * Обновление спрайта
     *
     * @param l период обновления
     */
    public void updateElements(long l) {

        this.update(l);
    }

    /**
     * Добавить элемент поля на поле
     *
     * @param el элемент поля
     * @return успех добавления
     */
    public boolean addElementFieldView(ElementField el) {
        ElementFieldView element = null;
        if (el instanceof Ball) {
            element = new BallView(el.x(), el.y());
            _ballsView.add((BallView) element);
        } else if (el instanceof BoundaryField) {
            element = new BoundaryView(((BoundaryField) el).type(), el.x(), el.y());
            _boundariesView.add((BoundaryView) element);
        } else if (el instanceof Racket) {
            _racketView = new RacketView(el.x(), el.y());
            element = _racketView;
        } else if (el instanceof DestructibleBrick) {
            element = new DestructibleBrickView(((DestructibleBrick) el).hadrness(), el.x(), el.y());
            _dBricksView.add((DestructibleBrickView) element);
        } else if (el instanceof IndestructibleBrick) {
            element = new IndestructibleBrickView(el.x(), el.y());
            _iBricksView.add((IndestructibleBrickView) element);
        }
        if (element != null && element.sprite() != null) {
            Buffer.addElement(el, element.sprite());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Удалить элемент поля с поля
     *
     * @param element элемент поля
     * @return успех удаления
     */
    public boolean deleteElementFieldView(ElementFieldView element) {
        if (element instanceof BallView) {
            return _ballsView.remove((BallView) element);
        } else if (element instanceof BoundaryView) {
            return _boundariesView.remove((BoundaryView) element);
        } else if (element instanceof RacketView) {
            _racketView = null;
            return true;
        } else if (element instanceof DestructibleBrickView) {
            return _dBricksView.remove((DestructibleBrickView) element);
        } else if (element instanceof IndestructibleBrickView) {
            return _iBricksView.remove((IndestructibleBrickView) element);
        }
        return false;
    }
}
