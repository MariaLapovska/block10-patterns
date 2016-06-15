package com.epam.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite pattern
 */
public class CompositeApp {

    public static void main(String[] args) {
        Shape square1=new Square();
        Shape square2=new Square();
        Shape triangle1=new Triangle();

        Shape square3=new Square();
        Shape circle1=new Circle();
        Shape circle2=new Circle();
        Shape circle3=new Circle();

        Composite composite=new Composite();
        Composite composite1=new Composite();
        Composite composite2=new Composite();

        composite1.addComponent(square1);
        composite1.addComponent(square2);
        composite1.addComponent(triangle1);

        composite2.addComponent(square3);
        composite2.addComponent(circle1);
        composite2.addComponent(circle2);
        composite2.addComponent(circle3);

        composite.addComponent(composite1);
        composite.addComponent(composite2);

        composite.draw();
    }
}

interface Shape {
    void draw();
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("I'm a square");
    }
}

class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("I'm a triangle");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("I'm a circle");
    }
}

class Composite implements Shape {
    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component) {
        components.add(component);
    }

    public void removeComponent(Shape component) {
        components.remove(component);
    }

    @Override
    public void draw() {
        components.forEach(Shape::draw);
    }
}
