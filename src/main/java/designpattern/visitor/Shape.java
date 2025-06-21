package designpattern.visitor;

public abstract class Shape {

    protected Visitor visitor;

    public void setVisitor(Visitor visitor){
        this.visitor = visitor;
    }

    abstract double area();

    abstract String extractData();

}
