package com.mig.dailyprogrammer;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mramos on 9/21/2015.
 */

//https://www.cs.umd.edu/~samir/grant/cp.pdf reference to a better algorithm
public class GrandMother {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(Paths.get("./ch232i/src/main/resources/input"));
            list.remove(0); //remove the size of the list
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Point> points = list.stream().map(Point::toPoint).collect(Collectors.toList());
        List<Point> bPoints = new ArrayList<>(points); //pretty much secure that there's a better way... mmm

        PairOfPoints cartesianProduct = points.stream()
                .flatMap(a -> bPoints.stream().map(b -> new PairOfPoints(a, b))) //cartesian product
                .filter(e -> (!e.getA().equals(e.getB()))) //avoid APoint to APoint scenario
                .min((e1, e2) -> e1.getDisFactor().compareTo(e2.getDisFactor())) //get the min using the Dis Facotors
                .get();

        System.out.println(cartesianProduct);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println(duration/1000.0);
    }
}

class Point {
    public final double x;
    public final double y;

    public Point(double x, double y) {
        this.x = x; this.y = y;
    }

    public double disFactor(Point p) {
        return Math.abs((this.x - p.x)) + Math.abs((this.y - p.y));
    }

    @Override
    public String toString() {
        return "{" + "" + x + ", " + y + '}';
    }

    public static Point toPoint(String line) {
        String[] xy = line.replace("(", "").replace(")", "").split(",");
        return new Point(Double.parseDouble(xy[0]), Double.parseDouble(xy[1]));
    }
}

class PairOfPoints {
    private Point a;
    private Point b;
    private Double disFactor;
    public PairOfPoints(Point a, Point b) {
        this.a = a;
        this.b = b;
        disFactor = a.disFactor(b);
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Double getDisFactor() {
        return disFactor;
    }

    @Override
    public String toString() {
        return "PairOfPoints{" +  "a=" + a + ", b=" + b + '}';
    }
}