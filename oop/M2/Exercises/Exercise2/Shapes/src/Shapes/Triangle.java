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
public class Triangle extends Shape {

    private double width, height, side1, side2, side3;

    public Triangle(double h, double w, double s1, double s2, double s3){
        height = h;
        width = w;
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }
    
    @Override
    public double getArea(){
        area = (height * width) / 2;
        return area;
    }
    
    @Override
    public double getPerimeter(){
        perimeter = side1 + side2 + side3;
        return perimeter;
    }
}
