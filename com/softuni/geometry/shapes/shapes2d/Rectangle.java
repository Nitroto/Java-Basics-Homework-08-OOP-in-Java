package com.softuni.geometry.shapes.shapes2d;

import com.softuni.geometry.vertex.Vertex;
import com.softuni.geometry.vertex.Vertex2d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rectangle extends PlaneShape {
    private double height;
    private double width;

    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width can not be negative.");
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height can not be negative.");
        }
        this.height = height;
    }

    public Rectangle(Vertex2d a, double width, double height) {

        super(new ArrayList<Vertex>(Arrays.asList(a)));
        try {
            this.width = width;
            this.height = height;
        } catch (Exception e) {
            e.printStackTrace();

            // there may be many rectangles with a starting point A and with this height and width
            // this is one of the variants
            //coordinates for point B are X of A plus width and Y of A
            this.addVertex(new Vertex2d(a.getX() + width, a.getY()));
            //coordinates for point C are X of A plus width and Y of A plus height
            this.addVertex(new Vertex2d(a.getX() + width, a.getY() + height));
            //coordinates for point C are X of A and Y of A plus height
            this.addVertex(new Vertex2d(a.getX(), a.getY() + height));
        }
    }

    @Override
    public double getArea() {
        double area = this.width * this.height;
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 2 * (this.width + this.height);
        return perimeter;
    }
}