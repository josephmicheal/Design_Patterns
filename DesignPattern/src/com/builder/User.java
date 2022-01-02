package com.builder;
public class User
{
	//All final attributes
	private final String firstName; // required
	private final String lastName; // required
	private final int age; // optional
	private final String phone; // optional
	private final UserAddress address; // optional

	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}

	//All getter, and NO setter to provde immutability
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public String getPhone() {
		return phone;
	}
	public UserAddress getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
	}

	
	public static class UserBuilder
	{
		private final String firstName;
		private final String lastName;
		private int age;
		private String phone;
		private UserAddress address;

		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}
		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}
		public UserBuilder address(UserAddress address) {
			this.address = address;
			return this;
		}
		//Return the finally consrcuted User object
		public User build() {
			User user =  new User(this);
			validateUserObject(user);
			return user;
		}
		private void validateUserObject(User user) {
			//Do some basic validations to check
			//if user object does not break any assumption of system
		}
	}
	
	public static void main(String[] args) 
	{
		User employee = new User.UserBuilder("Lokesh", "Gupta")
		.age(30)
		.phone("1234567")
		.address(new UserAddress("Fake","city", "1234"))
		.build();

		System.out.println(employee);

		User user2 = new User.UserBuilder("Jack", "Reacher")
		.age(40)
		.phone("5655")
		//no address
		.build();

		System.out.println(user2);

		User deliveryBoy = new User.UserBuilder("Super", "Man")
		//No age
		//No phone
		//no address
		.build();

		System.out.println(deliveryBoy);
	}  
}
class UserAddress{
	private String st;
	private String city;
	private String zip;
	
	public UserAddress(String st, String city, String zip){
		this.st = st;
		this.city = city;
		this.zip = zip;
	}
	
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "UserAddress [st=" + st + ", city=" + city + ", zip=" + zip + "]";
	}
	
	
	
}