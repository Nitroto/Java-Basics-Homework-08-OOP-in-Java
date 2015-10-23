package com.softuni.geometry.vertex;

public class Vertex3d extends Vertex2d {
    private double z;

    public Vertex3d(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public Vertex3d() {
        this(0.0, 0.0, 0.0);
    }

    public double getZ() {
        return z;
    }

    public double getDistance(Vertex3d otherVertex) {
        double distance = Math.sqrt(Math.pow((this.getX() - otherVertex.getX()), 2)
                + Math.pow((this.getY() - otherVertex.getY()), 2)
                + Math.pow((this.getZ() - otherVertex.getZ()), 2));
        return distance;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("X: %.2f Y: %.2f Z: %.2f\n", this.getX(), this.getY(), this.getZ()));
        return output.toString();
    }
}