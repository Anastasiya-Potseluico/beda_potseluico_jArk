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
    /** */
    private GameView _gameView;
    
    public GameModel() {
        _player = new Player();
        _gameField = new GameField();
        _gameView = new GameView(_gameField.gameFieldView());
        _gameField.setField(_level);
    }
    
    public GameView gameView() {
        return _gameView;
    }
    
    public void startGame() {
        
    }
    
    public Player player() {
        return _player;
    }
    
    public int level() {
        return _level;
    }
    
    public GameField gameField () {
        return _gameField;
    }
}
