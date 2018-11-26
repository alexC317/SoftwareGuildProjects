/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

/**
 *
 * @author Alex
 */
abstract class Shape {
    protected String color;
    protected double area;
    protected double perimeter;
    
    abstract double getArea();
    abstract double getPerimeter();
    
}
