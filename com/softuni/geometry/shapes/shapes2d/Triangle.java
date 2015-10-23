package com.softuni.geometry.shapes.shapes2d;

import com.softuni.geometry.vertex.Vertex;
import com.softuni.geometry.vertex.Vertex2d;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangle extends PlaneShape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(Vertex2d a, Vertex2d b, Vertex2d c) {

        super(new ArrayList<Vertex>(Arrays.asList(a,b,c)));

        this.sideA = a.getDistance(b);
        this.sideB = b.getDistance(c);
        this.sideC = c.getDistance(a);
    }

    @Override
    public double getArea() {
        //Heron's Formula
        double s = this.getPerimeter() / 2.0;
        double area = Math.sqrt(s * (s - this.sideA) * (s - this.sideB) * (s - this.sideC));
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = this.sideA + this.sideB + this.sideC;
        return perimeter;
    }
}
