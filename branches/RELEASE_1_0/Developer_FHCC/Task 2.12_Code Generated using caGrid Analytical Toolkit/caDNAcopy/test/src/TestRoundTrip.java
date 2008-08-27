import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class TestRoundTrip {
    
    @Test
    public void testRoundTrip() throws Exception {
	assertTrue(1==1);
    }

    @Test
    public void testFails() throws Exception {
	assertTrue(1==0);
    }
}

