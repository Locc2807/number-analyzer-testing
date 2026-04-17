import java.util.ArrayList;
import java.util.List;

/**
 * Chương trình phân tích danh sách số nguyên
 * Có vòng lặp và lệnh rẽ nhánh
 */
public class NumberAnalyzer {
    
    /**
     * Phân loại các số trong danh sách thành số dương, số âm và số không
     * @param numbers Danh sách các số cần phân tích
     * @return Chuỗi mô tả kết quả phân tích
     */
    public String analyzeNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return "Danh sách rỗng";
        }
        
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        int sum = 0;
        
        // Vòng lặp để duyệt qua các số
        for (Integer num : numbers) {
            sum += num;
            
            // Lệnh rẽ nhánh để phân loại số
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }
        
        double average = (double) sum / numbers.size();
        
        return String.format(
            "Tổng số: %d | Số dương: %d | Số âm: %d | Số không: %d | Tổng: %d | Trung bình: %.2f",
            numbers.size(), positiveCount, negativeCount, zeroCount, sum, average
        );
    }
    
    /**
     * Tìm số lớn nhất trong danh sách
     * @param numbers Danh sách các số
     * @return Số lớn nhất, hoặc null nếu danh sách rỗng
     */
    public Integer findMax(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return null;
        }
        
        Integer max = numbers.get(0);
        
        // Vòng lặp với rẽ nhánh
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
        
        return max;
    }
    
    /**
     * Chương trình chính để demo
     */
    public static void main(String[] args) {
        NumberAnalyzer analyzer = new NumberAnalyzer();
        
        // Tạo danh sách số mẫu
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(-3);
        numbers.add(0);
        numbers.add(12);
        numbers.add(-7);
        numbers.add(8);
        numbers.add(0);
        
        // Phân tích danh sách
        System.out.println("=== PHÂN TÍCH DANH SÁCH SỐ ===");
        System.out.println("Danh sách: " + numbers);
        System.out.println(analyzer.analyzeNumbers(numbers));
        System.out.println("Số lớn nhất: " + analyzer.findMax(numbers));
        
        // Test với danh sách rỗng
        System.out.println("\n=== TEST VỚI DANH SÁCH RỖNG ===");
        List<Integer> emptyList = new ArrayList<>();
        System.out.println(analyzer.analyzeNumbers(emptyList));
        System.out.println("Số lớn nhất: " + analyzer.findMax(emptyList));
    }
}
