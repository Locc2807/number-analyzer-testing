import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test runner để kiểm tra Path Coverage (bao phủ tất cả các đường đi)
 * Đảm bảo tất cả các nhánh và combinations của điều kiện được test
 */
public class PathCoverageTestRunner {
    
    private static int totalTests = 0;
    private static int passedTests = 0;
    private static int failedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("CHẠY TESTS CHO PATH COVERAGE (ISSUE 2)");
        System.out.println("=".repeat(60));
        
        NumberAnalyzer analyzer = new NumberAnalyzer();
        
        // Tests cho analyzeNumbers - tất cả các đường đi
        System.out.println("\n--- Path Coverage Tests cho analyzeNumbers() ---");
        testPath_AnalyzeNumbers_NullInput(analyzer);
        testPath_AnalyzeNumbers_EmptyList(analyzer);
        testPath_AnalyzeNumbers_OnlyPositive(analyzer);
        testPath_AnalyzeNumbers_OnlyNegative(analyzer);
        testPath_AnalyzeNumbers_OnlyZero(analyzer);
        testPath_AnalyzeNumbers_PositiveAndNegative(analyzer);
        testPath_AnalyzeNumbers_PositiveAndZero(analyzer);
        testPath_AnalyzeNumbers_NegativeAndZero(analyzer);
        testPath_AnalyzeNumbers_AllThreeTypes(analyzer);
        testPath_AnalyzeNumbers_SinglePositive(analyzer);
        testPath_AnalyzeNumbers_SingleNegative(analyzer);
        testPath_AnalyzeNumbers_SingleZero(analyzer);
        
        // Tests cho findMax - tất cả các đường đi
        System.out.println("\n--- Path Coverage Tests cho findMax() ---");
        testPath_FindMax_NullInput(analyzer);
        testPath_FindMax_EmptyList(analyzer);
        testPath_FindMax_SingleElement(analyzer);
        testPath_FindMax_TwoElements_FirstLarger(analyzer);
        testPath_FindMax_TwoElements_SecondLarger(analyzer);
        testPath_FindMax_TwoElements_Equal(analyzer);
        testPath_FindMax_MaxAtBeginning(analyzer);
        testPath_FindMax_MaxAtMiddle(analyzer);
        testPath_FindMax_MaxAtEnd(analyzer);
        testPath_FindMax_AllEqual(analyzer);
        testPath_FindMax_AllNegative(analyzer);
        testPath_FindMax_MixedWithZero(analyzer);
        testPath_FindMax_LargeList(analyzer);
        
        // Tổng kết
        System.out.println("\n" + "=".repeat(60));
        System.out.println("KẾT QUẢ PATH COVERAGE TESTS");
        System.out.println("=".repeat(60));
        System.out.println("Tổng số tests: " + totalTests);
        System.out.println("Passed: " + passedTests + " ✓");
        System.out.println("Failed: " + failedTests + " ✗");
        System.out.println("Success rate: " + (passedTests * 100 / totalTests) + "%");
        
