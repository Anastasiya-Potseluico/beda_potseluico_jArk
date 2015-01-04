/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.background.ImageBackground;
import jArk.physicalObjects.BallView;
import jArk.physicalObjects.GameFieldView;
import jark.collisionManagers.Collision;
import jark.collisionManagers.CollisionMan;
import jark.model.GameField;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

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
    
    Collision _collision;
    
    SpriteGroup      BALL_GROUP;
    
    SpriteGroup      BRICK_GROUP;
    
    /** 
     * Конструктор
     */
    public JarkGame() {
        this.distribute = true;
        _player = new Player();
        _level = 5;
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
        BALL_GROUP = new SpriteGroup("balls"); //Группа мячей
        BRICK_GROUP = new SpriteGroup("obstacles"); //Группа преград
        _gameFieldView = new GameFieldView(this,_level);
        _gameFieldView.setStartPosition(_level);
        for(i = 0; i < this._gameFieldView.ballsView().size(); i++) {
            BALL_GROUP.add(this._gameFieldView.ballsView().get(i).sprite()); 
            BRICK_GROUP.add(this._gameFieldView.ballsView().get(i).sprite());
        }
        for(i = 0; i < this._gameFieldView.boundariesView().size(); i++) {
            BRICK_GROUP.add(this._gameFieldView.boundariesView().get(i).sprite());
        }
        for(i = 0; i < this._gameFieldView.dBricksView().size(); i++) {
            BRICK_GROUP.add(this._gameFieldView.dBricksView().get(i).sprite());
        }
        for(i = 0; i < this._gameFieldView.iBricksView().size(); i++) {
            BRICK_GROUP.add(this._gameFieldView.iBricksView().get(i).sprite());
        }
        BRICK_GROUP.add(this._gameFieldView.racketView().sprite());
        
        _gameFieldView.addGroup(BALL_GROUP);
        _gameFieldView.addGroup(BRICK_GROUP);
        backgr = new ImageBackground(getImage("background.jpg"), 650, 550);
        _gameFieldView.setBackground(backgr);
        _collision = new Collision(new CollisionMan());
        _collision.pixelPerfectCollision = true;
        _gameFieldView.addCollisionGroup(BALL_GROUP, BRICK_GROUP, _collision);
    }

    @Override
    public void update(long l) {
        _gameFieldView.updateElements(l);
        double speedX = 0;
        if (keyDown(KeyEvent.VK_LEFT))   speedX = -0.5;
        if (keyDown(KeyEvent.VK_RIGHT))  speedX = 0.5;
            this._gameFieldView.racketView().sprite().setHorizontalSpeed(speedX);
        
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

