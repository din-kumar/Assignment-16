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
		testEntityManager.persist(new Employee(10, "d", "din@gmail.com"));
		Employee e = employeeRepository.findById(10).get();
		assertThat(e.getName()).isEqualTo("d");
	}

	@Test
	void testFetchAStudent() {
		
		Employee e = employeeRepository.findById(10).get();
		assertThat(e.getEmail()).isEqualTo("din@gmail.com");
	}

	@Test
	void testUpdateAStudent() {
		Employee e = employeeRepository.findById(10).get();
		e.setEmail("din@hotmail.com");
		e.setName("dinbandhu");
		testEntityManager.persist(e);
		Employee sUpdated = employeeRepository.findById(10).get();

		assertThat(sUpdated.getEmail()).isEqualTo("din@hotmail.com");
	}
}
