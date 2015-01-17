/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jark.Player;
import jark.events.GameOverListener;
import jark.events.DestructionEvent;
import jark.events.DestructionListener;
import jark.specifications.Buffer;
import jark.view.GameView;

/**
 *
 * @author Дарья
 */
public class GameModel {
    /** Игрок */
    private Player _player;
    /**Игровое поля логика */
    private GameField _gameField;
    /** Уровень (1-3) */
    private int _level = 1;
    
    private boolean _isBallStart = true;
    /** */
    private GameView _gameView;
    
    private boolean _isGameOver;
    public boolean  _isEndGame = false;
    
    public GameModel() {
        _player = new Player();
        _gameField = new GameField();
        _gameView = new GameView(_gameField.gameFieldView());
    }
    
    public GameView gameView() {
        return _gameView;
    }
    
    public void newGame() {
        _isBallStart = true;
        _isGameOver = false;
        //очистить поля
        clearField();
        // создать новые условия игры
        gameField().setField(_level);
        gameView().createSpriteGroup();
        for (int i = 0; i < gameField().balls().size(); i++) {
            gameField().balls().get(i).addBallListener(new GameModel.gameOver());
        }
        for (int i = 0; i < gameField().destructibleBricks().size(); i++) {
            gameField().destructibleBricks().get(i).addBrickListener(new GameModel.removeBrick());
        }
    }
        
    
    public Player player() {
        return _player;
    }
    
    public int level() {
        return _level;
    }
    
    public boolean isBallStart () {
        return _isBallStart;
    }
    
    public GameField gameField () {
        return _gameField;
    }
    
    public void startBall() {
        _isBallStart = false;
        _gameField.balls().get(0).setSpeed(0, -0.4);
    }
    
    public class gameOver implements GameOverListener {
        @Override
        public void gameOver() {
            _isGameOver = true;
            player().reduceNumberOfLives();
            if(player().numberOfLives() == 0) {
                endGame();
            }
        }
    }
    
    public boolean isGameOver() {
        return _isGameOver;
    }
    
    private void clearField() {
        gameField().clear();
        gameView().clearField(); 
        for(int i = 0; i < gameField().balls().size(); i++) {
            gameField().balls().get(i).listeners().clear();
        }
        for (int i = 0; i < gameField().destructibleBricks().size(); i++) {
            gameField().destructibleBricks().get(i).listeners().clear();
        }
    }

     public class removeBrick implements DestructionListener {
        @Override
        public void brickHitted(DestructionEvent e, DestructibleBrick dBrick) {
            if(dBrick.hadrness() == 0) {
                boolean found = false;
                for(int i = 0; i< gameView().gameFieldView().dBricksView().size() && !found; i++) {
                    if(gameView().gameFieldView().dBricksView().get(i).sprite() == Buffer.findSprite(dBrick)) {
                        found = true;
                        gameView().gameFieldView().dBricksView().remove(i);
                    }
                }
                gameView().deleteBrick(Buffer.findSprite(dBrick));
                Buffer.deleteElement(dBrick);
                gameField().deleteElementField(dBrick);
                player().sumScore(20);
            }
        } 
    }
     
     public void endGame() {
         _isGameOver = false;
         _isEndGame = true;
         clearField();
     }
     
     public boolean isEndGame () {
         return _isEndGame;
     }
    
}
