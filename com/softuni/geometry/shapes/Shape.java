package com.softuni.geometry.shapes;

import com.softuni.geometry.vertex.Vertex;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape {

    private List<Vertex> vertices;

    protected Shape(List<Vertex> vertices) {

        this.vertices = vertices;
    }

    public List<Vertex> getVertices() {

        return vertices;
    }

    public void addVertex(Vertex vertex){

        this.vertices.add(vertex);
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();
        output.append(String.format("%s\nVertices\n", this.getClass().getSimpleName()));
        return output.toString();
    }
}
