package com.softuni.geometry;

import com.softuni.geometry.interfaces.VolumeMeasurable;
import com.softuni.geometry.shapes.Shape;
import com.softuni.geometry.shapes.shapes2d.*;
import com.softuni.geometry.shapes.shapes3d.Cuboid;
import com.softuni.geometry.shapes.shapes3d.Sphere;
import com.softuni.geometry.shapes.shapes3d.SquarePyramid;
import com.softuni.geometry.vertex.Vertex2d;
import com.softuni.geometry.vertex.Vertex3d;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;


public class GeometryMain {

    public static void main(String[] args) {

        Locale englishLocale = new Locale("en", "US");
        Locale.setDefault(englishLocale);

        Shape[] shapes = {
                new Rectangle(new Vertex2d(0, 0), 10, 15),
                new Triangle(new Vertex2d(0, 0), new Vertex2d(10, 0), new Vertex2d(5, 10)),
                new Circle(new Vertex2d(0, 0), 11.1),
                new Cuboid(new Vertex3d(0, 0, 0), 10, 15, 5),
                new Sphere(new Vertex3d(0, 0, 0), 11.1),
                new SquarePyramid(new Vertex3d(0, 0, 0), 10, 15)
        };

        for (Shape shape : shapes) {
            System.out.print(shape.toString());
        }

        Object[] volumeMesuarable = Arrays.stream(shapes)
                .filter(x -> x instanceof VolumeMeasurable && ((VolumeMeasurable) x).getVolume() > 40.0)
                .toArray();
        for (Object shape : volumeMesuarable) {
            System.out.print(shape.toString());
        }

        Object[] planeShapes = Arrays.stream(shapes)
                .filter(x -> x instanceof PlaneShape)
                .sorted(new Comparator<Shape>() {
                    @Override
                    public int compare(Shape o1, Shape o2) {
                        return (((Double) ((PlaneShape) o1).getPerimeter()).compareTo(((PlaneShape) o2).getPerimeter()));
                    }
                })
                .toArray();
        for (Object shape : planeShapes) {
            System.out.print(shape.toString());
        }
    }
}
