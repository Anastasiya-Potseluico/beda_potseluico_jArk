/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.background.ColorBackground;
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
    
    /** Бэкграунд */
    Background  background;
    /** 
     * Конструктор
     */
    public JarkGame() {
        _player = new Player();
        _gameFieldView = new GameFieldView(this);
    }
    
    /** 
     * Закончить игру
     */
    public void finish() {
        
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
        background = new ColorBackground(Color.BLUE, 640, 480);
        _gameFieldView = new GameFieldView(this);
    }

    @Override
    public void update(long l) {
        background.update(l);
    }

    @Override
    public void render(Graphics2D gd) {
        background.render(gd);    
    }
}

