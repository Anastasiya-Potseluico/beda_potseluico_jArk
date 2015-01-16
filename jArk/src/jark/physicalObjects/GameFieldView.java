/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

import com.golden.gamedev.object.PlayField;
import jark.JarkGame;
import jark.events.DestructionListener;
import jark.model.Ball;
import jark.model.BoundaryField;
import jark.model.ElementField;
import jark.model.GameField;
import jark.model.Racket;
import java.util.ArrayList;

/**
 * Класс физического представления игрового поля
 * @author пользователь
 */
public class GameFieldView extends PlayField{

    /** Массив мячей, содержащихся на поле*/
    private ArrayList <BallView> _ballsView = new ArrayList();
    /** Массив мячей, содержащихся на поле*/
    private ArrayList <BoundaryView> _boundariesView = new ArrayList();
    /** Ракетка */
    private RacketView _racketView;
    /** Логическое представление игрового поля */
    private GameField _gameField;
    
    /**
     * Конструктор 
     * @param gameField
     */
    public GameFieldView(GameField gameField) {
        _gameField = gameField;
        
    }
    
    public ArrayList<BallView> ballsView() {
        return _ballsView;
    }
    
    public ArrayList<BoundaryView> boundariesView() {
        return _boundariesView;
    }
    
    public RacketView racketView() {
        return _racketView;
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
        //TODO
        return null;
    }
    
    /**
     * Возвращает логическое представление игрового поля
     * @return логическое представление игрового поля
     */
    public GameField gameField () {
        return _gameField;
    }
    
    public void setStartPosition(int level) {
        switch (level) {
            case 1: {
                _ballsView.add(new BallView((Ball) this._gameField.balls().get(0),295, 464));
                break;
            } case 2: { 
                _ballsView.add(new BallView((Ball) this._gameField.balls().get(0),295, 464));
                _ballsView.add(new BallView((Ball) this._gameField.balls().get(1),295, 265));
                break;
            } case 3: {   
                break;
            } 
        }
        _racketView = new RacketView((Racket) this._gameField.racket(),251, 500);
        _boundariesView.add(new BoundaryView((BoundaryField) this._gameField.bondarysField().get(0), 0, 0));
        _boundariesView.add(new BoundaryView((BoundaryField) this._gameField.bondarysField().get(1), 0, 0));
        _boundariesView.add(new BoundaryView((BoundaryField) this._gameField.bondarysField().get(2), 635, 0));
        
    }
    
    public class removeSprite implements DestructionListener {
        /*@Override
        public void brickHitted(DestructionEvent e, DestructibleBrick dBrick) {
            boolean found = false;
            int i=0;
            if(dBrick.hadrness()==0) {
                while(!found) {
                    if(_dBricksView.get(i)._elementField == dBrick) {
                        found = true;
                        _game.removeBrickSprite(_dBricksView.get(i).sprite());
                        _dBricksView.remove(i);
                    }
                    i++;
                }
            }
            _game.addScores();
        } */
    }
}
