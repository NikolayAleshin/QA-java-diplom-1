package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    Burger burger;

    @Mock
    Ingredient ingredient, ingredient2;

    @Before
    public void init() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());

    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void removeIngredientInNullList() {
        try {
            burger.removeIngredient(0);
        }
        catch (IndexOutOfBoundsException e) {
            assertEquals("Index 0 out of bounds for length 0", e.getMessage());
        }
    }

    @Test
    public void moveIngredientAndCheckSwapTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        assertEquals(ingredient, burger.ingredients.get(0));
        assertEquals(ingredient2, burger.ingredients.get(1));

        burger.moveIngredient(0, 1);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceFloatNumberTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(10.02f);
        Mockito.when(ingredient.getPrice()).thenReturn(22.32f);

        float actualPrice = burger.getPrice();
        assertEquals(42.36f, actualPrice, 0.0f);
    }

    @Test
    public void getPriceZero() {
        burger.setBuns(bun);

        float actualPrice = burger.getPrice();
        assertEquals(0.00f, actualPrice, 0.0f);
    }

    @Test
    public void getReceiptOnlyBun() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(10.02f);
        Mockito.when(bun.getName()).thenReturn("Булочка");

        assertEquals("(==== Булочка ====)\r\n" +
                "(==== Булочка ====)\r\n" +
                "\r\n" +
                "Price: 20,040001\r\n", burger.getReceipt());
    }

    @Test
    public void getReceiptBunAndIngredient() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getPrice()).thenReturn(10.02f);
        Mockito.when(ingredient.getPrice()).thenReturn(22.32f);
        Mockito.when(ingredient2.getPrice()).thenReturn(10.32f);
        Mockito.when(bun.getName()).thenReturn("Булочка");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("картошка");
        Mockito.when(ingredient2.getName()).thenReturn("котлета");

        assertEquals("(==== Булочка ====)\r\n" +
                "= sauce картошка =\r\n" +
                "= filling котлета =\r\n" +
                "(==== Булочка ====)\r\n" +
                "\r\n" +
                "Price: 52,680000\r\n", burger.getReceipt());
    }
}