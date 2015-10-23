package com.softuni.geometry.vertex;

public class Vertex2d extends Vertex {

    public Vertex2d(double x, double y) {
        super(x, y);
    }

    public double getDistance(Vertex2d otherVertex) {
        double distance = Math.sqrt(Math.pow((this.getX() - otherVertex.getX()), 2)
                + Math.pow((this.getY() - otherVertex.getY()), 2));
        return distance;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("X: %.2f Y: %.2f\n", this.getX(), this.getY()));
        return output.toString();
    }
}
