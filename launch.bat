@echo off

if exist ".\jdk17\bin\java.exe" (
  goto LAUNCH
)

: DOWNLOAD_JAVA
if exist ".\jdk17\" (
  @rmdir /S /Q ".\jdk17"
)

echo Downloading java...
powershell -Command "$ProgressPreference = 'SilentlyContinue'; Invoke-WebRequest -Uri 'https://corretto.aws/downloads/resources/17.0.7.7.1/amazon-corretto-17.0.7.7.1-windows-x64-jdk.zip' -OutFile '.\jdk.zip'"

echo Extracting java...
powershell Expand-Archive ".\jdk.zip" -DestinationPath "."

echo Cleaning up...
move ".\jdk17.0.7_7" ".\jdk17"
del ".\jdk.zip"

: LAUNCH
".\jdk17\bin\java" -Djoml.fastmath -Djoml.sinLookup -Djoml.useMathFma -cp "goldensun-@version@.jar;libs/*" org.goldensun.MainWindows -Xmx2G -ea || pause
