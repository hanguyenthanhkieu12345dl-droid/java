package test;

import data.JdbcPerson;
import domain.Person;
import java.util.List;

public class JdbcHandlingTest {

    public static void main(String[] args) {

        JdbcPerson jdbcPerson = new JdbcPerson();

        // Test phương thức insert
        // jdbcPerson.insert("Charly");

        // Test phương thức update
        // jdbcPerson.update(1, "John");

        // Test phương thức delete
        // id_person phải tồn tại trong database
        // jdbcPerson.delete(4);

        // Select method test
        // Sử dụng object person để chứa thông tin
        // của database record
        List<Person> people = jdbcPerson.select();

        for (Person person : people) {
            System.out.print(person);
            System.out.println("");
        }
    }
}