/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.collisionManagers;

import com.golden.gamedev.object.collision.AdvanceCollisionGroup;
import jArk.physicalObjects.ElementFieldView;

/**
 * Класс обработчика коллизий
 * @author пользователь
 */
public class CollisionManager {
    
    /**Стандартный обработчик коллизий */
    private AdvanceCollisionGroup _collision;
    
    /**
     * Метод для обработки коллизии
     */
    public void manageCollision(){
        
    }
    
    /**
     * Метод для добавления групп коллизий (чтобы менеджер не обращался к полю)
     * @param group1 первая группа представлений элементов
     * @param group2 вторая группа представлений элементов
     */
    public void setCollisionGroup(ElementFieldView group1[], ElementFieldView group2[]){
        
    }
    
    
}
