import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HeroTest.
 *
 * @author  Michael Cummings
 * @version 3.21.2023
 */
public class HeroTest
{
    /**
     * Default constructor for test class HeroTest
     */
    public HeroTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testHeroBasicConstructorMaxHealthEqual100()
    {
        Hero hero1 = new Hero();
        assertEquals(100, hero1.getMaxHealthPoints());
    }

    @Test
    public void testHeroBasicConstructorMaxStaminaEqual50()
    {
        Hero hero1 = new Hero();
        assertEquals(50, hero1.getMaxStaminaPoints());
    }

    @Test
    public void testHeroBasicConstructorMaxMagicEqual0()
    {
        Hero hero1 = new Hero();
        assertEquals(0, hero1.getMaxMagicPoints());
    }

    @Test
    public void testHeroUserConstructorAssertEmptyNameThrowsException()
    {
        assertThrows(IllegalArgumentException.class, () -> {Hero hero1 = new Hero("", "Human", 18, 160.0, 177.8);});
    }

    @Test
    public void testHeroUserConstructorAssertEmptySpeciesNameThrowsException()
    {
        assertThrows(IllegalArgumentException.class, () -> {Hero hero1 = new Hero("Keith", "", 18, 160.0, 177.8);});
    }

    @Test
    public void testHeroUserConstructorAssertUnderageThrowsException()
    {
        assertThrows(IllegalArgumentException.class, () -> {Hero hero1 = new Hero("Little Timmy", "Human", 3, 30.0, 60.0);});
    }
    
    @Test
    public void testSetLevelAssertLessThanOneThrowsException()
    {
        Hero hero1 = new Hero();
        assertThrows(IllegalArgumentException.class, () -> {hero1.setLevel(-1);});
    }
}






