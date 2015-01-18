/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import jark.collisionManagers.CollisionMan;
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
    
    /** Список слушателей кирпича */
    private ArrayList <DestructionListener> _listeners = new ArrayList ();
    
    /**
     * Конструктор разрушаемого кирпича
     * @param hardness прочность
     * @param x координата х кирпича на поле
     * @param y координата у кирпича на поле
     */
    public DestructibleBrick(int hardness, int x, int y) {
        super(MASS.INF_MASS, x, y);
        _hardness = hardness;
    }
    
    /**
     * Метод разрушения кирпича
     */
    private void destruct(){
        _hardness-=1; 
        Iterator i = _listeners.iterator();
        DestructionListener listener;
        while(i.hasNext()){ // Оповещение всех слушателей кирпича о его разрушении
            listener = (DestructionListener)i.next();
            listener.brickHitted(null,this);
        } 
    }

    /**
     * Метод реакции кирпича на коллизию
     * @param element элемент, который столкнулся с кирпичом
     * @param type тип коллизии
     */
    @Override
    public void reactOnCollision(ElementField element, CollisionMan.TYPE type) {
        destruct();
    }
    
    /**
     * Метод получения прочности кирпича
     */
    public int hadrness() {
        return this._hardness;
    }
    
     /**
     * Метод для добавления слушателя кирпича
     * @param listener слушатель кирпича
     */
    public void addBrickListener(DestructionListener listener) {
        _listeners.add(listener);
    }
    
    /**
     * Метод для получения слушателей кирпича
     * @return список слушателей кирпича
     */
    public ArrayList listeners(){
        return this._listeners;
    }
}
