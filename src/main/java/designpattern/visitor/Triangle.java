package designpattern.visitor;

public class Triangle extends Shape{

    private double base;
    private double height;

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    public String extractData(){
        return this.visitor.visit(this);
    }

    @Override
    public double area() {
        return .5 * base * height;
    }
}
