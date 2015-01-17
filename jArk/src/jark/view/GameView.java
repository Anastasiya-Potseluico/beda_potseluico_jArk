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
    /**Игровое поле представление*/
    private GameFieldView _gameFieldView;
    /** */
    private SpriteGroup      BALLS_GROUP;
    /** */
    private SpriteGroup      BARRIERS_GROUP;
    
    private SpriteGroup RACKET_GROUP;
    
    private SpriteGroup BOUNDARYS_GROUP;
    
    /**
     * 
     * @param gameFieldView 
     */
    public GameView(GameFieldView gameFieldView) {
       _gameFieldView = gameFieldView; 
    }
    
    /**
     * 
     * @return 
     */
    public GameFieldView gameFieldView () {
        return _gameFieldView;
    }
    
    /**
     * 
     */
    public void createSpriteGroup() {
        BALLS_GROUP = new SpriteGroup("balls"); //Группа мячей
        BARRIERS_GROUP = new SpriteGroup("barriers"); //Группа преград
        RACKET_GROUP = new SpriteGroup("racket");
        BOUNDARYS_GROUP = new SpriteGroup("boundarys");
        BALLS_GROUP.clear();
        BARRIERS_GROUP.clear();
        RACKET_GROUP.clear();
        BOUNDARYS_GROUP.clear();
        for(int i = 0; i < gameFieldView().ballsView().size(); i++) {
            BALLS_GROUP.add(gameFieldView().ballsView().get(i).sprite()); 
        }
        for(int i = 0; i < gameFieldView().boundariesView().size(); i++) {
            BARRIERS_GROUP.add(gameFieldView().boundariesView().get(i).sprite());
            BOUNDARYS_GROUP.add(gameFieldView().boundariesView().get(i).sprite());
        }
        for(int i = 0; i < gameFieldView().dBricksView().size(); i++) {
            BARRIERS_GROUP.add(gameFieldView().dBricksView().get(i).sprite());
        }
        for(int i = 0; i < gameFieldView().iBricksView().size(); i++) {
            BARRIERS_GROUP.add(gameFieldView().iBricksView().get(i).sprite());
        }
        BARRIERS_GROUP.add(gameFieldView().racketView().sprite());
        RACKET_GROUP.add(gameFieldView().racketView().sprite());
    }
    
    public SpriteGroup ballsGroup() {
        return BALLS_GROUP;
    }
    
    public SpriteGroup barriersGroup() {
        return BARRIERS_GROUP;
    }
    
    public SpriteGroup racketGroup() {
        return RACKET_GROUP;
    }
    
    public SpriteGroup boundaryGroup() {
        return BOUNDARYS_GROUP;
    }
    
    public void deleteBrick(Sprite sprite) {
        BARRIERS_GROUP.remove(sprite);
    }
}
