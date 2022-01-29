package praktikum;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void valuesLength() {
        assertEquals(2, IngredientType.values().length);
    }

    @Test
    public void valueOfSauceAndFilling() {
        assertEquals("SAUCE", IngredientType.valueOf("SAUCE").toString());
        assertEquals("FILLING", IngredientType.valueOf("FILLING").toString());
    }
}