@echo off
chcp 65001 >nul
title 一键推送（GitHub + Gitee）
cd /d "E:\DSH工作区\Java练习"
set "PATH=E:\Git\bin;%PATH%"

echo ============================================
echo   一键推送：提交 + 推到 GitHub + 推到 Gitee
echo ============================================
echo.

set "MSG=%~1"
if not "%MSG%"=="" goto have_msg
set /p MSG=请输入这次的提交说明（比如「学了数组」）:
:have_msg
if "%MSG%"=="" set "MSG=日常更新"

echo.
echo [1/3] 收集改动...
git add -A

echo [2/3] 本地提交...
git commit -m "%MSG%"

echo [3/3] 推送...
git push origin main
git push gitee main

echo.
echo ============================================
echo   完成。两个平台都已更新。
echo   GitHub: https://github.com/2q366/java-practice
echo   Gitee : https://gitee.com/a2_39056/java-practice
echo ============================================
echo.
pause
