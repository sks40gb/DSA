package designpattern.visitor;

public class XMLVisitor implements Visitor{


    @Override
    public String visit(Shape shape) {
        System.out.println("shape :" + shape);
        throw new RuntimeException("Operation not supported");
    }

    @Override
    public String visit(Circle circle) {
        System.out.println("circle :" + circle);
        return "<td>" + circle.getRadius() + "</td>";
    }

    @Override
    public String visit(Square square) {
        System.out.println("square :" + square);
        return "<td>" + square.getLength() + "</td>";
    }

    @Override
    public String visit(Triangle triangle) {
        System.out.println("triangle :" + triangle);
        return "<td>" + triangle.getBase() + "</td> <td>" + triangle.getHeight() + "</td>";
    }
}
