/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

/**
 * Класс разрушаемого кирпича
 * @author Дарья
 */
public class DestructibleBrick extends Brick{
    /** Прочность */
    private int _hardness;
    
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
        _hardness--; 
        //сделать сигнал полю
    }


    @Override
    public void reactOnCollision(ElementField element) {
        destruct();
    }
    
    public int hadrness() {
        return this._hardness;
    }
            
}
