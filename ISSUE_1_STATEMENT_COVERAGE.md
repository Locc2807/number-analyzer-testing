# Issue 1: Viết các ca kiểm thử jUnit để bao phủ tất cả các lệnh (Statement Coverage)

## Mô tả
Cần viết các test case sử dụng JUnit để đạt được 100% statement coverage (bao phủ tất cả các lệnh) cho chương trình NumberAnalyzer.

## Yêu cầu
- Sử dụng JUnit 5
- Viết test cases cho tất cả các phương thức public
- Đảm bảo mọi dòng lệnh trong code đều được thực thi ít nhất một lần
- Sử dụng assertions để kiểm tra kết quả

## Các phương thức cần test
1. `analyzeNumbers(List<Integer> numbers)` - với các trường hợp:
   - Danh sách null
   - Danh sách rỗng
   - Danh sách có số dương, âm, không
   
2. `findMax(List<Integer> numbers)` - với các trường hợp:
   - Danh sách null
   - Danh sách rỗng
   - Danh sách có nhiều số

## Acceptance Criteria
- [ ] Tất cả các dòng code được thực thi
- [ ] Tất cả test cases pass
- [ ] Code coverage report cho thấy 100% statement coverage
