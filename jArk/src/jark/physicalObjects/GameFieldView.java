/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

import jark.Game;
import jark.model.GameField;
import java.util.ArrayList;

/**
 * Класс физического представления игрового поля
 * @author пользователь
 */
public class GameFieldView {
    
    /** Массив элементов, содержащихся на поле*/
    private ArrayList <ElementFieldView> _elements;
    /** Логическое представление игрового поля */
    private GameField _gameField;
    /** Игра */
    private Game _game;
    
    /**
     * Конструктор
     * @param gameField 
     */
    public GameFieldView (Game game) {
        _game= game;
    }

    /**
     * Добавить элемент поля на поле
     * @param element элемент поля
     * @return успех добавления
     */
    public boolean addElementFieldView (ElementFieldView element) {
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
     * Установить логическое представление игрового поля
     * @param gameField игровое поле 
     */
    public void setGameField (GameField gameField) {
        _gameField = gameField;
    }
    
    /**
     * Возвращает логическое представление игрового поля
     * @return логическое представление игрового поля
     */
    public GameField gameField () {
        return _gameField;
    }
}
