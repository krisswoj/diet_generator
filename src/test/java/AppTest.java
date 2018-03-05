import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

public class AppTest
{
    @Test
    public void testCreateObject()
    {
        App app = new App("Lux-Fantasic","Ultra-szczupak",250,4,2017);
        assertNotNull(app);
    }
}