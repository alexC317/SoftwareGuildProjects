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
public class Rectangle extends Shape{
    private double length;
    private double width;
    
    public Rectangle(double l, double w){
        length = l;
        width = w;
    }
    
    @Override
    public double getArea(){
        area = (length * width);
        return area;
    }
    
    @Override
    public double getPerimeter(){
        perimeter = 2 * (length + width);
        return perimeter;
    }
    
}
