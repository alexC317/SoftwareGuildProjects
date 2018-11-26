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
public class Circle extends Shape{
    private double radius;
    
    public Circle(double r){
        radius = r;
    }
    
    @Override
    public double getArea(){
        area = radius * 3.14;
        return area;
    }
    
    @Override
    public double getPerimeter(){
        perimeter = 2 * 3.14 * radius;
        return perimeter;
    }
}
