package com.behavioural.visitor;

public class VisitorDesignPatternApp {
	
	public static void main(String args[]) {
		Shape circle = new Circle();
		Shape rectangle = new Rectangle();
		
		Visitor visitor = new XMLExportVisitor();
		circle.accept(visitor);
		rectangle.accept(visitor);
		
	}

}

interface Shape {
	void accept(Visitor v);
}

class Circle implements Shape {

	int radius = 5;

	@Override
	public void accept(Visitor v) {

		v.visitCircle(this);
	}

}

class Rectangle implements Shape {

	int width = 5;
	int breath = 5;

	@Override
	public void accept(Visitor v) {

		v.visitRectangle(this);
	}

}

interface Visitor {
	void visitCircle(Circle c);

	void visitRectangle(Rectangle c);
}

class XMLExportVisitor implements Visitor {

	@Override
	public void visitCircle(Circle c) {
		System.out.println("<XML> Circle with raidus " + c.radius);

	}

	@Override
	public void visitRectangle(Rectangle c) {
		System.out.println("<XML> Rectangle with width " + c.width + " breath " + c.breath);

	}

}