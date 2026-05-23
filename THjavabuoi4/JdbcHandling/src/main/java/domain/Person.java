package domain;

public class Person {

	private int idPerson;
	private String name;

	// SỬA ĐOẠN HÀM MAIN NÀY CỦA BẠN:
	public static void main(String[] args) {
		Person p = new Person();
		p.setIdPerson(1);
		p.setName("Test Run");
		System.out.println("Chuong trinh da chay thanh cong: " + p.toString());
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" + "idPerson=" + idPerson + ", name=" + name + '}';
	}

}