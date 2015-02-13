/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jark.model.BoundaryField.TYPE;
import jark.specifications.Buffer;
import jark.view.GameFieldView;
import java.util.ArrayList;

/**
 * Класс игрового поля
 *
 * @author Дарья
 */
public class GameField {

    /**
     * Физическое представление игрового поля
     */
    private GameFieldView _gameFieldView;
    /**
     * Мячи
     */
    private ArrayList<Ball> _balls = new ArrayList();
    /**
     * Ракетка
     */
    private Racket _racket;
    /**
     * Рои
     */
    private ArrayList<Swarm> _swarms = new ArrayList();
    /**
     * Разрушаемые кирпичи
     */
    private ArrayList<DestructibleBrick> _dBricks = new ArrayList();
    /**
     * Неразрушаемые кирпичи
     */
    private ArrayList<IndestructibleBrick> _iBricks = new ArrayList();
    /**
     * Границы поля
     */
    private ArrayList<BoundaryField> _bondarysField = new ArrayList();

    /**
     * Конструктор
     */
    public GameField() {
        _gameFieldView = new GameFieldView();
        addElementField(new BoundaryField(TYPE.HORISONTAL, 0, 0));
        addElementField(new BoundaryField(TYPE.VERTICAL, 0, 0));
        addElementField(new BoundaryField(TYPE.VERTICAL, 635, 0));
        addElementField(new BoundaryField(TYPE.BOTTOM, 0, 515));
    }

    /**
     * Возвращает физическое представление игрового поля
     *
     * @return физическое представление игрового поля
     */
    public GameFieldView gameFieldView() {
        return _gameFieldView;
    }

