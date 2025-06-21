package designpattern.visitor;

public class Square extends Shape{

    private double length;

    public double getLength(){
        return this.length;
    }

    public Square(double length){
        this.length = length;
    }

    public String extractData(){
        return this.visitor.visit(this);
    }

    @Override
    public double area() {
        return length * length;
    }
}
