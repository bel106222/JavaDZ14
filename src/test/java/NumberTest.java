import org.example.Number;
import org.example.NumberConversionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NumberTest {
    //DEC: 255, OCT: 377, HEX: FF, BIN: 11111111
    @Test
    void testConvertService() {
        // 1. Создаем мок сервиса
        NumberConversionService mockService = Mockito.mock(NumberConversionService.class);

        // 2. Определяем поведение мока (что он должен вернуть при вызове)
        when(mockService.toOct(255)).thenReturn("377");
        when(mockService.toHex(255)).thenReturn("FF");
        when(mockService.toBin(255)).thenReturn("11111111");

        // 3. Создаем объект Number, передавая ему мок вместо реальной реализации
        Number number = new Number(255, mockService);

        // 4. Проверяем результат работы класса Number (интеграционный тест)
        assertEquals("DEC: 255, OCT: 377, HEX: FF, BIN: 11111111", number.toString());

        // 5. Проверяем, что методы сервиса были вызваны ровно один раз с нужным аргументом (поведенческий тест)
        verify(mockService, times(1)).toOct(255);
        verify(mockService, times(1)).toHex(255);
        verify(mockService, times(1)).toBin(255);

        // Проверяем, что других вызовов не было
        verifyNoMoreInteractions(mockService);
    }
}