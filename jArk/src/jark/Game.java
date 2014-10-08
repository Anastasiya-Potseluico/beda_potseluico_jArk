/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark;

/**
 * Класс игры
 * @author Дарья
 */
public class Game {
    /** Игрок */
    private Player _player;
    
    /** Буфер обмена между логическими и физическими объектами игры */
    private Buffer _buffer;
    
    /** 
     * Конструктор
     */
    public Game() {
        _player = new Player();
        _buffer = new Buffer();
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

