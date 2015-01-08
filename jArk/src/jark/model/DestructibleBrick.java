/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

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
    public DestructibleBrick(int hardness) {
        super(MASS.INF_MASS);
        _hardness = hardness;
    }
    
    /**
     * Функция разрушения кирпича
     * @param count количество единиц, на которое уменьшается прочность кирпича
     */
    private void destruct(){
        _hardness-=1; 
        if (_hardness == 0) {
            Iterator i = _listeners.iterator();
            DestructionListener listener;
            while(i.hasNext()){
                 listener = (DestructionListener)i.next();
                 listener.brickDestroyed(null,this);
            }
        }
        //Сигнал полю
    }


    @Override
    public void reactOnCollision(ElementField element) {
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
