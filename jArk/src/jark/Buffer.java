/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark;

import jark.model.GameField;

/**
 * Класс буфера обмена между логическими и физическими объектами игры
 * @author Дарья
 */
public class Buffer {
    /** Логическое представление игрового поля */
   private GameField _gameField;
   /** Физическое представление игрового поля*/
   
   public Buffer() {
       _gameField = new GameField(this);
   }
   
   public GameField getGameField() {
       return _gameField;
   }
   
   //TODO
   public void getGameFieldView() {
       
   }
}