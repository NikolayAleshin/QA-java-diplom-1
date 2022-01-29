package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
//
//    @Mock
//    Burger burger;

    Burger burger;

    @Mock
    Ingredient ingredient;

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
    public void moveIngredient() {
    }

    @Test
    public void getPrice() {
    }

    @Test
    public void getReceipt() {
    }
}