import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Simple test runner để kiểm tra Statement Coverage
 * Không cần JUnit framework
 */
public class SimpleTestRunner {
    
    private static int totalTests = 0;
    private static int passedTests = 0;
    private static int failedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("CHẠY TESTS CHO STATEMENT COVERAGE (ISSUE 1)");
        System.out.println("=".repeat(60));
        
        NumberAnalyzer analyzer = new NumberAnalyzer();
        
        // Tests cho analyzeNumbers
        System.out.println("\n--- Tests cho analyzeNumbers() ---");
        testAnalyzeNumbers_WithNullList(analyzer);
        testAnalyzeNumbers_WithEmptyList(analyzer);
        testAnalyzeNumbers_WithMixedNumbers(analyzer);
        testAnalyzeNumbers_WithOnlyPositiveNumbers(analyzer);
        testAnalyzeNumbers_WithOnlyNegativeNumbers(analyzer);
        testAnalyzeNumbers_WithOnlyZeros(analyzer);
        
        // Tests cho findMax
        System.out.println("\n--- Tests cho findMax() ---");
        testFindMax_WithNullList(analyzer);
        testFindMax_WithEmptyList(analyzer);
        testFindMax_WithSingleElement(analyzer);
        testFindMax_WithMultipleElements(analyzer);
        testFindMax_WithMaxAtBeginning(analyzer);
        testFindMax_WithMaxAtEnd(analyzer);
        testFindMax_WithAllNegativeNumbers(analyzer);
        testFindMax_WithAllEqualNumbers(analyzer);
        
        // Tổng kết
        System.out.println("\n" + "=".repeat(60));
        System.out.println("KẾT QUẢ TESTS");
        System.out.println("=".repeat(60));
        System.out.println("Tổng số tests: " + totalTests);
        System.out.println("Passed: " + passedTests + " ✓");
        System.out.println("Failed: " + failedTests + " ✗");
        System.out.println("Success rate: " + (passedTests * 100 / totalTests) + "%");
        
