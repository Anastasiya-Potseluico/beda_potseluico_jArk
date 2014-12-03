/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

/**
 * Класс элемента роя
 * @author Дарья
 */
public class ElementSwarm extends ElementField {

    public ElementSwarm() {
        super(MASS.OTHER);
    }

    @Override
    public void reactOnCollision(ElementField element) {
        
    }
    
}
