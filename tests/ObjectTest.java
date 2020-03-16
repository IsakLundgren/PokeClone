import static org.junit.Assert.*;

import org.junit.Test;

public class ObjectTest {

    @Test
    public void testInspect(){
        Object grass = new Object("grass", new Pokemon[]{new Pokemon("2002 honda civic", 1, PokemonType.Black, 100)}, 50);
        assertEquals(grass.inspect(), null);
    }
}
