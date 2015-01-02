/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

import com.golden.gamedev.object.PlayField;
import jark.JarkGame;
import jark.model.Ball;
import jark.model.BoundaryField;
import jark.model.DestructibleBrick;
import jark.model.ElementField;
import jark.model.GameField;
import jark.model.IndestructibleBrick;
import java.util.ArrayList;

/**
 * Класс физического представления игрового поля
 * @author пользователь
 */
public class GameFieldView extends PlayField{
    
    /** Массив элементов, содержащихся на поле*/
    private ArrayList <ElementFieldView> _elements = new ArrayList();
    /** Логическое представление игрового поля */
    private GameField _gameField;
    /** Игра */
    private JarkGame _game;
    
    /**
     * Конструктор
     * @param gameField 
     * @param i номер уровня
     */
    public GameFieldView(JarkGame game, int i) {
        _game= game;
        _gameField = new GameField();
        _gameField.setField(i);
    }
    
    public void updateElements(long l) {
        this.update(l);
        
    }

    /**
     * Добавить элемент поля на поле
     * @param element элемент поля
     * @return успех добавления
     */
    public boolean addElementFieldView (ElementField element) {
        //TODO
        
        return true;
    }
    
    /**
     * Удалить элемент поля с поля
     * @param element элемент поля
     * @return успех удаления
     */
    public boolean deleteElementFieldView (ElementFieldView element) {
        //TODO
        return true;
    }
    
    /**
     * Возвращает массив элементов поля
     * @return элементы поля
     */
    public ArrayList <ElementFieldView> elements()
    {
        return _elements;
    }
    
    /**
     * Возвращает логическое представление игрового поля
     * @return логическое представление игрового поля
     */
    public GameField gameField () {
        return _gameField;
    }
    
    public void setStartPosition() {
        int i;
        for (i = 0; i < this._gameField.balls().size(); i++) {
            _elements.add(new BallView((Ball) this._gameField.balls().get(i),10, 20*i+40));
        }
        _elements.add(new BoundaryView((BoundaryField) this._gameField.bondarysField().get(0),0, 0));
        _elements.add(new BoundaryView((BoundaryField) this._gameField.bondarysField().get(1),0,0));
        _elements.add(new BoundaryView((BoundaryField) this._gameField.bondarysField().get(2),635, 0));
        for(i = 0; i < this._gameField.destructibleBricks().size(); i++) {
            _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),20*i, 10*i));
        }
        for(i = 0; i < this._gameField.indestructibleBricks().size(); i++) {
            _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(i),140+i, 140+i));
        }
    }
}
