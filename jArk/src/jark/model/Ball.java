/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;


/**
 * Класс мяча
 * @author Дарья
 */
public class Ball extends ElementField implements Collide {
    
    /**
     * Конструктор
     * @param weight Вес мяча
     */
    public Ball(int weight) {
        super(weight);
    }
    
    /**
     * Отскочить от элемента поля
     * @param element элемент поля, от которого отскакивает мяч
     * @return результат отскока
     */
    public boolean rebound(ElementField element) {
        
        return true;
    }

    /**
     * Функция обработки столкновения с движимым объектом
     * @param _element Элемент,с которым произошло столкновение
     */
    @Override
    public void collideWithMovableElement(ElementField _element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Функция обработки столкновения с неподвижным объектом
     * @param _element Элемент,с которым произошло столкновение
     */
    @Override
    public void collideWithUnmovableElement(ElementField _element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
