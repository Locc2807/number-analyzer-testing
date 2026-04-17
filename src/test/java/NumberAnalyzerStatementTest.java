import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test class để đạt Statement Coverage (bao phủ tất cả các lệnh)
 * cho class NumberAnalyzer
 */
public class NumberAnalyzerStatementTest {
    
    private NumberAnalyzer analyzer;
    
    @BeforeEach
    public void setUp() {
        analyzer = new NumberAnalyzer();
    }
    
    // ===== Tests cho phương thức analyzeNumbers =====
    
    @Test
    public void testAnalyzeNumbers_WithNullList() {
        String result = analyzer.analyzeNumbers(null);
        assertEquals("Danh sách rỗng", result);
    }
    
    @Test
    public void testAnalyzeNumbers_WithEmptyList() {
        List<Integer> emptyList = new ArrayList<>();
        String result = analyzer.analyzeNumbers(emptyList);
        assertEquals("Danh sách rỗng", result);
    }
    
    @Test
    public void testAnalyzeNumbers_WithMixedNumbers() {
        // Test case này sẽ cover tất cả các nhánh: num > 0, num < 0, num == 0
        List<Integer> numbers = Arrays.asList(5, -3, 0, 12, -7, 8, 0);
        String result = analyzer.analyzeNumbers(numbers);
        
        // Kiểm tra kết quả có chứa các thông tin mong đợi
        assertTrue(result.contains("Tổng số: 7"));
        assertTrue(result.contains("Số dương: 3"));
        assertTrue(result.contains("Số âm: 2"));
        assertTrue(result.contains("Số không: 2"));
        assertTrue(result.contains("Tổng: 15"));
    }
    
    @Test
    public void testAnalyzeNumbers_WithOnlyPositiveNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        String result = analyzer.analyzeNumbers(numbers);
        
        assertTrue(result.contains("Số dương: 5"));
        assertTrue(result.contains("Số âm: 0"));
        assertTrue(result.contains("Số không: 0"));
    }
    
    @Test
    public void testAnalyzeNumbers_WithOnlyNegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -2, -3);
        String result = analyzer.analyzeNumbers(numbers);
        
        assertTrue(result.contains("Số dương: 0"));
        assertTrue(result.contains("Số âm: 3"));
        assertTrue(result.contains("Số không: 0"));
    }
    
    @Test
    public void testAnalyzeNumbers_WithOnlyZeros() {
        List<Integer> numbers = Arrays.asList(0, 0, 0);
        String result = analyzer.analyzeNumbers(numbers);
        
        assertTrue(result.contains("Số dương: 0"));
        assertTrue(result.contains("Số âm: 0"));
        assertTrue(result.contains("Số không: 3"));
    }
    
    // ===== Tests cho phương thức findMax =====
    
    @Test
    public void testFindMax_WithNullList() {
        Integer result = analyzer.findMax(null);
        assertNull(result);
    }
    
    @Test
    public void testFindMax_WithEmptyList() {
        List<Integer> emptyList = new ArrayList<>();
        Integer result = analyzer.findMax(emptyList);
        assertNull(result);
    }
    
    @Test
    public void testFindMax_WithSingleElement() {
        List<Integer> numbers = Arrays.asList(42);
        Integer result = analyzer.findMax(numbers);
        assertEquals(42, result);
    }
    
    @Test
    public void testFindMax_WithMultipleElements() {
        List<Integer> numbers = Arrays.asList(5, -3, 0, 12, -7, 8, 0);
        Integer result = analyzer.findMax(numbers);
        assertEquals(12, result);
    }
    
    @Test
    public void testFindMax_WithMaxAtBeginning() {
        List<Integer> numbers = Arrays.asList(100, 5, 3, 1);
        Integer result = analyzer.findMax(numbers);
        assertEquals(100, result);
    }
    
    @Test
    public void testFindMax_WithMaxAtEnd() {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 100);
        Integer result = analyzer.findMax(numbers);
        assertEquals(100, result);
    }
    
    @Test
    public void testFindMax_WithAllNegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-5, -3, -10, -1);
        Integer result = analyzer.findMax(numbers);
        assertEquals(-1, result);
    }
    
    @Test
    public void testFindMax_WithAllEqualNumbers() {
        List<Integer> numbers = Arrays.asList(7, 7, 7, 7);
        Integer result = analyzer.findMax(numbers);
        assertEquals(7, result);
    }
}
