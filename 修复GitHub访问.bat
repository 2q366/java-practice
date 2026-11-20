@echo off
chcp 65001 >nul
title 修复 GitHub 访问（自动探测可用 IP）

echo ==========================================================
echo   GitHub 访问修复工具
echo ==========================================================
echo.
echo 这个窗口会请求管理员权限，弹出 UAC 对话框时请点「是」。
echo.

net session >nul 2>&1
if errorlevel 1 (
  echo 正在请求管理员权限...
  powershell -NoProfile -Command "Start-Process -FilePath 'powershell.exe' -ArgumentList '-NoProfile','-ExecutionPolicy','Bypass','-File','\"%~dp0修复GitHub访问.ps1\"' -Verb RunAs"
  exit /b 0
)

powershell -NoProfile -ExecutionPolicy Bypass -File "%~dp0修复GitHub访问.ps1"
