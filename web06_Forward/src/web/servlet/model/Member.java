package web.servlet.model;

public class Member {
	private String name;
	private int age;
	private String address;

	// 생성자 두 개 만들기
	public Member(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public Member() {
		super();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
    public String toString() {
        return "Member [name=" + name + ", age=" + age + ", address=" + address + "]";
    } 
}