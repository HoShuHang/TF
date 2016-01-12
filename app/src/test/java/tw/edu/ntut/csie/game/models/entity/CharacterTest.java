package tw.edu.ntut.csie.game.models.entity;

import junit.framework.TestCase;

import java.lang.reflect.Field;

public class CharacterTest extends TestCase {
    private final int MAP_WIDTH = 2400;
    private final int CHARACTER_WIDTH = 80;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void test(){
        Character c = new Character();
        assertTrue(c.testReturnTrue());
    }

    public void testGetLocation(){
        Character c = new Character();
        assertTrue(c.getLocation() == 0);
        try {
            Field f = Character.class.getDeclaredField("_location");
            f.setAccessible(true);
            f.setInt(c, 20);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        assertTrue(c.getLocation() == 20);
    }

    public void testMoveRight(){
        Character c = new Character();
        assertTrue(c.getLocation() == 0);
        c.move(10);
        assertTrue(c.getLocation() == 10);
        c.move(-20);
        assertTrue(c.getLocation() == 0);
        c.move(2400);
        assertTrue(c.getLocation() == MAP_WIDTH - CHARACTER_WIDTH);
    }

    public void testMoveLeft(){
        Character c = new Character();
        assertTrue(c.getLocation() == 0);
        c.move(-10);
        assertTrue(c.getLocation() == 0);
        c.move(100);
        assertTrue(c.getLocation() == 100);
        c.move(-50);
        assertTrue(c.getLocation() == 50);
        c.move(-60);
        assertTrue(c.getLocation() == 0);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
