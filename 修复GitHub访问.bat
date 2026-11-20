@echo off
chcp 65001 >nul
setlocal EnableDelayedExpansion
title 修复 GitHub 访问（自动探测可用 IP）

echo ==========================================================
echo   GitHub 访问修复工具
echo   作用：自动测试多个 GitHub 官方 IP，挑一个你这条线路上
echo         能通的，写进 hosts 文件
echo   需要：管理员权限
echo ==========================================================
echo.

net session >nul 2>&1
if errorlevel 1 (
  echo [错误] 当前不是管理员权限。
  echo.
  echo   请关掉本窗口，然后：
  echo   右键这个 .bat 文件  ^>  「以管理员身份运行」
  echo.
  pause
  exit /b 1
)

set "HOSTS=%WINDIR%\System32\drivers\etc\hosts"
set "BAKDIR=E:\DSH工作区\备份"
if not exist "%BAKDIR%" mkdir "%BAKDIR%"
for /f "tokens=2 delims==" %%I in ('wmic os get localdatetime /value') do set DT=%%I
set "STAMP=!DT:~0,8!-!DT:~8,6!"
set "BAK=%BAKDIR%\hosts-backup-!STAMP!.txt"
copy /Y "%HOSTS%" "%BAK%" >nul
echo [1/4] 已备份原 hosts 到：
echo        %BAK%
echo.

echo [2/4] 正在测试 GitHub 官方 IP 连通性（每个最多 6 秒）...
set "GOODIP="
for %%I in (20.205.243.166 140.82.121.3 20.27.177.113 20.200.245.247 20.233.83.145 140.82.112.4) do (
  if not defined GOODIP (
    echo    测试 %%I ...
    curl.exe -s -o NUL --max-time 6 --resolve github.com:443:%%I https://github.com
    if !errorlevel! equ 0 (
      set "GOODIP=%%I"
      echo    ^>^> 可用：%%I
    ) else (
      echo    xx 不通
    )
  )
)

if not defined GOODIP (
  echo.
  echo [失败] 6 个官方 IP 全部不通。
  echo        说明你这条线路被整体阻断，改 hosts 解决不了。
  echo        建议：①先用 Gitee（https://gitee.com）
  echo              ②或装 Watt Toolkit 网络加速（https://steampp.net）
  echo        hosts 未修改，原文件备份在 %BAK%
  echo.
  pause
  exit /b 1
)

echo.
echo [3/4] 把 hosts 里的 github 条目指向 !GOODIP! ...
powershell -NoProfile -ExecutionPolicy Bypass -Command ^
  "$p='%HOSTS%'; $ip='!GOODIP!'; $c=Get-Content -LiteralPath $p -Raw -Encoding UTF8;" ^
  "$c=$c -replace '(?m)^\s*[\d\.]+\s+www\.github\.com\s*$', \"$ip www.github.com\";" ^
  "$c=$c -replace '(?m)^\s*[\d\.]+\s+github\.com\s*$', \"$ip github.com\";" ^
  "if($c -notmatch '(?m)^\s*[\d\.]+\s+github\.com\s*$'){ $c = $c.TrimEnd() + \"`r`n$ip github.com`r`n$ip www.github.com`r`n\" }" ^
  "[System.IO.File]::WriteAllText($p,$c,(New-Object System.Text.UTF8Encoding($false)))"

ipconfig /flushdns >nul
echo [4/4] DNS 缓存已清空
echo.
echo ==========================================================
echo   完成！现在关掉浏览器（重要，浏览器有自己的DNS缓存），
echo   重新打开 https://github.com 试试。
echo.
echo   如果还是不行，用下面这条命令把 hosts 还原：
echo     copy /Y "%BAK%" "%HOSTS%"
echo ==========================================================
echo.
pause
