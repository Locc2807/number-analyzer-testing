# Issue 2: Viết các ca kiểm thử jUnit để bao phủ tất cả các đường đi (Path Coverage)

## Mô tả
Cần viết các test case sử dụng JUnit để đạt được 100% path coverage (bao phủ tất cả các đường đi) cho chương trình NumberAnalyzer.

## Yêu cầu
- Sử dụng JUnit 5
- Viết test cases để cover tất cả các đường đi có thể trong control flow
- Mỗi combination của các điều kiện rẽ nhánh cần được test
- Đảm bảo tất cả các nhánh if-else được test đầy đủ

## Các đường đi cần cover

### Phương thức `analyzeNumbers`:
1. Path 1: numbers == null → return "Danh sách rỗng"
2. Path 2: numbers.isEmpty() → return "Danh sách rỗng"
3. Path 3: Vòng lặp với num > 0 (chỉ số dương)
4. Path 4: Vòng lặp với num < 0 (chỉ số âm)
5. Path 5: Vòng lặp với num == 0 (chỉ số không)
6. Path 6: Vòng lặp với mix của cả 3 loại số

### Phương thức `findMax`:
1. Path 1: numbers == null → return null
2. Path 2: numbers.isEmpty() → return null
3. Path 3: Một phần tử
4. Path 4: Nhiều phần tử, max ở đầu
5. Path 5: Nhiều phần tử, max ở giữa
6. Path 6: Nhiều phần tử, max ở cuối
7. Path 7: Tất cả phần tử bằng nhau

## Acceptance Criteria
- [ ] Tất cả các đường đi trong control flow được test
- [ ] Tất cả các nhánh if-else được cover
- [ ] Tất cả test cases pass
- [ ] Code coverage report cho thấy 100% branch coverage
