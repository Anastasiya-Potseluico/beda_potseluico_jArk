/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.GameFont;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.background.ImageBackground;
import jArk.physicalObjects.BallView;
import jArk.physicalObjects.GameFieldView;
import jark.collisionManagers.Collision;
import jark.collisionManagers.CollisionMan;
import jark.events.DestructionEvent;
import jark.events.DestructionListener;
import jark.model.GameField;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import static javafx.scene.text.Font.font;

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
    
    CollisionMan _collisionManager;
    
    SpriteGroup      BALL_GROUP;
    
    SpriteGroup      BRICK_GROUP;
    
    GameFont           font;
    
    private enum gameState {GAME_OVER, NEXT_LEVEL, GAME_FINISHED, GAME_CONTINUED};
    
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
        _collisionManager = new CollisionMan(_gameFieldView);
        _collisionManager.setPerfectCollision(true);
        _gameFieldView.addCollisionGroup(BALL_GROUP, BRICK_GROUP, _collisionManager.collision());
        font = fontManager.getFont(getImages("font.png", 20, 3),
                                   " !            .,0123" +
                                   "456789:   -? ABCDEFG" +
                                   "HIJKLMNOPQRSTUVWXYZ ");
    }

    @Override
    public void update(long l) {
        _gameFieldView.updateElements(l);
        double speedX = 0;
        if (keyDown(KeyEvent.VK_LEFT)) {
            speedX = -0.5;
        }
        if (keyDown(KeyEvent.VK_RIGHT)) {
            speedX = 0.5;
        }
        if(this._gameFieldView.racketView().racket().hasBall()&&speedX!=0) {
            this._gameFieldView.ballsView().get(0).sprite().setSpeed(0.1, -0.1);
            this._gameFieldView.ballsView().get(1).sprite().setVerticalSpeed(0.1);
            this._gameFieldView.racketView().racket().resetBall();
        }
            this._gameFieldView.racketView().sprite().setHorizontalSpeed(speedX);
    }

    @Override
    public void render(Graphics2D gd) {
        _gameFieldView.render(gd);   
        String lifes = "LIFES:" + String.valueOf(_player.numberOfLives());
        font.drawString(gd, lifes, 10, 530);
        String level = "LEVEL:" + String.valueOf(_level);
        font.drawString(gd, level, 180, 530);
        String scores = "SCORE:" + String.valueOf(_player.scores());
        font.drawString(gd, scores, 350, 530); 
        gameState state = identifyGameOver();
        switch (state) {
            case GAME_OVER: {
                String over = "YOU LOOSE!";
                font.drawString(gd, over, 350, 330);
                break;
            } case NEXT_LEVEL: {
                //создать стартовую обстановку следующего уровня.
                break;
            } case GAME_FINISHED: {
                String finished = "YOU WIN!\nCONGRADULATIONS!!";
                font.drawString(gd, finished, 350, 330);
                break;
            }
            
        }
    }
    
    public int level() {
        return this._level;
    }
    
    public gameState identifyGameOver() {
        if(_gameField.balls().isEmpty()) {
            return gameState.GAME_OVER;
        } else if (_gameField.destructibleBricks().isEmpty() && _level < 5) {
            return gameState.NEXT_LEVEL;
        } else if (_gameField.destructibleBricks().isEmpty() && _level == 5){
            return gameState.GAME_FINISHED;
        }
        return gameState.GAME_CONTINUED;
    }
    
    public void removeBrickSprite (Sprite sprite) {
        BRICK_GROUP.remove(sprite);
    }
    
    public void addScores () {
        _player.sumScore(20);
    }
}

