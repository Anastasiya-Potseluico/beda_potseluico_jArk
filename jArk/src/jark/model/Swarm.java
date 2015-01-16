/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import java.util.ArrayList;

/**
 * Класс роя
 * @author Дарья
 */
public class Swarm extends ElementField {
    /** Элементы роя */
    private  ArrayList <ElementSwarm> _elements;
    
    /** Вместимость роя */
    private int _capability;

    /**
     * Конструктор роя
     * @param elements элементы роя
     * @param capability
     */
    public Swarm(ArrayList<ElementSwarm> elements, int capability, int x, int y) {
        super(MASS.OTHER, x, y);
        this._elements = elements;
        _capability = capability;
    }
    
    /**
     * Функция для присоединенния мяча к рою
     * @param ball мяч
     * @return успешность присоединения
     */
    private void insertBall(Ball ball)
    {
        //удалить мяч
        _elements.add(new ElementSwarm(0, 0));
        //Провекра наполненности роя; 
    }
    
    /**
     * Возвращает элементы роя
     * @return элементы роя
     */
    public ArrayList <ElementSwarm> elements () {
        return _elements;
    }

    @Override
    public void reactOnCollision(ElementField element) {
        if(element instanceof Ball){
            insertBall((Ball)element);
        }
    }
}
