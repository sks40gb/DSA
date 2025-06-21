package designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Shape> shapeList = new ArrayList<>();
        XMLVisitor visitor = new XMLVisitor();
        Circle circle = new Circle(10.2);
        circle.setVisitor(visitor);

        Square square = new Square(2.0);
        square.setVisitor(visitor);

        Triangle triangle = new Triangle(1.0, 2.0);
        triangle.setVisitor(visitor);

        shapeList.add(circle);
        shapeList.add(square);
        shapeList.add(triangle);

        String xmlData = "";

        for(Shape shape : shapeList){
            xmlData += shape.extractData();
        }
        System.out.println(xmlData);

    }

}
