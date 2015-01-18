/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.view;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;

/**
 *
 * @author Дарья
 */
public class GameView {

    /**
     * Физическое представление игрового поля
     */
    private GameFieldView _gameFieldView;
    /**
     * Группа спрайтов мячей
     */
    private SpriteGroup BALLS_GROUP;
    /**
     * Группа спрайтов преград: границы поля, ракетка, кирпичи
     */
    private SpriteGroup BARRIERS_GROUP;
    /**
     * Группа спрайта ракетки
     */
    private SpriteGroup RACKET_GROUP;
    /**
     * Группа спрайтов границ поля
     */
    private SpriteGroup BOUNDARYS_GROUP;

    /**
     * Конструктор
     *
     * @param gameFieldView
     */
    public GameView(GameFieldView gameFieldView) {
        _gameFieldView = gameFieldView;
    }

    /**
     * Возвращает физическое представление игрового поля
     *
     * @return физическое представление игрового поля
     */
    public GameFieldView gameFieldView() {
        return _gameFieldView;
    }

    /**
     * Создать группы спрайтов
     */
    public void createSpriteGroup() {
        BALLS_GROUP = new SpriteGroup("balls");
        BARRIERS_GROUP = new SpriteGroup("barriers");
        RACKET_GROUP = new SpriteGroup("racket");
        BOUNDARYS_GROUP = new SpriteGroup("boundarys");
        BALLS_GROUP.clear();
        BARRIERS_GROUP.clear();
        RACKET_GROUP.clear();
        BOUNDARYS_GROUP.clear();
        for (int i = 0; i < gameFieldView().ballsView().size(); i++) {
            BALLS_GROUP.add(gameFieldView().ballsView().get(i).sprite());
        }
        for (int i = 0; i < gameFieldView().boundariesView().size(); i++) {
            BARRIERS_GROUP.add(gameFieldView().boundariesView().get(i).sprite());
            BOUNDARYS_GROUP.add(gameFieldView().boundariesView().get(i).sprite());
        }
        for (int i = 0; i < gameFieldView().dBricksView().size(); i++) {
            BARRIERS_GROUP.add(gameFieldView().dBricksView().get(i).sprite());
        }
        for (int i = 0; i < gameFieldView().iBricksView().size(); i++) {
            BARRIERS_GROUP.add(gameFieldView().iBricksView().get(i).sprite());
        }
        BARRIERS_GROUP.add(gameFieldView().racketView().sprite());
        RACKET_GROUP.add(gameFieldView().racketView().sprite());
    }

    /**
     * Возвращает группу спрайтов мячей
     *
     * @return группа спрайтов мячей
     */
    public SpriteGroup ballsGroup() {
        return BALLS_GROUP;
    }

    /**
     * Возвращает группу спрайтов преград
     *
     * @return группа спрайтов преград
     */
    public SpriteGroup barriersGroup() {
        return BARRIERS_GROUP;
    }

    /**
     * Возвращает группу спрайта ракетки
     *
     * @return группа спрайта ракетки
     */
    public SpriteGroup racketGroup() {
        return RACKET_GROUP;
    }

    /**
     * Возвращает группу спрайтов границ поля
     *
     * @return группа спрайтов границ поля
     */
    public SpriteGroup boundaryGroup() {
        return BOUNDARYS_GROUP;
    }

    /**
     * Очистить поле от спрайтов
     */
    public void clearField() {
        for (int i = 0; i < gameFieldView().dBricksView().size(); i++) {
            BARRIERS_GROUP.remove(gameFieldView().dBricksView().get(i).sprite());
        }
        gameFieldView().dBricksView().clear();
        for (int i = 0; i < gameFieldView().iBricksView().size(); i++) {
            BARRIERS_GROUP.remove(gameFieldView().iBricksView().get(i).sprite());
        }
        gameFieldView().iBricksView().clear();
        for (int i = 0; i < gameFieldView().ballsView().size(); i++) {
            BALLS_GROUP.remove(gameFieldView().ballsView().get(i).sprite());
        }
        gameFieldView().ballsView().clear();
        if (gameFieldView().racketView() != null) {
            BARRIERS_GROUP.remove(gameFieldView().racketView().sprite());
            RACKET_GROUP.remove(gameFieldView().racketView().sprite());
            gameFieldView().deleteElementFieldView(gameFieldView().racketView());
        }

    }

    /**
     * Удалить кирпич из группы спрайтов
     *
     * @param sprite спрайт кирпича
     */
    public void deleteBrickFromGroups(Sprite sprite) {
        BARRIERS_GROUP.remove(sprite);
    }

    /**
     * Удалить мяч из группы спрайтов
     *
     * @param sprite спрайт мяча
     */
    public void deleteBallFromGroups(Sprite sprite) {
        BALLS_GROUP.remove(sprite);
    }
}