    /**
     * Добавить элемент поля
     *
     * @param element добавляемый элемент
     * @return успех добавления
     */
    public boolean addElementField(ElementField element) {
        gameFieldView().addElementFieldView(element);
        if (element instanceof Ball) {
            return _balls.add((Ball) element);
        } else if (element instanceof DestructibleBrick) {
            return _dBricks.add((DestructibleBrick) element);
        } else if (element instanceof BoundaryField) {
            return _bondarysField.add((BoundaryField) element);
        } else if (element instanceof Swarm) {
            return _swarms.add((Swarm) element);
        } else if (element instanceof IndestructibleBrick) {
            return _iBricks.add((IndestructibleBrick) element);
        } else if (element instanceof Racket) {
            if (_racket == null) {
                _racket = (Racket) element;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Удалить элемент поля
     *
     * @param element удаляемый элемент
     * @return Успех удаления
     */
    public boolean deleteElementField(ElementField element) {
        if (element instanceof Ball) {
            return _balls.remove((Ball) element);
        } else if (element instanceof DestructibleBrick) {
            return _dBricks.remove((DestructibleBrick) element);
        } else if (element instanceof BoundaryField) {
            return _bondarysField.remove((BoundaryField) element);
        } else if (element instanceof Swarm) {
            return _swarms.remove((Swarm) element);
        } else if (element instanceof IndestructibleBrick) {
            return _iBricks.remove((IndestructibleBrick) element);
        } else if (element instanceof Racket) {
            _racket = null;
            return true;
        }
        return false;
    }

    /**
     * Возвращает массив мячей
     *
     * @return массив элементов поля - мячи
     */
    public ArrayList<Ball> balls() {
        return _balls;
    }

    /**
     * Возвращает ракетку
     *
     * @return элемент поля - ракетка
     */
    public ElementField racket() {
        return _racket;
    }

    /**
     * Возвращает массив роев
     *
     * @return массив элементов поля - рои
     */
    public ArrayList<Swarm> swarms() {
        return _swarms;
    }

    /**
     * Возвращает массив разрушаемых кирпичей
     *
     * @return массив элементов поля - разрушаемые кирпичи
     */
    public ArrayList<DestructibleBrick> destructibleBricks() {
        return _dBricks;
    }

    /**
     * Возвращает массив неразрушаемых кирпичей
     *
     * @return массив элементов поля - неразрушаемые кирпичи
     */
    public ArrayList<IndestructibleBrick> indestructibleBricks() {
        return _iBricks;
    }

    /**
     * Возвращает границы поля
     *
     * @return возвращает массив элементов поля - границы поля
     */
    public ArrayList<BoundaryField> bondarysField() {
        return _bondarysField;
    }

    /**
     * Очистить игровое поле от кирпичей, мячей, ракетки
     */
    public void clear() {
        for (DestructibleBrick _dBrick : _dBricks) {
            Buffer.deleteElement(_dBrick);
        }
        _dBricks.clear();
        for (IndestructibleBrick _iBrick : _iBricks) {
            Buffer.deleteElement(_iBrick);
        }
        _iBricks.clear();
        for (Ball _ball : _balls) {
            Buffer.deleteElement(_ball);
        }
        _balls.clear();
        Buffer.deleteElement(_racket);
        _racket = null;
    }

    /**
     * Установить элементы на поле согласно уровню
     *
     * @param level Уровень
     */
    public void setField(int level) {
        clear();
        addElementField(new Ball(295, 464));
        addElementField(new Racket(250, 500));
        switch (level) {
            case 0: {
                addElementField(new Ball(295, 200));
                break;
            }
            case 1: {
                addElementField(new DestructibleBrick(1, 5, 5));
                addElementField(new DestructibleBrick(1, 95, 5));
                addElementField(new DestructibleBrick(1, 185, 5));
                addElementField(new DestructibleBrick(1, 275, 5));
                addElementField(new DestructibleBrick(1, 365, 5));
                addElementField(new DestructibleBrick(1, 455, 5));
                addElementField(new DestructibleBrick(1, 545, 5));
                addElementField(new DestructibleBrick(2, 5, 42));
                addElementField(new DestructibleBrick(2, 95, 42));
                addElementField(new DestructibleBrick(2, 185, 42));
                addElementField(new DestructibleBrick(1, 275, 42));
                addElementField(new DestructibleBrick(2, 365, 42));
                addElementField(new DestructibleBrick(1, 455, 42));
                addElementField(new DestructibleBrick(2, 545, 42));
                addElementField(new DestructibleBrick(1, 5, 79));
                addElementField(new DestructibleBrick(1, 95, 79));
                addElementField(new DestructibleBrick(2, 185, 79));
                addElementField(new DestructibleBrick(2, 275, 79));
                addElementField(new DestructibleBrick(2, 365, 79));
                addElementField(new DestructibleBrick(1, 455, 79));
                addElementField(new DestructibleBrick(1, 545, 79));
                addElementField(new DestructibleBrick(1, 5, 116));
                addElementField(new DestructibleBrick(1, 95, 116));
                addElementField(new DestructibleBrick(1, 185, 116));
                addElementField(new DestructibleBrick(2, 275, 116));
                addElementField(new DestructibleBrick(1, 365, 116));
                addElementField(new DestructibleBrick(1, 455, 116));
                addElementField(new DestructibleBrick(1, 545, 116));
                addElementField(new DestructibleBrick(1, 5, 153));
                addElementField(new DestructibleBrick(1, 95, 153));
                addElementField(new DestructibleBrick(2, 185, 153));
                addElementField(new DestructibleBrick(2, 275, 153));
                addElementField(new DestructibleBrick(2, 365, 153));
                addElementField(new DestructibleBrick(1, 455, 153));
                addElementField(new DestructibleBrick(1, 545, 153));
                addElementField(new DestructibleBrick(2, 5, 190));
                addElementField(new DestructibleBrick(1, 95, 190));
                addElementField(new DestructibleBrick(1, 185, 190));
                addElementField(new DestructibleBrick(2, 275, 190));
                addElementField(new DestructibleBrick(1, 365, 190));
                addElementField(new DestructibleBrick(1, 455, 190));
                addElementField(new DestructibleBrick(2, 545, 190));
                addElementField(new DestructibleBrick(1, 5, 227));
                addElementField(new DestructibleBrick(1, 95, 227));
                addElementField(new DestructibleBrick(1, 185, 227));
                addElementField(new DestructibleBrick(1, 275, 227));
                addElementField(new DestructibleBrick(1, 365, 227));
                addElementField(new DestructibleBrick(1, 455, 227));
                addElementField(new DestructibleBrick(1, 545, 227));
                break;
            }
            case 2: {
                addElementField(new DestructibleBrick(3, 5, 5));
                addElementField(new DestructibleBrick(3, 545, 5));
                addElementField(new DestructibleBrick(1, 5, 42));
                addElementField(new DestructibleBrick(2, 95, 42));
                addElementField(new DestructibleBrick(2, 455, 42));
                addElementField(new DestructibleBrick(1, 545, 42));
                addElementField(new DestructibleBrick(1, 5, 79));
                addElementField(new DestructibleBrick(1, 95, 79));
                addElementField(new DestructibleBrick(2, 185, 79));
                addElementField(new DestructibleBrick(2, 365, 79));
                addElementField(new DestructibleBrick(1, 455, 79));
                addElementField(new DestructibleBrick(1, 545, 79));
                addElementField(new DestructibleBrick(1, 5, 116));
                addElementField(new DestructibleBrick(1, 95, 116));
                addElementField(new DestructibleBrick(1, 185, 116));
                addElementField(new DestructibleBrick(1, 365, 116));
                addElementField(new DestructibleBrick(1, 455, 116));
                addElementField(new DestructibleBrick(1, 545, 116));
                addElementField(new DestructibleBrick(1, 5, 153));
                addElementField(new DestructibleBrick(1, 95, 153));
                addElementField(new DestructibleBrick(2, 185, 153));
                addElementField(new DestructibleBrick(2, 365, 153));
                addElementField(new DestructibleBrick(1, 455, 153));
                addElementField(new DestructibleBrick(1, 545, 153));
                addElementField(new DestructibleBrick(1, 5, 190));
                addElementField(new DestructibleBrick(2, 95, 190));
                addElementField(new DestructibleBrick(2, 455, 190));
                addElementField(new DestructibleBrick(1, 545, 190));
                addElementField(new DestructibleBrick(3, 5, 227));
                addElementField(new DestructibleBrick(3, 545, 227));
                addElementField(new IndestructibleBrick(275, 116));
                break;
            }
            case 3: {
                addElementField(new DestructibleBrick(3, 275, 5));
                addElementField(new DestructibleBrick(2, 185, 42));
                addElementField(new DestructibleBrick(3, 275, 42));
                addElementField(new DestructibleBrick(2, 365, 42));
                addElementField(new DestructibleBrick(1, 95, 79));
                addElementField(new DestructibleBrick(1, 185, 79));
                addElementField(new DestructibleBrick(1, 365, 79));
                addElementField(new DestructibleBrick(1, 455, 79));
                addElementField(new DestructibleBrick(1, 5, 116));
                addElementField(new DestructibleBrick(1, 95, 116));
                addElementField(new DestructibleBrick(1, 185, 116));
                addElementField(new DestructibleBrick(1, 365, 116));
                addElementField(new DestructibleBrick(1, 455, 116));
                addElementField(new DestructibleBrick(1, 545, 116));
                addElementField(new DestructibleBrick(2, 5, 190));
                addElementField(new DestructibleBrick(1, 95, 190));
                addElementField(new DestructibleBrick(1, 185, 190));
                addElementField(new DestructibleBrick(2, 275, 190));
                addElementField(new DestructibleBrick(1, 365, 190));
                addElementField(new DestructibleBrick(1, 455, 190));
                addElementField(new DestructibleBrick(2, 545, 190));
                addElementField(new DestructibleBrick(1, 95, 227));
                addElementField(new DestructibleBrick(2, 185, 227));
                addElementField(new DestructibleBrick(1, 275, 227));
                addElementField(new DestructibleBrick(2, 365, 227));
                addElementField(new DestructibleBrick(1, 455, 227));
                addElementField(new IndestructibleBrick(275, 79));
                addElementField(new IndestructibleBrick(275, 116));
                addElementField(new IndestructibleBrick(275, 153));
                break;
            }
            case 4: {
                addElementField(new DestructibleBrick(1, 5, 5));
                addElementField(new DestructibleBrick(1, 275, 5));
                addElementField(new DestructibleBrick(1, 545, 5));
                addElementField(new DestructibleBrick(2, 95, 42));
                addElementField(new DestructibleBrick(1, 275, 42));
                addElementField(new DestructibleBrick(2, 455, 42));
                addElementField(new DestructibleBrick(1, 185, 79));
                addElementField(new DestructibleBrick(1, 365, 79));
                addElementField(new DestructibleBrick(1, 5, 116));
                addElementField(new DestructibleBrick(1, 95, 116));
                addElementField(new DestructibleBrick(1, 455, 116));
                addElementField(new DestructibleBrick(1, 545, 116));
                addElementField(new DestructibleBrick(1, 185, 153));
                addElementField(new DestructibleBrick(1, 365, 153));
                addElementField(new DestructibleBrick(3, 95, 190));
                addElementField(new DestructibleBrick(1, 275, 190));
                addElementField(new DestructibleBrick(3, 455, 190));
                addElementField(new DestructibleBrick(1, 5, 227));
                addElementField(new DestructibleBrick(1, 275, 227));
                addElementField(new DestructibleBrick(1, 545, 227));
                addElementField(new IndestructibleBrick(275, 79));
                addElementField(new IndestructibleBrick(185, 116));
                addElementField(new IndestructibleBrick(275, 116));
                addElementField(new IndestructibleBrick(365, 116));
                addElementField(new IndestructibleBrick(275, 153));
                break;
            }
            case 5: {
                addElementField(new DestructibleBrick(1, 5, 5));
                addElementField(new DestructibleBrick(1, 95, 5));
                addElementField(new DestructibleBrick(1, 185, 5));
                addElementField(new DestructibleBrick(1, 275, 5));
                addElementField(new DestructibleBrick(1, 365, 5));
                addElementField(new DestructibleBrick(1, 455, 5));
                addElementField(new DestructibleBrick(1, 545, 5));
                addElementField(new DestructibleBrick(2, 185, 42));
                addElementField(new DestructibleBrick(2, 275, 42));
                addElementField(new DestructibleBrick(2, 365, 42));
                addElementField(new DestructibleBrick(3, 275, 79));
                addElementField(new DestructibleBrick(1, 5, 116));
                addElementField(new DestructibleBrick(1, 95, 116));
                addElementField(new DestructibleBrick(3, 455, 116));
                addElementField(new DestructibleBrick(3, 545, 116));
                addElementField(new DestructibleBrick(2, 5, 153));
                addElementField(new DestructibleBrick(2, 95, 153));
                addElementField(new DestructibleBrick(2, 455, 153));
                addElementField(new DestructibleBrick(2, 545, 153));
                addElementField(new DestructibleBrick(3, 5, 190));
                addElementField(new DestructibleBrick(3, 95, 190));
                addElementField(new DestructibleBrick(1, 455, 190));
                addElementField(new DestructibleBrick(1, 545, 190));
                addElementField(new IndestructibleBrick(185, 116));
                addElementField(new IndestructibleBrick(185, 153));
                addElementField(new IndestructibleBrick(185, 190));
                addElementField(new IndestructibleBrick(5, 227));
                addElementField(new IndestructibleBrick(95, 227));
                addElementField(new IndestructibleBrick(185, 227));
                addElementField(new IndestructibleBrick(455, 227));
                addElementField(new IndestructibleBrick(545, 227));
                break;
            }
        }
        
    }

}
