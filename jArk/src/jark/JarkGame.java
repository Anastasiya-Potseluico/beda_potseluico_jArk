/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.GameFont;
import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.background.ImageBackground;
import jark.collisionManagers.CollisionMan;
import jark.model.GameModel;
import jark.view.GameView;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 * Класс игры
 * @author Дарья
 */
public class JarkGame extends Game{
    
    private PlayField _playField;
    
    private GameModel _gameModel;
    
    private GameView _gameView;
    
    
    /** */
    private CollisionMan _collisionManager;
    
    
    /** Бэкграунд */
    Background backgr;
    

    
    GameFont           font;
    
    private enum gameState {GAME_OVER, GAME_FINISHED, GAME_CONTINUED};
    
    @Override
    public void initResources() {
        this.distribute = true;
        _gameModel = new GameModel();
        _gameView = _gameModel.gameView();
        _playField = _gameView.gameFieldView();
        _gameModel.startGame();      
        _playField.addGroup(_gameView.ballsGroup());
        _playField.addGroup(_gameView.barriersballsGroup());
        backgr = new ImageBackground(getImage("background.jpg"), 650, 550);
        _playField.setBackground(backgr);
        _collisionManager = new CollisionMan();
        _collisionManager.setPerfectCollision(true);
        _playField.addCollisionGroup(_gameView.ballsGroup(), 
                _gameView.barriersballsGroup(), _collisionManager.collision());
        font = fontManager.getFont(getImages("font.png", 20, 3),
                                   " !            .,0123" +
                                   "456789:   -? ABCDEFG" +
                                   "HIJKLMNOPQRSTUVWXYZ ");
    }

    @Override
    public void update(long l) {
        double speedX = 0;
        if (keyDown(KeyEvent.VK_LEFT)) {
            speedX = -0.5;
        }
        if (keyDown(KeyEvent.VK_RIGHT)) {
            speedX = 0.5;
        }
        _gameView.gameFieldView().racketView().sprite().setHorizontalSpeed(speedX);
    }

    @Override
    public void render(Graphics2D gd) {
        _gameView.gameFieldView().render(gd);   
        String lifes = "LIFES:" + String.valueOf(_gameModel.player().numberOfLives());
        font.drawString(gd, lifes, 10, 530);
        String level = "LEVEL:" + String.valueOf(_gameModel.level());
        font.drawString(gd, level, 180, 530);
        String scores = "SCORE:" + String.valueOf(_gameModel.player().scores());
        font.drawString(gd, scores, 350, 530); 
        gameState state = identifyGameOver();
        switch (state) {
            case GAME_OVER: {
                String over = "YOU LOOSE!";
                font.drawString(gd, over, 350, 330);
                break;
            } case GAME_FINISHED: {
                String finished = "YOU WIN!\nCONGRADULATIONS!!";
                font.drawString(gd, finished, 350, 330);
                break;
            }
            
        }
    }
    
    /**
     *
     * @return
     */
    public gameState identifyGameOver() {
        if(_gameModel.gameField().balls().isEmpty()) {
            return gameState.GAME_OVER;
        } else {
            return gameState.GAME_CONTINUED;
        }
    }
    
    
    public void addScores () {
        _gameModel.player().sumScore(20);
    }
}

