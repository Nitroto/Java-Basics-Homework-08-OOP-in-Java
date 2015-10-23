package com.softuni.geometry.shapes.shapes3d;

import com.softuni.geometry.vertex.Vertex;
import com.softuni.geometry.vertex.Vertex3d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sphere extends SpaceShape {

    private static final double PI = Math.PI;
    private double radius;

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius can not be negative.");
        }
        this.radius = radius;
    }

    public Sphere(Vertex3d center, double radius) {
        super(new ArrayList<Vertex>(Arrays.asList(center)));
        this.setRadius(radius);
    }

    @Override
    public double getArea() {
        double area = 4 * PI * Math.pow(this.radius, 2);
        return area;
    }

    @Override
    public double getVolume() {
        double volume = (4 * PI * Math.pow(this.radius, 3)) / 3;
        return volume;
    }
}
