package guru.springframework.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class CategoryTest {

	Category category;
	
	@Before
	void setUp() throws Exception {
		category = new Category();
	}

	@Test
	void testGetId() {
		Long idValue = 4L;
		category.setId(idValue);
		assertEquals(idValue, category.getId());
	}

	@Test
	void testGetDescription() throws Exception {
		
	}

	@Test
	void testGetRecipes() {
		
	}

}
