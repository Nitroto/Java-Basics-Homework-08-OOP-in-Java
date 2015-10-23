package com.softuni.geometry.shapes.shapes2d;

import com.softuni.geometry.shapes.Shape;
import com.softuni.geometry.vertex.Vertex;
import com.softuni.geometry.interfaces.AreaMeasurable;
import com.softuni.geometry.interfaces.PerimeterMeasurable;

import java.util.List;

public abstract class PlaneShape extends Shape implements PerimeterMeasurable, AreaMeasurable {

    protected PlaneShape(List<Vertex> vertices) {

        super(vertices);
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();
        output.append(super.toString());
        for (Vertex vertex : this.getVertices()) {
            output.append(String.format("%s", vertex.toString()));
        }

        output.append(String.format("Perimeter: %.2f\nArea: %.2f\n", this.getPerimeter(), this.getArea()));
        output.append("\n");
        return output.toString();
    }
}
