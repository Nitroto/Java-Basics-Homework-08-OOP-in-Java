package com.softuni.geometry.shapes.shapes3d;

import com.softuni.geometry.vertex.Vertex;
import com.softuni.geometry.vertex.Vertex3d;

import java.util.ArrayList;
import java.util.Arrays;

public class Cuboid extends SpaceShape {

    private double width;
    private double height;
    private double depth;

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

    public void setDepth(double depth) {
        if (depth < 0) {
            throw new IllegalArgumentException("Depth can not be negative.");
        }
        this.depth = depth;
    }

    public Cuboid(Vertex3d a, double width, double height, double depth) {
        super(new ArrayList<Vertex>(Arrays.asList(a)));
        this.setWidth(width);
        this.setHeight(height);
        this.setDepth(depth);
    }

    public double getVolume() {
        double volume = this.width + this.height + this.height;
        return volume;
    }

    public double getArea() {
        //Area = 2 ? Width ? Length + 2 ? Length ? Height + 2 ? Width ? Height
        double area = 2 * (this.width * this.depth + this.height * this.depth + this.height * this.width);
        return area;
    }
}
