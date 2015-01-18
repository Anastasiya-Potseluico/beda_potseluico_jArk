/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark;

/**
 * Класс игрока
 *
 * @author Дарья
 */
public class Player {

    /**
     * Количество жизней
     */
    private int _number_of_lives;
    /**
     * Количество очков
     */
    private int _scores;

    /**
     * Конструктор
     */
    public Player() {
        _number_of_lives = 3;
        _scores = 0;
    }

    /**
     * Возвращает количество жизней
     *
     * @return количество жизней
     */
    public int numberOfLives() {
        return _number_of_lives;
    }

    /**
     * Уменьшает количество жизней
     */
    public void reduceNumberOfLives() {
        _number_of_lives--;
    }

    /**
     * Возвращает количество очков
     *
     * @return количество очков
     */
    public int scores() {
        return _scores;
    }

    /**
     * Увеличивает количество очков на указанную сумму
     *
     * @param toScores сумма очков
     */
    public void sumScore(int toScores) {
        _scores += toScores;
    }
}
