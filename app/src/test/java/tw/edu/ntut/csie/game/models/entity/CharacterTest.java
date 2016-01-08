package tw.edu.ntut.csie.game.models.entity;

import junit.framework.TestCase;

public class CharacterTest extends TestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void test(){
        Character c = new Character();
        assert(c.testReturnTrue());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
