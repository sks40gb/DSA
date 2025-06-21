package designpattern.visitor;

public interface Visitor {

     String visit(Shape shape);
     String visit(Circle circle);
     String visit(Square square);
     String visit(Triangle triangle);

}
