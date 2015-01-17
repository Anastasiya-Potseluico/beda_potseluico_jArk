/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jark.JarkGame;
import jark.collisionManagers.CollisionMan;
import jark.model.GameModel;
import jark.events.DestructionListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Класс разрушаемого кирпича
 * @author Дарья
 */
public class DestructibleBrick extends Brick{
    /** Прочность */
    private int _hardness;
    
    private ArrayList <DestructionListener> _listeners = new ArrayList ();//Слушатели кирпича
    
    /**
     * Конструктор
     * @param hardness прочность
     */
    public DestructibleBrick(int hardness, int x, int y) {
        super(MASS.INF_MASS, x, y);
        _hardness = hardness;
    }
    
    /**
     * Функция разрушения кирпича
     * @param count количество единиц, на которое уменьшается прочность кирпича
     */
    private void destruct(){
        _hardness-=1; 
        Iterator i = _listeners.iterator();
        DestructionListener listener;
        while(i.hasNext()){
            listener = (DestructionListener)i.next();
            listener.brickHitted(null,this);
        } 
    }


    @Override
    public void reactOnCollision(ElementField element, CollisionMan.TYPE type) {
        destruct();
    }
    
    public int hadrness() {
        return this._hardness;
    }
    
     /**
     * Метод для добавления слушателя кирпича
     * @param listener слушатель змейки
     */
    public void addBrickListener(DestructionListener listener) {
        _listeners.add(listener);
    }
    
    /**
     * Метод для получения слушателей кирпича
     * @return список слушателей змейки
     */
    public ArrayList listeners(){
        return this._listeners;
    }
            
}
