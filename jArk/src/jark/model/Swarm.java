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
     * @param weight вес роя
     * @param elements элементы роя
     */
    public Swarm(int weight, ArrayList<ElementSwarm> elements) {
        super(weight);
        this._elements = elements;
    }
    
    /**
     * Функция для присоединенния мяча к рою
     * @param ball мяч
     * @return успешность присоединения
     */
    public boolean insertBall(Ball ball)
    {
        _elements.add(new ElementSwarm(5));
        return _capability <= _elements.size();
    }
    
    /**
     * Возвращает элементы роя
     * @return элементы роя
     */
    public ArrayList <ElementSwarm> elements () {
        return _elements;
    }
    
    /**
     * Установить вместимость роя
     * @param capability вместимость
     */
    public void setCapability (int capability) {
        _capability = capability;
    }
    
    /**
     * Возвращает вместимость роя
     * @return вместимость
     */
    public int capability() {
        return _capability;
    }

    @Override
    public void reactOnCollision(ElementField element) {
        boolean ok = true;
        if(element instanceof Ball){
            ok = this.insertBall((Ball)element);
        }
        if(!ok) {
            //TODO если рой переполнен - отправить сигнал к завершению игры.
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
