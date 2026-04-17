# Hướng dẫn đưa project lên GitHub

## Bước 1: Tạo repository trên GitHub

1. Truy cập https://github.com
2. Đăng nhập vào tài khoản của bạn
3. Click nút "+" ở góc trên bên phải, chọn "New repository"
4. Điền thông tin:
   - Repository name: `number-analyzer-testing` (hoặc tên bạn muốn)
   - Description: `Java program with loops and conditionals, including JUnit tests for statement and path coverage`
   - Chọn "Public" hoặc "Private"
   - **KHÔNG** chọn "Initialize this repository with a README" (vì chúng ta đã có code)
5. Click "Create repository"

## Bước 2: Push code lên GitHub

Sau khi tạo repository, GitHub sẽ hiển thị hướng dẫn. Sử dụng các lệnh sau:

```bash
# Thêm remote repository
git remote add origin https://github.com/YOUR_USERNAME/number-analyzer-testing.git

# Đổi tên branch thành main (nếu cần)
git branch -M main

# Push code lên GitHub
git push -u origin main
```

**Lưu ý:** Thay `YOUR_USERNAME` bằng username GitHub của bạn.

## Bước 3: Tạo Issues trên GitHub

Sau khi push code, tạo 2 issues:

### Issue 1: Statement Coverage
1. Vào tab "Issues" trên GitHub repository
2. Click "New issue"
3. Title: `Viết các ca kiểm thử jUnit để bao phủ tất cả các lệnh`
4. Description: Copy nội dung từ file `ISSUE_1_STATEMENT_COVERAGE.md`
5. Click "Submit new issue"
6. **Đóng issue này** vì đã được giải quyết trong commit `c510d8b`

### Issue 2: Path Coverage
1. Click "New issue"
2. Title: `Viết các ca kiểm thử jUnit để bao phủ tất cả các đường đi`
3. Description: Copy nội dung từ file `ISSUE_2_PATH_COVERAGE.md`
4. Click "Submit new issue"
5. **Đóng issue này** vì đã được giải quyết trong commit `5811c45`

## Bước 4: Liên kết Commits với Issues (Optional)

Nếu bạn muốn liên kết commits với issues, bạn có thể:
1. Vào mỗi issue
2. Comment với nội dung: `Fixed in commit c510d8b` (cho Issue 1) hoặc `Fixed in commit 5811c45` (cho Issue 2)
3. Đóng issue

## Cấu trúc Project

```
number-analyzer-testing/
├── src/
│   ├── main/java/
│   │   └── NumberAnalyzer.java          # Chương trình chính
│   └── test/java/
│       └── NumberAnalyzerStatementTest.java  # JUnit tests
├── SimpleTestRunner.java                # Statement Coverage tests
├── PathCoverageTestRunner.java          # Path Coverage tests
├── pom.xml                              # Maven configuration
├── README.md                            # Project documentation
├── ISSUE_1_STATEMENT_COVERAGE.md        # Issue 1 description
├── ISSUE_2_PATH_COVERAGE.md             # Issue 2 description
└── .gitignore                           # Git ignore rules
```

## Lịch sử Commits

1. `38bff61` - Initial commit: Add NumberAnalyzer program with loops and conditionals
2. `cb062b7` - Add issue descriptions for test coverage tasks
3. `c510d8b` - Resolve Issue #1: Add JUnit tests for Statement Coverage
4. `5811c45` - Resolve Issue #2: Add JUnit tests for Path Coverage

## Chạy Tests

### Statement Coverage Tests:
```bash
javac -cp ".;src/main/java" SimpleTestRunner.java
java -cp ".;src/main/java" SimpleTestRunner
```

### Path Coverage Tests:
```bash
javac -cp ".;src/main/java" PathCoverageTestRunner.java
java -cp ".;src/main/java" PathCoverageTestRunner
```

## Kết quả

- ✓ Statement Coverage: 17 test cases, 100% pass
- ✓ Path Coverage: 25 test cases, 100% pass
- ✓ Tất cả các lệnh được bao phủ
- ✓ Tất cả các đường đi được bao phủ
