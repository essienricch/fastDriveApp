package africa.semicolon.project.uber_deluxe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UberDeluxeApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void databaseConnectionTest(){
		DataSource dataSource = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/",
				"postgres","momentum");
		try {
			Connection connection = dataSource.getConnection();
			assertNotNull(connection);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
