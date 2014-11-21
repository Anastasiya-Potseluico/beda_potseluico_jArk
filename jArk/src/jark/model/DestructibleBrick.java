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
    /** Количество разрушений */
    private int _destructionCount;
    
    /**
     * Конструктор
     * @param count начальная прочность кирпича
     * @param weight вес кирпича
     */
    public DestructibleBrick(int count, int weight) {
        super(weight);
        this._destructionCount = count;
    }
    
    /**
     * Функция разрушения кирпича
     * @param count количество единиц, на которое уменьшается прочность кирпича
     */
    public void destruct(int count){
        if(count > this._destructionCount){
            this._destructionCount = 0;
        } else {
            this._destructionCount = this._destructionCount - count;
        }     
    }
    
    /**
     * Геттер для прочности разрушаемого кирпича
     * @return прочность кирпича
     */
    public int destructibleCount(){
        return this._destructionCount;
    }

    @Override
    public void reactOnCollision(ElementField element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
}
