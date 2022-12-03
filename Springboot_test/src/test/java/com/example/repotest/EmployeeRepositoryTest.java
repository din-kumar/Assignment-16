package com.example.repotest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.entity.Employee;
import com.example.reporistory.EmployeeRepository;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class EmployeeRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	void testSaveNewEmloyee() {
		testEntityManager.persist(new Employee(11, "e", "a@gmail.com"));
		Employee e = employeeRepository.findById(11).get();
		assertThat(e.getName()).isEqualTo("e");
	}

	@Test
	void testFetchAStudent() {
		
		Employee e = employeeRepository.findById(11).get();
		assertThat(e.getEmail()).isEqualTo("a@gmail.com");
	}

	@Test
	void testUpdateAStudent() {
		Employee e = employeeRepository.findById(11).get();
		e.setEmail("a@hotmail.com");
		e.setName("Mahesh");
		testEntityManager.persist(e);
		Employee sUpdated = employeeRepository.findById(11).get();

		assertThat(sUpdated.getEmail()).isEqualTo("a@hotmail.com");
	}
}
