package com.softuni.geometry.shapes.shapes3d;

import com.softuni.geometry.interfaces.VolumeMeasurable;
import com.softuni.geometry.shapes.shapes2d.PlaneShape;
import com.softuni.geometry.vertex.Vertex;
import com.softuni.geometry.vertex.Vertex3d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquarePyramid extends SpaceShape {

    private double baseWidth;
    private double pyramidHeight;

    public void setBaseWidth(double baseWidth) {
        if (baseWidth < 0) {
            throw new IllegalArgumentException("Base width can not be negative.");
        }
        this.baseWidth = baseWidth;
    }

    public void setPyramidHeight(double pyramidHeight) {
        if (pyramidHeight < 0) {
            throw new IllegalArgumentException("Pyramid height can not be negative.");
        }
        this.pyramidHeight = pyramidHeight;
    }

    public SquarePyramid(Vertex3d baseCenter, double baseWidth, double pyramidHeight) {
        super(new ArrayList<Vertex>(Arrays.asList(baseCenter)));
        this.setBaseWidth(baseWidth);
        this.setPyramidHeight(pyramidHeight);
    }

    @Override
    public double getArea() {
        //A = a(a + ?(a2 + 4h2))
        double area = this.baseWidth * (this.baseWidth + Math.sqrt(Math.pow(this.baseWidth, 2) + 4 * Math.pow(this.pyramidHeight, 2)));
        return area;
    }

    @Override
    public double getVolume() {
        double volume = (Math.pow(this.baseWidth, 2) * this.pyramidHeight) / 3;
        return volume;
    }
}
