/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark;

/**
 * Класс игрока
 * @author Дарья
 */
public class Player {
    /** Количество жизней */
    private int _number_of_lives;
    
    private int _scores;
    /**
     * Устанавливает количество жизней
     * @param number количество жизней
     */
    public void setNumberOfLives(int number) {
        _number_of_lives = number;
    }
    /**
     * Возвращает количество жизней
     * @return количество жизней
     */
    public int numberOfLives()
    {
        return _number_of_lives;
    }
}
