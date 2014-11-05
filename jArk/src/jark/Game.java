/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark;

import jArk.physicalObjects.GameFieldView;
import jark.model.GameField;

/**
 * Класс игры
 * @author Дарья
 */
public class Game {
    /** Игрок */
    private Player _player;
    /**Игровое поле представление*/
    private GameFieldView _gameFieldView;
    /**Игровое поля логика */
    private GameField _gameField;
    /** 
     * Конструктор
     */
    public Game() {
        _player = new Player();
        _gameFieldView = new GameFieldView(this);
    }
    
    /** 
     * Начать игру
     */
    public void start() {
        
    }
    
    /** 
     * Закончить игру
     */
    public void finish() {
        
    }
    
    /**
     * Возвращает представление игрового поля
     * @return представление игрового поля
     */
    public GameFieldView gameFieldView() {
        return _gameFieldView;
    }
}

