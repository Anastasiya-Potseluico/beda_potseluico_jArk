/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

/**
 * Класс границы поля
 * @author Дарья
 */

enum TYPE {HORISONTAL, VERTICAL};

public class BoundaryField extends ElementField {
    /**
     * Конструктор границ
     */
    private TYPE _type;
    
    public BoundaryField (TYPE type) {
        super(MASS.INF_MASS);
        _type = type;
    }

    @Override
    public void reactOnCollision(ElementField element) {
       
    }
    
    public TYPE type() {
        return _type;
    }
}
