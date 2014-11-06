/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jArk.specifications;

/**
 * Скорость объекта игрового поля
 * @author Дарья
 */
public class Speed {
    /** Вектор скорости по Х */
    private double _vx;
    /** Вектор скорости по У */
    private double _vy;
    
    public Speed(double vx, double vy){
        this._vx = vx;
        this._vy = vy;
    }
    
    /**
     * Изменить скорость
     * @param vx вектор скорости по Х
     * @param vy вектор скорости по Y
     * @return успех изменения
     */
    public boolean setSpeed (double vx, double vy) {
        _vx = vx;
        _vy = vy;
        return true;
    }
    
    /**
     * Геттер для горизонтальной скорости
     * @return горизонтальная скорость
     */
    public double getVX(){
        return this._vx;
    }
    
    /**
     * Геттер для вертикальной скорости
     * @return вертикальная скорость
     */
    public double getVY(){
        return this._vy;
    }
    
    public Speed revert(){
        return new Speed(-_vx, -_vy);
    }
}
