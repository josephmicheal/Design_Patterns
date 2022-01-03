package com.behavioural.visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorDesignPatternApp {
	
	
	public static void main(String args[]) {
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new VisitorDesignPatternApp().new Circle());
		shapes.add(new VisitorDesignPatternApp().new Rectangle());
		
		Visitor visitor = new VisitorDesignPatternApp().new ExportVisitor();
		shapes.forEach(shape -> {
			shape.accept(visitor);
		});
		
	}

	interface Shape {
		void accept(Visitor v);
	}

	class Circle implements Shape {

		private int radius = 5;

		@Override
		public void accept(Visitor v) {

			v.visitCircle(this);
		}

	}

	class Rectangle implements Shape {

		private int width = 5;
		private int breath = 5;

		@Override
		public void accept(Visitor v) {

			v.visitRectangle(this);
		}

	}

	interface Visitor {
		void visitCircle(Circle c);

		void visitRectangle(Rectangle c);
	}

	class ExportVisitor implements Visitor {

		@Override
		public void visitCircle(Circle c) {
			System.out.println("Circle with raidus " + c.radius);

		}

		@Override
		public void visitRectangle(Rectangle c) {
			System.out.println("Rectangle with width " + c.width + " breath " + c.breath);

		}

	}

}
