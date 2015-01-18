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
 * Класс-буфер, связывающий логику и физику
 *
 * @author Дарья
 */
public class Buffer {

    /**
     * Карта элементов и соответствующих спрайтов
     */
    private static HashMap<ElementField, Sprite> _elements_sprite
            = new HashMap<ElementField, Sprite>();

    /**
     * Добавить элемент в карту
     *
     * @param element элемент
     * @param sprite спрайт
     */
    public static void addElement(ElementField element, Sprite sprite) {
        if (element != null && sprite != null) {
            _elements_sprite.put(element, sprite);
        }
    }

    /**
     * Удалить элемент из карты
     *
     * @param element элемент
     */
    public static void deleteElement(ElementField element) {
        if (element != null) {
            _elements_sprite.remove(element);
        }
    }

    /**
     * Найти элемент по спрайту
     *
     * @param sprite спрайт
     * @return элемент
     */
    public static ElementField findElement(Sprite sprite) {
        for (ElementField key : _elements_sprite.keySet()) {
            if (_elements_sprite.get(key).equals(sprite)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Найти спрайт по элементу
     *
     * @param element элемент
     * @return спрайт
     */
    public static Sprite findSprite(ElementField element) {
        return _elements_sprite.get(element);
    }
}
