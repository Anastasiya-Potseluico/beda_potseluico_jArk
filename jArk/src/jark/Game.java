/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark;

import jArk.physicalObjects.PhysicalGameField;

/**
 * Класс игры
 * @author Дарья
 */
public class Game {
    /** Игрок */
    private Player _player;
    /**Игровое поле */
    private PhysicalGameField _physicalGameField;
    
    /** 
     * Конструктор
     */
    public Game() {
        _player = new Player();
        _physicalGameField = new PhysicalGameField();
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
    
    
}

