import org.example.IntegerSet;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

    @Mock
    private List<Integer> mockList;

    @Test
    public void testSum() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(6, set.sum());
    }

    @Test
    public void testAverage() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(2.0, set.average(), 0.001);
    }

    @Test
    public void testMax() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(5);
        set.add(3);
        assertEquals(5, set.max());
    }

    @Test
    public void testMin() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(5);
        set.add(3);
        assertEquals(1, set.min());
    }
}