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
public class Square extends Shape{
    private double side;

    
    public Square(double s){
        side = s;
    }
    
    @Override
    public double getArea(){
        area = (side * side);
        return area;
    }
    
    @Override
    public double getPerimeter(){
        perimeter = side * 4;
        return perimeter;
    }
}
