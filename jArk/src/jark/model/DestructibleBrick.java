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
     * @param commonHardness общая прочность
     * @param weight вес кирпича
     */
    public DestructibleBrick(int commonHardness, int weight) {
        super(weight);
        this._hardness = commonHardness;
    }
    
    /**
     * Функция разрушения кирпича
     * @param count количество единиц, на которое уменьшается прочность кирпича
     */
    private void destruct(int count){
        if(count > this._hardness){
            this._hardness = 0;
        } else {
            this._hardness = this._hardness - count;
        }     
    }


    @Override
    public void reactOnCollision(ElementField element) {
        destruct(element.weight());
    }
            
}
