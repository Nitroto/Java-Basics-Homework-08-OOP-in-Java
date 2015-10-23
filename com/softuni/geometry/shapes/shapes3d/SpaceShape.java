package com.softuni.geometry.shapes.shapes3d;

import com.softuni.geometry.shapes.Shape;
import com.softuni.geometry.vertex.Vertex;
import com.softuni.geometry.interfaces.AreaMeasurable;
import com.softuni.geometry.interfaces.VolumeMeasurable;

import java.util.List;

public abstract class SpaceShape extends Shape implements AreaMeasurable, VolumeMeasurable {

    protected SpaceShape(List<Vertex> vertices) {

        super(vertices);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(super.toString());
        for (Vertex vertex : this.getVertices()) {
            output.append(vertex.toString());
        }
        output.append(String.format("Area: %.2f\nVolume: %.2f\n", this.getArea(), this.getVolume()));
        output.append("\n");
        return output.toString();
    }


}