        if (failedTests == 0) {
            System.out.println("\n✓ TẤT CẢ TESTS ĐỀU PASS!");
            System.out.println("✓ ĐÃ ĐẠT STATEMENT COVERAGE!");
        }
    }
    
    // Helper methods
    private static void assertTrue(String testName, boolean condition) {
        totalTests++;
        if (condition) {
            passedTests++;
            System.out.println("  ✓ " + testName);
        } else {
            failedTests++;
            System.out.println("  ✗ " + testName + " - FAILED");
        }
    }
    
    private static void assertEquals(String testName, Object expected, Object actual) {
        totalTests++;
        if ((expected == null && actual == null) || (expected != null && expected.equals(actual))) {
            passedTests++;
            System.out.println("  ✓ " + testName);
        } else {
            failedTests++;
            System.out.println("  ✗ " + testName + " - FAILED (Expected: " + expected + ", Actual: " + actual + ")");
        }
    }
    
    private static void assertNull(String testName, Object actual) {
        assertEquals(testName, null, actual);
    }
    
    // Test methods
    private static void testAnalyzeNumbers_WithNullList(NumberAnalyzer analyzer) {
        String result = analyzer.analyzeNumbers(null);
        assertEquals("testAnalyzeNumbers_WithNullList", "Danh sách rỗng", result);
    }
    
    private static void testAnalyzeNumbers_WithEmptyList(NumberAnalyzer analyzer) {
        List<Integer> emptyList = new ArrayList<>();
        String result = analyzer.analyzeNumbers(emptyList);
        assertEquals("testAnalyzeNumbers_WithEmptyList", "Danh sách rỗng", result);
    }
    
    private static void testAnalyzeNumbers_WithMixedNumbers(NumberAnalyzer analyzer) {
        List<Integer> numbers = Arrays.asList(5, -3, 0, 12, -7, 8, 0);
        String result = analyzer.analyzeNumbers(numbers);
        assertTrue("testAnalyzeNumbers_WithMixedNumbers - contains 'Tổng số: 7'", result.contains("Tổng số: 7"));
        assertTrue("testAnalyzeNumbers_WithMixedNumbers - contains 'Số dương: 3'", result.contains("Số dương: 3"));
        assertTrue("testAnalyzeNumbers_WithMixedNumbers - contains 'Số âm: 2'", result.contains("Số âm: 2"));
        assertTrue("testAnalyzeNumbers_WithMixedNumbers - contains 'Số không: 2'", result.contains("Số không: 2"));
    }
    
    private static void testAnalyzeNumbers_WithOnlyPositiveNumbers(NumberAnalyzer analyzer) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        String result = analyzer.analyzeNumbers(numbers);
        assertTrue("testAnalyzeNumbers_WithOnlyPositiveNumbers", 
                   result.contains("Số dương: 5") && result.contains("Số âm: 0"));
    }
    
    private static void testAnalyzeNumbers_WithOnlyNegativeNumbers(NumberAnalyzer analyzer) {
        List<Integer> numbers = Arrays.asList(-1, -2, -3);
        String result = analyzer.analyzeNumbers(numbers);
        assertTrue("testAnalyzeNumbers_WithOnlyNegativeNumbers", 
                   result.contains("Số âm: 3") && result.contains("Số dương: 0"));
    }
    
    private static void testAnalyzeNumbers_WithOnlyZeros(NumberAnalyzer analyzer) {
        List<Integer> numbers = Arrays.asList(0, 0, 0);
        String result = analyzer.analyzeNumbers(numbers);
        assertTrue("testAnalyzeNumbers_WithOnlyZeros", 
                   result.contains("Số không: 3") && result.contains("Số dương: 0"));
    }
    
    private static void testFindMax_WithNullList(NumberAnalyzer analyzer) {
        Integer result = analyzer.findMax(null);
        assertNull("testFindMax_WithNullList", result);
    }
    
    private static void testFindMax_WithEmptyList(NumberAnalyzer analyzer) {
        List<Integer> emptyList = new ArrayList<>();
        Integer result = analyzer.findMax(emptyList);
        assertNull("testFindMax_WithEmptyList", result);
    }
    
    private static void testFindMax_WithSingleElement(NumberAnalyzer analyzer) {
        List<Integer> numbers = Arrays.asList(42);
        Integer result = analyzer.findMax(numbers);
        assertEquals("testFindMax_WithSingleElement", 42, result);
    }
    
    private static void testFindMax_WithMultipleElements(NumberAnalyzer analyzer) {
        List<Integer> numbers = Arrays.asList(5, -3, 0, 12, -7, 8, 0);
        Integer result = analyzer.findMax(numbers);
        assertEquals("testFindMax_WithMultipleElements", 12, result);
    }
    
    private static void testFindMax_WithMaxAtBeginning(NumberAnalyzer analyzer) {
        List<Integer> numbers = Arrays.asList(100, 5, 3, 1);
        Integer result = analyzer.findMax(numbers);
        assertEquals("testFindMax_WithMaxAtBeginning", 100, result);
    }
    
    private static void testFindMax_WithMaxAtEnd(NumberAnalyzer analyzer) {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 100);
        Integer result = analyzer.findMax(numbers);
        assertEquals("testFindMax_WithMaxAtEnd", 100, result);
    }
    
    private static void testFindMax_WithAllNegativeNumbers(NumberAnalyzer analyzer) {
        List<Integer> numbers = Arrays.asList(-5, -3, -10, -1);
        Integer result = analyzer.findMax(numbers);
        assertEquals("testFindMax_WithAllNegativeNumbers", -1, result);
    }
    
    private static void testFindMax_WithAllEqualNumbers(NumberAnalyzer analyzer) {
        List<Integer> numbers = Arrays.asList(7, 7, 7, 7);
        Integer result = analyzer.findMax(numbers);
        assertEquals("testFindMax_WithAllEqualNumbers", 7, result);
    }
}
