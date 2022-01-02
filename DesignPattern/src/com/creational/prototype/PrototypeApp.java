package com.creational.prototype;

public class PrototypeApp {

	public static void main(String args[]) {
		Shape circle = new Circle(1, 2, 3);
		((Circle)circle).setGeoLocation(new GeoLocation(4, 5));
		System.out.println(circle.hashCode()+":"+circle);
		circle = circle.clone();
		System.out.println(circle.hashCode()+":"+circle);
	}
}

abstract class Shape {
	private int x;
	private int y;

	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Shape(Shape target) {
		this.x = target.x;
		this.y = target.y;
	}

	public abstract Shape clone();
	 
	@Override
	public String toString() {
		return "Shape [x=" + x + ", y=" + y + "]";
	}
	
}

class Circle extends Shape {
	private int radius;
	private GeoLocation geoLocation;

	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	public Circle(Shape target) {
		super(target);
		if (target != null) {
			this.radius = ((Circle) target).radius;
			if(((Circle)target).geoLocation != null){
				this.geoLocation = new GeoLocation(((Circle)target).geoLocation);
			}
		}
	}

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", geoLocation=" + geoLocation + "]";
	}

	@Override
	public Shape clone() {
		// TODO Auto-generated method stub
		return new Circle(this);
	}
	
}

class Rectangle extends Shape {
	private int height;
	private int weight;
	
	public Rectangle(int x, int y, int height, int weight) {
		super(x, y);
		this.height = height;
		this.weight = weight;
	}

	public Rectangle(Shape target) {
		super(target);
		if (target != null) {
			this.height = ((Rectangle) target).height;
			this.weight = ((Rectangle) target).weight;
		}
	}

	@Override
	public Shape clone() {
		// TODO Auto-generated method stub
		return new Rectangle(this);
	}
	
	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", weight=" + weight + "]";
	}
}

class GeoLocation{
	private int longi;
	private int latit;
	public GeoLocation(int longi, int latit) {
		this.longi = longi;
		this.latit = latit;
	}
	
	public GeoLocation(GeoLocation target) {
		this.longi = target.longi;
		this.latit = target.latit;
	}
	
	@Override
	public String toString() {
		return "GeoLocation [hashCode="+this.hashCode()+", longi=" + longi + ", latit=" + latit + "]";
	}
	
}