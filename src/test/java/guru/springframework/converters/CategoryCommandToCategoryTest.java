package guru.springframework.converters;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;

public class CategoryCommandToCategoryTest {
	public static final Long ID_VALUE =  Long.valueOf(1L);
    public static final String DESCRIPTION = "description";
    
    CategoryCommandToCategory converter;
    
    @BeforeEach
    public void setUp() throws Exception {
    	converter = new CategoryCommandToCategory();
    }
    
    @Test
    public void testNullObject() throws Exception{
    	assertNull(converter.convert(null));
    }
    
    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CategoryCommand()));
    }
    
    @Test
    public void convert() throws Exception {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = converter.convert(categoryCommand);

        //then
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
    
}
