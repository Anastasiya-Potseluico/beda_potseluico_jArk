/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark;

import jArk.physicalObjects.PhysicalGameField;
import jark.model.GameField;

/**
 * Класс буфера обмена между логическими и физическими объектами игры
 * @author Дарья
 */
public class Buffer {
    /** Логическое представление игрового поля */
   private GameField _gameField;
   /** Физическое представление игрового поля*/
   private PhysicalGameField _phGameField;
   
   public Buffer() {
       _gameField = new GameField(this);
       _phGameField = new PhysicalGameField(this);
   }
   
   /** 
    * Получение логического представления поля
    * @return логическое пердставление поля
    */
   public GameField getGameField() {
       return _gameField;
   }
   
   /**
    * Получение физического представления поля
    * @return физическое представление поля
    */
   public PhysicalGameField getGameFieldView() {
       return _phGameField;
   }
}