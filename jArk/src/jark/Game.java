/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark;

import jark.model.GameField;

/**
 * Класс игры
 * @author Дарья
 */
public class Game {
    /** Игрок */
    private Player _player;
    /**Игровое поле */
    private GameField _gameField;
    
    /** 
     * Конструктор
     */
    public Game() {
        _player = new Player();
        _gameField = new GameField();
    }
    
    /** 
     * Начать игру
     */
    public void startGame() {
        
    }
    
    /** 
     * Закончить игру
     */
    public void endGame() {
        
    }
    
    
}

