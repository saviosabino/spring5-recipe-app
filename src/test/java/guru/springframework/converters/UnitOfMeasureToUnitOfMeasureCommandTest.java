package guru.springframework.converters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;

class UnitOfMeasureToUnitOfMeasureCommandTest {
	
	public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = Long.valueOf(1L);
    UnitOfMeasureToUnitOfMeasureCommand converter;

	@BeforeEach
	void setUp() throws Exception {
		converter = new UnitOfMeasureToUnitOfMeasureCommand();
	}

	@Test
	public void testNullObjectConvert() throws Exception {
		assertNull(converter.convert(null));
	}

	@Test
	public void testEmptyObj() throws Exception {
		assertNotNull(converter.convert(new UnitOfMeasure()));
	}

	@Test
	public void convert() throws Exception {
		//given
		UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(LONG_VALUE);
		uom.setDescription(DESCRIPTION);
		//when
		UnitOfMeasureCommand uomc = converter.convert(uom);

		//then
		assertEquals(LONG_VALUE, uomc.getId());
		assertEquals(DESCRIPTION, uomc.getDescription());
	}

}
