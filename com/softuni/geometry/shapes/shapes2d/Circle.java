package com.softuni.geometry.shapes.shapes2d;

import com.softuni.geometry.vertex.Vertex;
import com.softuni.geometry.vertex.Vertex2d;

import java.util.ArrayList;
import java.util.Arrays;

public class Circle extends PlaneShape {

    private static final double PI = Math.PI;
    private double radius;

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius can not be negative.");
        }
        this.radius = radius;
    }

    public Circle(Vertex2d center, double radius) {
        super(new ArrayList<Vertex>(Arrays.asList(center)));
        try {
            this.setRadius(radius);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public double getArea() {
        double area = PI * Math.pow(this.radius, 2);
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 2 * PI * this.radius;
        return perimeter;
    }
}
