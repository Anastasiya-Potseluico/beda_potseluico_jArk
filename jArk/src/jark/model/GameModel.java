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

    /**
     * Игрок
     */
    private Player _player;
    /**
     * Логическое представление игрового поля
     */
    private GameField _gameField;
    /**
     * Уровень (1-5)
     */
    private int _level = 0;
    /**
     * Флаг начала попытки
     */
    private boolean _isBallStart = true;
    /**
     * Физическое представление игры
     */
    private GameView _gameView;
    /**
     * Флаг уменьшения жизни
     */
    private boolean _isGameOver;
    /**
     * Флаг окончания игры
     */
    public boolean _isEndGame = false;

    /**
     * Конструктор
     */
    public GameModel() {
        _player = new Player();
        _gameField = new GameField();
        _gameView = new GameView(_gameField.gameFieldView());
    }

    /**
     * Возвращает физическое представление игры
     *
     * @return физическое представление игры
     */
    public GameView gameView() {
        return _gameView;
    }

    /**
     * Начало новой попытки
     */
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

    /**
     * Возвращает игрока игры
     *
     * @return игрок
     */
    public Player player() {
        return _player;
    }

    /**
     * Возвращает уровень игры
     *
     * @return уровень
     */
    public int level() {
        return _level;
    }

    /**
     * Флаг начала попытки
     *
     * @return флаг
     */
    public boolean isBallStart() {
        return _isBallStart;
    }

    /**
     * Возвращает логическое представление игрового поля
     *
     * @return
     */
    public GameField gameField() {
        return _gameField;
    }

    /**
     * Начать попытку
     */
    public void startBall() {
        _isBallStart = false;
        for (int i = 0; i < _gameField.balls().size(); i++) {
            _gameField.balls().get(i).setSpeed(0, -0.3);
        }
    }

    /**
     * Класс столкновения мяча с нижней границей поля - в какой-то части -
     * проигрыш
     */
    public class gameOver implements GameOverListener {

        /**
         * Столкновение мяча с нижней границей поля
         *
         * @param ball мяч
         */
        @Override
        public void delBall(Ball ball) {
            gameView().gameFieldView().ballsView().indexOf(Buffer.findSprite(ball));
            gameView().deleteBallFromGroups(Buffer.findSprite(ball));
            Buffer.deleteElement(ball);
            gameField().deleteElementField(ball);
        }
    }

    /**
     * Флаг уменьшения жизни игрока
     *
     * @return флаг
     */
    public boolean isGameOver() {
        return gameField().balls().isEmpty();
    }

    /**
     * Очистить игровое поле
     */
    private void clearField() {
        gameField().clear();
        gameView().clearField();
        for (int i = 0; i < gameField().balls().size(); i++) {
            gameField().balls().get(i).listeners().clear();
        }
        for (int i = 0; i < gameField().destructibleBricks().size(); i++) {
            gameField().destructibleBricks().get(i).listeners().clear();
        }
    }

    /**
     * Класс удаления кирпича от столкновения с мячом
     */
    public class removeBrick implements DestructionListener {

        @Override
        public void brickHitted(DestructionEvent e, DestructibleBrick dBrick) {
            if (dBrick.hadrness() == 0) {
                boolean found = false;
                for (int i = 0; i < gameView().gameFieldView().dBricksView().size() && !found; i++) {
                    if (gameView().gameFieldView().dBricksView().get(i).sprite() == Buffer.findSprite(dBrick)) {
                        found = true;
                        gameView().gameFieldView().dBricksView().remove(i);
                    }
                }
                gameView().deleteBrickFromGroups(Buffer.findSprite(dBrick));
                Buffer.deleteElement(dBrick);
                gameField().deleteElementField(dBrick);
                player().sumScore(20);
            }
        }
    }

    /**
     * Закончить игру
     */
    public void endGame() {
        _isGameOver = false;
        _isEndGame = true;
        clearField();
    }

    /**
     * Флаг окончания игры
     *
     * @return флаг
     */
    public boolean isEndGame() {
        return _isEndGame;
    }

}
