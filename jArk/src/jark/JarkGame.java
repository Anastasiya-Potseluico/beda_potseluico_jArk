/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.background.ColorBackground;
import com.golden.gamedev.object.background.ImageBackground;
import jArk.physicalObjects.GameFieldView;
import jark.model.GameField;
import java.awt.Color;
import java.awt.Graphics2D;

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
    /** 
     * Конструктор
     */
    public JarkGame() {
        _player = new Player();
        _gameFieldView = new GameFieldView(this,1);
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
        _gameFieldView = new GameFieldView(this,1);
        backgr = new ImageBackground(getImage("background.jpg"), 710, 710);
        _gameFieldView.setBackground(backgr);
    }

    @Override
    public void update(long l) {
       // background.update(l);
       // backgr.update(l);
        _gameFieldView.update(l);
    }

    @Override
    public void render(Graphics2D gd) {
        _gameFieldView.render(gd);   
       // backgr.render(gd); 
    }
}

