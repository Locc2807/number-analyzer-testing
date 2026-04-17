@echo off
echo Compiling source code...
javac -d bin src/main/java/NumberAnalyzer.java

echo.
echo Downloading JUnit if needed...
if not exist "lib" mkdir lib
if not exist "lib/junit-platform-console-standalone-1.9.3.jar" (
    echo Please download junit-platform-console-standalone-1.9.3.jar to lib/ folder
    echo Download from: https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.9.3/junit-platform-console-standalone-1.9.3.jar
    pause
)

echo.
echo Compiling test code...
javac -cp "lib/junit-platform-console-standalone-1.9.3.jar;bin" -d bin src/test/java/NumberAnalyzerStatementTest.java

echo.
echo Running tests...
java -jar lib/junit-platform-console-standalone-1.9.3.jar --class-path bin --scan-class-path

pause
