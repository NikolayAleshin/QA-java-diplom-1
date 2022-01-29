package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Хруст булочка", 10.99f},
                {IngredientType.FILLING, "", 1},
                {IngredientType.FILLING, "Хруст булочка", 0},
                {null, null, 0},
        };
    }

    @Before
    public void init() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPrice() {
        assertEquals(price, ingredient.getPrice(), 0.00f);
    }

    @Test
    public void getName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals(type, ingredient.getType());
    }
}