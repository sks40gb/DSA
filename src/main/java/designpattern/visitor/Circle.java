package designpattern.visitor;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

    public String extractData(){
        return this.visitor.visit(this);
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
