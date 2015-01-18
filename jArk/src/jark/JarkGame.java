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
import jark.specifications.Buffer;
import jark.view.GameView;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 * Класс игры
 *
 * @author Дарья
 */
public class JarkGame extends Game {

    /**
     * Игровое поле
     */
    private PlayField _playField;
    /**
     * Логическая модель игры
     */
    private GameModel _gameModel;
    /**
     * Физическая модель игры
     */
    private GameView _gameView;

    /**
     * Менеджер коллизий
     */
    private CollisionMan _collisionManager;

    /**
     * Бэкграунд
     */
    Background backgr;

    /**
     * Шрифт
     */
    GameFont font;

    /**
     * Состояние игры
     */
    private enum gameState {

        GAME_OVER, GAME_FINISHED, GAME_CONTINUED, END_GAME
    };

    /**
     * Конструктор
     */
    public JarkGame() {
        this.distribute = true;
    }

    /**
     * Инициализирующий метод
     */
    @Override
    public void initResources() {
        _gameModel = new GameModel();
        _gameView = _gameModel.gameView();
        _playField = _gameView.gameFieldView();
        _gameModel.newGame();
        backgr = new ImageBackground(getImage("background.jpg"), 650, 550);
        _playField.setBackground(backgr);
        _collisionManager = new CollisionMan();
        addSpriteGroup();
        font = fontManager.getFont(getImages("font.png", 20, 3),
                " !            .,0123"
                + "456789:   -? ABCDEFG"
                + "HIJKLMNOPQRSTUVWXYZ ");
    }

    /**
     * Добавить группы спрайты на игровое поле
     */
    private void addSpriteGroup() {
        _playField.addGroup(_gameView.ballsGroup());
        _playField.addGroup(_gameView.barriersGroup());
        _playField.addCollisionGroup(_gameView.racketGroup(),
                _gameView.boundaryGroup(), _collisionManager.collisionRacketBoundaries());
        _playField.addCollisionGroup(_gameView.ballsGroup(),
                _gameView.barriersGroup(), _collisionManager.collisionBallsBarrier());
        _playField.addCollisionGroup(_gameView.ballsGroup(), 
                _gameView.ballsGroup(), _collisionManager.collisionBallsBalls());
    }

    /**
     * Удалить группы спрайтов с игрового поля
     */
    private void deleteSpriteGroup() {
        _playField.removeGroup(_gameView.ballsGroup());
        _playField.removeGroup(_gameView.barriersGroup());
        _playField.removeCollisionGroup(_collisionManager.collisionRacketBoundaries());
        _playField.removeCollisionGroup(_collisionManager.collisionBallsBarrier());
        _playField.removeCollisionGroup(_collisionManager.collisionBallsBalls());
    }

    /**
     * Обновление
     *
     * @param l период обновления
     */
    @Override
    public void update(long l) {
        _playField.update(l);
        double speedX = 0;
        if (keyDown(KeyEvent.VK_LEFT)) {
            speedX = -0.5;
        } else if (keyDown(KeyEvent.VK_RIGHT)) {
            speedX = 0.5;
        }
        if (_gameModel.gameField().racket() != null) {
            _gameModel.gameField().racket().setSpeed(speedX, 0);
            if (_gameModel.isBallStart()) {
                _gameModel.gameField().balls().get(0).setSpeed(Buffer.findSprite(_gameModel.gameField().racket()).getHorizontalSpeed(), 0);
            }

            if (keyPressed(KeyEvent.VK_SPACE) && _gameModel.isBallStart()) {
                _gameModel.startBall();
            }
        }
    }

    /**
     * Обрисовка
     *
     * @param gd графика
     */
    @Override
    public void render(Graphics2D gd) {
        _gameView.gameFieldView().render(gd);
        String lifes = "LIFES:" + String.valueOf(_gameModel.player().numberOfLives());
        font.drawString(gd, lifes, 10, 530);
        String level = "LEVEL:" + String.valueOf(_gameModel.level());
        font.drawString(gd, level, 180, 530);
        String scores = "SCORE:" + String.valueOf(_gameModel.player().scores());
        font.drawString(gd, scores, 350, 530);
        gameState state = state();
        switch (state) {
            case GAME_OVER: {
                _gameModel.player().reduceNumberOfLives();
                if (_gameModel.player().numberOfLives() == 0) {
                    _gameModel.endGame();
                } else {
                    deleteSpriteGroup();
                    _gameModel.newGame();
                    addSpriteGroup();
                }
                break;
            }
            case GAME_FINISHED: {
                deleteSpriteGroup();
                String finished = "YOU WIN!\nCONGRADULATIONS!!";
                font.drawString(gd, finished, 350, 330);
                break;
            }
            case END_GAME: {
                deleteSpriteGroup();
                String finished = "THE NUMBER OF LIVES OVER!!!";
                font.drawString(gd, finished, 100, 200);
                break;
            }

        }
    }

    /**
     * Вовзращает состояние игры
     *
     * @return состояне игры
     */
    public gameState state() {
        if (_gameModel.isGameOver()) {
            return gameState.GAME_OVER;
        } else if (_gameModel.isEndGame()) {
            return gameState.END_GAME;
        } else {
            return gameState.GAME_CONTINUED;
        }
    }
}
