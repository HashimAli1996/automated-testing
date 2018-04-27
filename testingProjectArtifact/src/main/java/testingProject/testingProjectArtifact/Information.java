package testingProject.testingProjectArtifact;

public class Information {
	
	private String name;
	private int age;
	private int feet;
	
	public Information(String name, int age, int feet) {
		super();
		this.name = name;
		this.age = age;
		this.feet = feet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getFeet() {
		return feet;
	}

	public void setFeet(int feet) {
		this.feet = feet;
	}

	@Override
	public String toString() {
		return "Information [name=" + name + ", age=" + age + ", feet=" + feet + "]";
	}
	
	
	

}
