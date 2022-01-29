package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunParameterizedTest {

    private final String name;
    private final float price;

    public BunParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][]{
                {"Хруст булочка", 10.99f},
                {"", 1},
                {"Хруст булочка", 0},
                {null, 0},
        };
    }

    @Test
    public void getNameTest() {
        Bun actual = new Bun(name, price);
        assertEquals(name, actual.getName());
    }

    @Test
    public void getPriceTest() {
        Bun actual = new Bun(name, price);
        assertEquals(price, actual.getPrice(), 0.0f);
    }
}