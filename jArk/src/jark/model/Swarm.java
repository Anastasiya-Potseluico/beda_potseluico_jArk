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
     * Функция для присоединенния мяча к рою
     * @param ball мяч
     * @return успешность присоединения
     */
    public boolean insertBall(Ball ball)
    {
        return true;
    }
}
