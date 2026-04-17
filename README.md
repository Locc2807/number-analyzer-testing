# Number Analyzer - Testing Project

[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://www.oracle.com/java/)
[![Tests](https://img.shields.io/badge/Tests-42%20passed-brightgreen.svg)](.)
[![Coverage](https://img.shields.io/badge/Coverage-100%25-brightgreen.svg)](.)

Chương trình Java phân tích danh sách số nguyên với đầy đủ test coverage (Statement và Path Coverage).

## 🎯 Tính năng

### Chương trình chính (NumberAnalyzer.java)
- **Phân loại số**: Đếm số dương, số âm, số không
- **Thống kê**: Tính tổng và trung bình
- **Tìm kiếm**: Tìm số lớn nhất trong danh sách

### Cấu trúc code
- ✅ **Vòng lặp**: Duyệt qua danh sách số
- ✅ **Lệnh rẽ nhánh**: Phân loại số (dương/âm/không)
- ✅ **100% Statement Coverage**: 17 test cases
- ✅ **100% Path Coverage**: 25 test cases

## 🚀 Cách chạy

### Chạy chương trình chính:
```bash
javac src/main/java/NumberAnalyzer.java
java -cp src/main/java NumberAnalyzer
```

### Chạy Statement Coverage Tests (Issue #1):
```bash
javac -cp ".;src/main/java" SimpleTestRunner.java
java -cp ".;src/main/java" SimpleTestRunner
```

### Chạy Path Coverage Tests (Issue #2):
```bash
javac -cp ".;src/main/java" PathCoverageTestRunner.java
java -cp ".;src/main/java" PathCoverageTestRunner
```

## 📊 Kết quả Testing

| Test Suite | Test Cases | Pass Rate | Coverage |
|------------|-----------|-----------|----------|
| Statement Coverage | 17 | 100% ✓ | All statements |
| Path Coverage | 25 | 100% ✓ | All paths |
| **Total** | **42** | **100%** | **Complete** |

## 📁 Cấu trúc Project

```
number-analyzer-testing/
├── src/
│   ├── main/java/
│   │   └── NumberAnalyzer.java              # Chương trình chính
│   └── test/java/
│       └── NumberAnalyzerStatementTest.java # JUnit tests
├── SimpleTestRunner.java                    # Statement Coverage tests
├── PathCoverageTestRunner.java              # Path Coverage tests
├── README.md                                # File này
├── PROJECT_SUMMARY.md                       # Tóm tắt chi tiết
├── GITHUB_SETUP.md                          # Hướng dẫn GitHub
└── pom.xml                                  # Maven config
```

## 📝 Issues và Commits

### Issue #1: Statement Coverage
- **Commit**: `c510d8b`
- **Mô tả**: Viết các ca kiểm thử jUnit để bao phủ tất cả các lệnh
- **Kết quả**: 17 test cases, 100% pass

### Issue #2: Path Coverage
- **Commit**: `5811c45`
- **Mô tả**: Viết các ca kiểm thử jUnit để bao phủ tất cả các đường đi
- **Kết quả**: 25 test cases, 100% pass

## 📚 Tài liệu

- [PROJECT_SUMMARY.md](PROJECT_SUMMARY.md) - Tóm tắt chi tiết dự án
- [GITHUB_SETUP.md](GITHUB_SETUP.md) - Hướng dẫn push lên GitHub
- [ISSUE_1_STATEMENT_COVERAGE.md](ISSUE_1_STATEMENT_COVERAGE.md) - Mô tả Issue 1
- [ISSUE_2_PATH_COVERAGE.md](ISSUE_2_PATH_COVERAGE.md) - Mô tả Issue 2

## 🔄 Lịch sử Commits

1. `38bff61` - Initial commit với chương trình có vòng lặp và rẽ nhánh
2. `cb062b7` - Thêm mô tả cho 2 issues
3. `c510d8b` - ✅ Giải quyết Issue #1: Statement Coverage
4. `5811c45` - ✅ Giải quyết Issue #2: Path Coverage
5. `f17f127` - Thêm hướng dẫn GitHub
6. `bc58cf1` - Thêm tóm tắt dự án

## 🎓 Mục đích học tập

Dự án này được tạo để thực hành:
- Viết code Java với vòng lặp và rẽ nhánh
- Viết test cases với JUnit
- Đạt Statement Coverage (bao phủ tất cả lệnh)
- Đạt Path Coverage (bao phủ tất cả đường đi)
- Sử dụng Git và GitHub
- Quản lý Issues và Commits

## 👨‍💻 Tác giả

Dự án được tạo bởi Kiro AI Assistant cho mục đích học tập.

---

**Ngày tạo**: 17/04/2026  
**Tổng commits**: 6  
**Tổng tests**: 42  
**Success rate**: 100% ✓
