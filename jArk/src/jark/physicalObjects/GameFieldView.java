/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jArk.physicalObjects;

import com.golden.gamedev.object.PlayField;
import jark.JarkGame;
import jark.events.DestructionEvent;
import jark.events.DestructionListener;
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
    
    /** Массив разрушаемых кирпичей, содержащихся на поле*/
    private ArrayList <DestructibleBrickView> _dBricksView = new ArrayList();
    /** Массив неразрушаемых кирпичей, содержащихся на поле*/
    private ArrayList <IndestructibleBrickView> _iBricksView = new ArrayList();
    /** Массив мячей, содержащихся на поле*/
    private ArrayList <BallView> _ballsView = new ArrayList();
    /** Массив мячей, содержащихся на поле*/
    private ArrayList <BoundaryView> _boundariesView = new ArrayList();
    /** Массив мячей, содержащихся на поле*/
    private RacketView _racketView;
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
    
    public ArrayList<DestructibleBrickView> dBricksView() {
        return _dBricksView;
    }
    
    public ArrayList<IndestructibleBrickView> iBricksView() {
        return _iBricksView;
    }
    
    public ArrayList<BallView> ballsView() {
        return _ballsView;
    }
    
    public ArrayList<BoundaryView> boundariesView() {
        return _boundariesView;
    }
    
    public RacketView racketView() {
        return _racketView;
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
        //TODO
        return null;
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
        ElementField el;
        switch (level) {
            case 1: {
               
                for(i = 0; i < 7; i++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+i*90, 5));
                }
                
                int k = 0;
                for(i = 7; i < 14; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 42));
                }
                k=0;
                for(i = 14; i < 21; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 79));
                }
                
                k=0;
                for(i = 21; i < 28; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 116));
                }
                
                k=0;
                for(i = 28; i < 35; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 153));
                }
                
                k=0;
                for(i = 35; i < 42; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 190));
                }
                
                k=0;
                for(i = 42; i < 49; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 227));
                }
                
                for(i = 0; i < this._gameField.indestructibleBricks().size(); i++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _iBricksView.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(i),140+i, 140+i));
                    k++;
                }
                break;
            } case 2: {
                
                _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(0),5, 5));
                _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(1),545, 5));
                ((DestructibleBrick) this._gameField.destructibleBricks().get(0)).addBrickListener(new GameFieldView.removeSprite());
                ((DestructibleBrick) this._gameField.destructibleBricks().get(1)).addBrickListener(new GameFieldView.removeSprite());
               
                int k = 0;
                for(i = 2; i < 6; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    if(i<4)
                        _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 42));
                    else _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),275+k*90, 42));
                    
                }
                k=0;
                for(i = 6; i < 12; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    if(i<9)
                        _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 79));
                    else _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 79));
                    
                }
                k=0;
                for(i = 12; i < 18; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    if(i<15)
                        _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 116));
                    else _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 116));
                    
                }
                k=0;
                for(i = 18; i < 24; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    if(i<21)
                        _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 154));
                    else _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 154));
                    
                }
                
                k=0;
                for(i = 24; i < 28; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    if(i<26)
                        _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 190));
                    else _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),275+k*90, 190));
                    
                }
                _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(28),5, 227));
                _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(29),545, 227));
                ((DestructibleBrick) this._gameField.destructibleBricks().get(28)).addBrickListener(new GameFieldView.removeSprite());
                ((DestructibleBrick) this._gameField.destructibleBricks().get(29)).addBrickListener(new GameFieldView.removeSprite());
              
                _iBricksView.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(0),275, 116));
                break;
            } case 3: {
                _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(0),275, 5));
                ((DestructibleBrick) this._gameField.destructibleBricks().get(0)).addBrickListener(new GameFieldView.removeSprite());
                
                int k = 0;
                for(i = 1; i < 4; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),185+k*90, 42)); 
                }
                k=0;
                for(i = 4; i < 8; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    if(i<6)
                        _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 79));
                    else _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),185+k*90, 79));
                    
                }
                k=0;
                for(i = 8; i < 14; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    if(i<11)
                        _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 116));
                    else _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 116));
                    
                }
                
                k=0;
                for(i = 14; i < 21; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 190)); 
                }
                k=0;
                for(i = 21; i < 26; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 227)); 
                }
                _iBricksView.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(0),275, 79));
                _iBricksView.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(1),275, 116));
                _iBricksView.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(2),275, 153));
                break;
            } case 4: {
                
                int k = 0;
                
                for(i = 0; i < 3; i++, k+=3) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 5)); 
                }
                k = 0;
                for(i = 3; i < 6; i++, k+=2) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 42)); 
                }
                k=0;
                for(i = 6; i < 8; i++, k+=2) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),185+k*90, 79));
                }
                k=0;
                for(i = 8; i < 12; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    if(i<10)
                        _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 116));
                    else _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),275+k*90, 116));
                }
                
                k=0;
                for(i = 12; i < 14; i++, k+=2) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),185+k*90, 153)); 
                }
                k=0;
                for(i = 14; i < 17; i++, k+=2) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),95+k*90, 190)); 
                }
                k=0;
                for(i = 17; i < 20; i++, k+=3) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 227)); 
                }
                _iBricksView.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(0),275, 79));
                _iBricksView.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(1),185, 116));
                _iBricksView.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(2),275, 116));
                _iBricksView.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(3),365, 116));
                _iBricksView.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(4),275, 153));
                break;
            } case 5: {
                for(i = 0; i < 7; i++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+i*90, 5));
                }
                int k = 0;
                for(i = 7; i < 10; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),185+k*90, 42));
                }
                ((DestructibleBrick) this._gameField.destructibleBricks().get(10)).addBrickListener(new GameFieldView.removeSprite());
                _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(10),275, 79));
                
                k=0;
                for(i = 11; i < 15; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    if(i < 13)
                        _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 116));
                    else _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),275+k*90, 116));
                }
                
                k=0;
                for(i = 15; i < 19; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    if(i < 17) 
                        _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 153));
                    else _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),275+k*90, 153));
                }
                
                k=0;
                for(i = 19; i < 23; i++, k++) {
                    ((DestructibleBrick) this._gameField.destructibleBricks().get(i)).addBrickListener(new GameFieldView.removeSprite());
                    if(i < 21)
                        _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),5+k*90, 190));
                    else _dBricksView.add(new DestructibleBrickView((DestructibleBrick) this._gameField.destructibleBricks().get(i),275+k*90, 190));
                }
                _iBricksView.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(0),185, 116));
                _iBricksView.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(1),185, 153));
                _iBricksView.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(2),185, 190));
                k = 0;
                for(i = 3; i < 8; i++, k++) {
                    if(i < 6) 
                        _iBricksView.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(i),5+k*90, 227));
                    else _iBricksView.add(new IndestructibleBrickView((IndestructibleBrick) this._gameField.indestructibleBricks().get(i),185+k*90, 227));
                }
                break;
            } 
        }
        _racketView = new RacketView((Racket) this._gameField.racket(),251, 500);
        _boundariesView.add(new BoundaryView((BoundaryField) this._gameField.bondarysField().get(0),0, 0));
        _boundariesView.add(new BoundaryView((BoundaryField) this._gameField.bondarysField().get(1),0,0));
        _boundariesView.add(new BoundaryView((BoundaryField) this._gameField.bondarysField().get(2),635, 0));
        _ballsView.add(new BallView((Ball) this._gameField.balls().get(0),295, 464));
        _ballsView.add(new BallView((Ball) this._gameField.balls().get(1),295, 65));
    }
    
    public class removeSprite implements DestructionListener {
        @Override
        public void brickDestroyed(DestructionEvent e, DestructibleBrick dBrick) {
            boolean found = false;
            int i=0;
            while(!found) {
                if(_dBricksView.get(i)._elementField == dBrick) {
                    found = true;
                    _game.removeBrickSprite(_dBricksView.get(i).sprite());
                    _dBricksView.remove(i);
                }
                i++;
            }
        } 
    }
}
