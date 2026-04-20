import org.example.IntegerSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
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

    @Test
    public void testWithMockito() {
        // Подготовка (Stubbing): настраиваем поведение мока
        // Когда у мока вызовут метод stream(), вернуть поток с готовыми числами
        when(mockList.stream()).thenReturn(Stream.of(10, 20, 30));

        // Действие: вызываем метод, который использует stream()
        IntegerSet set = new IntegerSet(mockList);
        int result = set.sum();

        // Проверка результата (Assert)
        assertEquals(60, result);

        // Проверка взаимодействия (Verify):
        // Убеждаемся, что метод stream() был вызван ровно один раз
        verify(mockList, times(1)).stream();

        // Убеждаемся, что метод add() НЕ вызывался (так как мы использовали готовый список)
        verify(mockList, never()).add(anyInt());
    }

}