        if (failedTests == 0) {
            System.out.println("\n✓ TẤT CẢ TESTS ĐỀU PASS!");
            System.out.println("✓ ĐÃ ĐẠT PATH COVERAGE!");
            System.out.println("✓ TẤT CẢ CÁC ĐƯỜNG ĐI ĐÃ ĐƯỢC BAO PHỦ!");
        }
    }
    
    // Helper methods
    private static void assertTrue(String testName, boolean condition, String message) {
        totalTests++;
        if (condition) {
            passedTests++;
            System.out.println("  ✓ " + testName);
        } else {
            failedTests++;
            System.out.println("  ✗ " + testName + " - FAILED: " + message);
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
    
    // ===== Path Coverage Tests cho analyzeNumbers =====
    
    // Path 1: null input
    private static void testPath_AnalyzeNumbers_NullInput(NumberAnalyzer analyzer) {
        String result = analyzer.analyzeNumbers(null);
        assertEquals("Path 1: null input returns 'Danh sách rỗng'", "Danh sách rỗng", result);
    }
    
    // Path 2: empty list
    private static void testPath_AnalyzeNumbers_EmptyList(NumberAnalyzer analyzer) {
        List<Integer> list = new ArrayList<>();
        String result = analyzer.analyzeNumbers(list);
        assertEquals("Path 2: empty list returns 'Danh sách rỗng'", "Danh sách rỗng", result);
    }
    
    // Path 3: chỉ số dương (vòng lặp với num > 0)
    private static void testPath_AnalyzeNumbers_OnlyPositive(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        String result = analyzer.analyzeNumbers(list);
        assertTrue("Path 3: only positive numbers", 
                   result.contains("Số dương: 5") && result.contains("Số âm: 0") && result.contains("Số không: 0"),
                   "Should have 5 positive, 0 negative, 0 zero");
    }
    
    // Path 4: chỉ số âm (vòng lặp với num < 0)
    private static void testPath_AnalyzeNumbers_OnlyNegative(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(-1, -2, -3, -4);
        String result = analyzer.analyzeNumbers(list);
        assertTrue("Path 4: only negative numbers", 
                   result.contains("Số dương: 0") && result.contains("Số âm: 4") && result.contains("Số không: 0"),
                   "Should have 0 positive, 4 negative, 0 zero");
    }
    
    // Path 5: chỉ số không (vòng lặp với num == 0)
    private static void testPath_AnalyzeNumbers_OnlyZero(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(0, 0, 0);
        String result = analyzer.analyzeNumbers(list);
        assertTrue("Path 5: only zeros", 
                   result.contains("Số dương: 0") && result.contains("Số âm: 0") && result.contains("Số không: 3"),
                   "Should have 0 positive, 0 negative, 3 zero");
    }
    
    // Path 6: số dương và số âm
    private static void testPath_AnalyzeNumbers_PositiveAndNegative(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(5, -3, 10, -7);
        String result = analyzer.analyzeNumbers(list);
        assertTrue("Path 6: positive and negative numbers", 
                   result.contains("Số dương: 2") && result.contains("Số âm: 2") && result.contains("Số không: 0"),
                   "Should have 2 positive, 2 negative, 0 zero");
    }
    
    // Path 7: số dương và số không
    private static void testPath_AnalyzeNumbers_PositiveAndZero(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(5, 0, 10, 0);
        String result = analyzer.analyzeNumbers(list);
        assertTrue("Path 7: positive and zero", 
                   result.contains("Số dương: 2") && result.contains("Số âm: 0") && result.contains("Số không: 2"),
                   "Should have 2 positive, 0 negative, 2 zero");
    }
    
    // Path 8: số âm và số không
    private static void testPath_AnalyzeNumbers_NegativeAndZero(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(-5, 0, -10, 0);
        String result = analyzer.analyzeNumbers(list);
        assertTrue("Path 8: negative and zero", 
                   result.contains("Số dương: 0") && result.contains("Số âm: 2") && result.contains("Số không: 2"),
                   "Should have 0 positive, 2 negative, 2 zero");
    }
    
    // Path 9: cả 3 loại số
    private static void testPath_AnalyzeNumbers_AllThreeTypes(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(5, -3, 0, 12, -7, 8, 0);
        String result = analyzer.analyzeNumbers(list);
        assertTrue("Path 9: all three types of numbers", 
                   result.contains("Số dương: 3") && result.contains("Số âm: 2") && result.contains("Số không: 2"),
                   "Should have 3 positive, 2 negative, 2 zero");
    }
    
    // Path 10: một số dương
    private static void testPath_AnalyzeNumbers_SinglePositive(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(42);
        String result = analyzer.analyzeNumbers(list);
        assertTrue("Path 10: single positive number", 
                   result.contains("Số dương: 1") && result.contains("Tổng: 42"),
                   "Should have 1 positive, sum 42");
    }
    
    // Path 11: một số âm
    private static void testPath_AnalyzeNumbers_SingleNegative(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(-42);
        String result = analyzer.analyzeNumbers(list);
        assertTrue("Path 11: single negative number", 
                   result.contains("Số âm: 1") && result.contains("Tổng: -42"),
                   "Should have 1 negative, sum -42");
    }
    
    // Path 12: một số không
    private static void testPath_AnalyzeNumbers_SingleZero(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(0);
        String result = analyzer.analyzeNumbers(list);
        assertTrue("Path 12: single zero", 
                   result.contains("Số không: 1") && result.contains("Tổng: 0"),
                   "Should have 1 zero, sum 0");
    }
    
    // ===== Path Coverage Tests cho findMax =====
    
    // Path 1: null input
    private static void testPath_FindMax_NullInput(NumberAnalyzer analyzer) {
        Integer result = analyzer.findMax(null);
        assertEquals("Path 1: null input returns null", null, result);
    }
    
    // Path 2: empty list
    private static void testPath_FindMax_EmptyList(NumberAnalyzer analyzer) {
        List<Integer> list = new ArrayList<>();
        Integer result = analyzer.findMax(list);
        assertEquals("Path 2: empty list returns null", null, result);
    }
    
    // Path 3: một phần tử (không vào vòng lặp)
    private static void testPath_FindMax_SingleElement(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(42);
        Integer result = analyzer.findMax(list);
        assertEquals("Path 3: single element", 42, result);
    }
    
    // Path 4: hai phần tử, phần tử đầu lớn hơn (vào vòng lặp, không update max)
    private static void testPath_FindMax_TwoElements_FirstLarger(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(10, 5);
        Integer result = analyzer.findMax(list);
        assertEquals("Path 4: two elements, first larger", 10, result);
    }
    
    // Path 5: hai phần tử, phần tử thứ hai lớn hơn (vào vòng lặp, update max)
    private static void testPath_FindMax_TwoElements_SecondLarger(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(5, 10);
        Integer result = analyzer.findMax(list);
        assertEquals("Path 5: two elements, second larger", 10, result);
    }
    
    // Path 6: hai phần tử bằng nhau
    private static void testPath_FindMax_TwoElements_Equal(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(7, 7);
        Integer result = analyzer.findMax(list);
        assertEquals("Path 6: two equal elements", 7, result);
    }
    
    // Path 7: max ở đầu danh sách
    private static void testPath_FindMax_MaxAtBeginning(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(100, 50, 30, 10);
        Integer result = analyzer.findMax(list);
        assertEquals("Path 7: max at beginning", 100, result);
    }
    
    // Path 8: max ở giữa danh sách
    private static void testPath_FindMax_MaxAtMiddle(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(10, 50, 100, 30, 20);
        Integer result = analyzer.findMax(list);
        assertEquals("Path 8: max at middle", 100, result);
    }
    
    // Path 9: max ở cuối danh sách
    private static void testPath_FindMax_MaxAtEnd(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(10, 30, 50, 100);
        Integer result = analyzer.findMax(list);
        assertEquals("Path 9: max at end", 100, result);
    }
    
    // Path 10: tất cả phần tử bằng nhau
    private static void testPath_FindMax_AllEqual(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(7, 7, 7, 7, 7);
        Integer result = analyzer.findMax(list);
        assertEquals("Path 10: all equal elements", 7, result);
    }
    
    // Path 11: tất cả số âm
    private static void testPath_FindMax_AllNegative(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(-10, -5, -20, -3);
        Integer result = analyzer.findMax(list);
        assertEquals("Path 11: all negative numbers", -3, result);
    }
    
    // Path 12: mix với số không
    private static void testPath_FindMax_MixedWithZero(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(-5, 0, 3, -2);
        Integer result = analyzer.findMax(list);
        assertEquals("Path 12: mixed with zero", 3, result);
    }
    
    // Path 13: danh sách lớn
    private static void testPath_FindMax_LargeList(NumberAnalyzer analyzer) {
        List<Integer> list = Arrays.asList(1, 5, 3, 9, 2, 8, 4, 7, 6, 10);
        Integer result = analyzer.findMax(list);
        assertEquals("Path 13: large list", 10, result);
    }
}
