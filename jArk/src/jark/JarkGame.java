/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.background.ColorBackground;
import com.golden.gamedev.object.background.ImageBackground;
import jArk.physicalObjects.BallView;
import jArk.physicalObjects.GameFieldView;
import jark.model.GameField;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Класс игры
 * @author Дарья
 */
public class JarkGame extends Game{
    /** Игрок */
    private Player _player;
    /**Игровое поле представление*/
    private GameFieldView _gameFieldView;
    /**Игровое поля логика */
    private GameField _gameField;
    /** Уровень (1-5) */
    private int _level;
    /** Бэкграунд */
    Background backgr;
    
    SpriteGroup      BALL_GROUP;
    
    SpriteGroup      BRICK_GROUP;
    /** 
     * Конструктор
     */
    public JarkGame() {
        _player = new Player();
        _level = 2;
        _gameFieldView = new GameFieldView(this,_level);
    }
    
    /**
     * Возвращает представление игрового поля
     * @return представление игрового поля
     */
    public GameFieldView gameFieldView() {
        return _gameFieldView;
    }

    @Override
    public void initResources() {
        int i;
        BALL_GROUP = new SpriteGroup("balls");
        BRICK_GROUP = new SpriteGroup("obstacles"); //Группа преград
        _gameFieldView = new GameFieldView(this,_level);
        _gameFieldView.setStartPosition(_level);
        for(i = 0; i < this._gameFieldView.elements().size(); i++) {
            if(this._gameFieldView.elements().get(i) instanceof BallView) {
                BALL_GROUP.add(this._gameFieldView.elements().get(i).sprite());
            }
            BRICK_GROUP.add(this._gameFieldView.elements().get(i).sprite());
        }
        _gameFieldView.addGroup(BALL_GROUP);
        _gameFieldView.addGroup(BRICK_GROUP);
        backgr = new ImageBackground(getImage("background.jpg"), 650, 550);
        _gameFieldView.setBackground(backgr);
    }

    @Override
    public void update(long l) {
        _gameFieldView.updateElements(l);
    }

    @Override
    public void render(Graphics2D gd) {
        _gameFieldView.render(gd);   
       // backgr.render(gd); 
    }
    
    public int level() {
        return this._level;
    }
}

