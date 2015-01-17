/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jark.Player;
import jark.view.GameView;

/**
 *
 * @author Дарья
 */
public class GameModel {
    /** Игрок */
    private Player _player;
    /**Игровое поля логика */
    private GameField _gameField;
    /** Уровень (1-3) */
    private int _level = 1;
    
    private boolean _isBallStart = true;
    /** */
    private GameView _gameView;
    
    public GameModel() {
        _player = new Player();
        _gameField = new GameField();
        _gameView = new GameView(_gameField.gameFieldView());
        
    }
    
    public GameView gameView() {
        return _gameView;
    }
    
    public void startGame() {
        _isBallStart = true;
        _gameField.setField(_level);
    }
    
    public Player player() {
        return _player;
    }
    
    public int level() {
        return _level;
    }
    
    public boolean isBallStart () {
        return _isBallStart;
    }
    
    public GameField gameField () {
        return _gameField;
    }
    
    public void startBall() {
        _isBallStart = false;
        _gameField.balls().get(0).setSpeed(0, -0.4);
    }
}
