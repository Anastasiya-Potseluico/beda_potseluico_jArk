/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

import com.golden.gamedev.object.PlayField;
import jark.JarkGame;
import jark.model.Ball;
import jark.model.BoundaryField;
import jark.model.DestructibleBrick;
import jark.model.ElementField;
import jark.model.GameField;
import jark.model.IndestructibleBrick;
import jark.model.Racket;
import java.util.ArrayList;

/**
 * Класс физического представления игрового поля
 * @author пользователь
 */
public class GameFieldView extends PlayField{
    
    /** Массив элементов, содержащихся на поле*/
    private ArrayList <ElementFieldView> _elements = new ArrayList();
    /** Логическое представление игрового поля */
    private GameField _gameField;
    /** Игра */
    private JarkGame _game;
    
    /**
     * Конструктор
     * @param gameField 
     * @param i номер уровня
     */
    public GameFieldView(JarkGame game, int i) {
        _game= game;
        _gameField = new GameField();
        _gameField.setField(i);
    }
    
    public void updateElements(long l) {
        this.update(l);
        
    }

    /**
     * Добавить элемент поля на поле
     * @param element элемент поля
     * @return успех добавления
     */
    public boolean addElementFieldView (ElementField element) {
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
     * Возвращает логическое представление игрового поля
     * @return логическое представление игрового поля
     */
    public GameField gameField () {
        return _gameField;
    }
    
    public void setStartPosition(int level) {
        int i;
        switch (level) {
            case 1: {
               
                for(i = 0; i < 7; i++) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+i*90, 5));
                }
                
                int k = 0;
                for(i = 7; i < 14; i++, k++) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 42));
                }
                k=0;
                for(i = 14; i < 21; i++, k++) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 79));
                }
                
                k=0;
                for(i = 21; i < 28; i++, k++) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 116));
                }
                
                k=0;
                for(i = 28; i < 35; i++, k++) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 153));
                }
                
                k=0;
                for(i = 35; i < 42; i++, k++) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 190));
                }
                
                k=0;
                for(i = 42; i < 49; i++, k++) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 227));
                }
                
                for(i = 0; i < this._gameField.indestructibleBricks().size(); i++) {
                    _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(i),140+i, 140+i));
                    k++;
                }
                break;
            } case 2: {
                
                _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(0),5, 5));
                _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(1),545, 5));
               
                int k = 0;
                for(i = 2; i < 6; i++, k++) {
                    if(i<4)
                        _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 42));
                    else _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),275+k*90, 42));
                    
                }
                k=0;
                for(i = 6; i < 12; i++, k++) {
                    if(i<9)
                        _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 79));
                    else _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 79));
                    
                }
                k=0;
                for(i = 12; i < 18; i++, k++) {
                    if(i<15)
                        _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 116));
                    else _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 116));
                    
                }
                k=0;
                for(i = 18; i < 24; i++, k++) {
                    if(i<21)
                        _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 154));
                    else _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 154));
                    
                }
                
                k=0;
                for(i = 24; i < 28; i++, k++) {
                    if(i<26)
                        _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 190));
                    else _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),275+k*90, 190));
                    
                }
                _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(28),5, 227));
                _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(29),545, 227));
              
                _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(0),275, 116));
                break;
            } case 3: {
                _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(0),275, 5));
                
                int k = 0;
                for(i = 1; i < 4; i++, k++) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),185+k*90, 42)); 
                }
                k=0;
                for(i = 4; i < 8; i++, k++) {
                    if(i<6)
                        _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 79));
                    else _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),185+k*90, 79));
                    
                }
                k=0;
                for(i = 8; i < 14; i++, k++) {
                    if(i<11)
                        _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 116));
                    else _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 116));
                    
                }
                
                k=0;
                for(i = 14; i < 21; i++, k++) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 190)); 
                }
                k=0;
                for(i = 21; i < 26; i++, k++) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 227)); 
                }
                _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(0),275, 79));
                _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(1),275, 116));
                _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(2),275, 153));
                break;
            } case 4: {
                
                int k = 0;
                
                for(i = 0; i < 3; i++, k+=3) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 5)); 
                }
                k = 0;
                for(i = 3; i < 6; i++, k+=2) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 42)); 
                }
                k=0;
                for(i = 6; i < 8; i++, k+=2) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),185+k*90, 79));
                }
                k=0;
                for(i = 8; i < 12; i++, k++) {
                    if(i<10)
                        _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 116));
                    else _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),275+k*90, 116));
                }
                
                k=0;
                for(i = 12; i < 14; i++, k+=2) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),185+k*90, 153)); 
                }
                k=0;
                for(i = 14; i < 17; i++, k+=2) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 190)); 
                }
                k=0;
                for(i = 17; i < 20; i++, k+=3) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 227)); 
                }
                _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(0),275, 79));
                _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(1),185, 116));
                _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(2),275, 116));
                _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(3),365, 116));
                _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(4),275, 153));
                break;
            } case 5: {
                for(i = 0; i < 7; i++) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+i*90, 5));
                }
                int k = 0;
                for(i = 7; i < 10; i++, k++) {
                    _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),185+k*90, 42));
                }
                
                _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(10),275, 79));
                
                k=0;
                for(i = 11; i < 15; i++, k++) {
                    if(i < 13)
                        _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 116));
                    else _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),275+k*90, 116));
                }
                
                k=0;
                for(i = 15; i < 19; i++, k++) {
                    if(i < 17) 
                        _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 153));
                    else _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),275+k*90, 153));
                }
                
                k=0;
                for(i = 19; i < 23; i++, k++) {
                    if(i < 21)
                        _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 190));
                    else _elements.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),275+k*90, 190));
                }
                _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(0),185, 116));
                _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(1),185, 153));
                _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(2),185, 190));
                k = 0;
                for(i = 3; i < 8; i++, k++) {
                    if(i < 6) 
                        _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(i),5+k*90, 227));
                    else _elements.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(i),185+k*90, 227));
                }
                break;
            } 
        }
        _elements.add(new RacketView((Racket) this._gameField.racket(),320, 640));
        _elements.add(new BoundaryView((BoundaryField) this._gameField.bondarysField().get(0),0, 0));
        _elements.add(new BoundaryView((BoundaryField) this._gameField.bondarysField().get(1),0,0));
        _elements.add(new BoundaryView((BoundaryField) this._gameField.bondarysField().get(2),635, 0));
    }
}
