/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.specifications;

import com.golden.gamedev.object.Sprite;
import jark.model.ElementField;
import java.util.HashMap;

/**
 *
 * @author Дарья
 */
public class Buffer {
    private static HashMap <ElementField, Sprite> _elements_sprite = 
            new HashMap <ElementField, Sprite> ();
    
    /**
     * 
     * @param element
     * @param sprite 
     */
    public static void addElement(ElementField element, Sprite sprite){
        if (element != null && sprite != null) {
            _elements_sprite.put(element, sprite);
        }
    }
    
    /**
     * 
     * @param sprite
     * @return 
     */
    public static ElementField findElement (Sprite sprite) {
        return null;
    }
    
    /**
     *
     * @param element
     * @return
     */
    public static Sprite findSprite (ElementField element) {
        return _elements_sprite.get(element);
    }
}