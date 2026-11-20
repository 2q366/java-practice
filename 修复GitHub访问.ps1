# 修复 GitHub 访问 —— 自动探测可用 IP 并写入 hosts
# 需要管理员权限。本脚本会先备份原 hosts。
$ErrorActionPreference = 'Stop'
$HostsPath = Join-Path $env:WINDIR 'System32\drivers\etc\hosts'
$BakDir    = 'E:\DSH工作区\备份'
$Candidates = @('20.205.243.166','140.82.121.3','20.27.177.113','20.200.245.247','20.233.83.145','140.82.112.4')

$id = [Security.Principal.WindowsIdentity]::GetCurrent()
$principal = New-Object Security.Principal.WindowsPrincipal($id)
if (-not $principal.IsInRole([Security.Principal.WindowsBuiltInRole]::Administrator)) {
    Write-Host '[错误] 请右键 -> 以管理员身份运行。' -ForegroundColor Red
    Read-Host '按回车退出'
    exit 1
}

if (-not (Test-Path $BakDir)) { New-Item -ItemType Directory -Path $BakDir -Force | Out-Null }
$stamp = Get-Date -Format 'yyyyMMdd-HHmmss'
$bak   = Join-Path $BakDir "hosts-backup-$stamp.txt"
Copy-Item -LiteralPath $HostsPath -Destination $bak -Force
Write-Host "[1/3] 已备份原 hosts -> $bak" -ForegroundColor Green

Write-Host '[2/3] 测试可用 IP ...'
$goodIp = $null
foreach ($ip in $Candidates) {
    $code = & curl.exe -s -o NUL --max-time 6 --resolve "github.com:443:$ip" -w '%{http_code}' https://github.com 2>$null
    if ($code -eq '200') {
        $goodIp = $ip
        Write-Host "    OK  $ip" -ForegroundColor Green
        break
    } else {
        Write-Host "    不通 $ip (code=$code)" -ForegroundColor DarkGray
    }
}

if (-not $goodIp) {
    Write-Host '[失败] 所有候选 IP 都不通，改 hosts 无效。' -ForegroundColor Red
    Write-Host '  建议：1) 用 Gitee https://gitee.com   2) 装 Watt Toolkit https://steampp.net' -ForegroundColor Yellow
    Write-Host "  hosts 未改动，备份在 $bak"
    Read-Host '按回车退出'
    exit 1
}

Write-Host "[3/3] 写入 hosts -> github.com = $goodIp"
$kept = New-Object System.Collections.Generic.List[string]
foreach ($line in (Get-Content -LiteralPath $HostsPath -Encoding UTF8)) {
    if ($line -match 'github\.com') { continue }
    $kept.Add($line)
}
while ($kept.Count -gt 0 -and $kept[$kept.Count - 1].Trim() -eq '') {
    $kept.RemoveAt($kept.Count - 1)
}
$kept.Add("$goodIp github.com")
$kept.Add("$goodIp www.github.com")
$out = [string]::Join("`r`n", $kept.ToArray()) + "`r`n"
try {
    [System.IO.File]::WriteAllText($HostsPath, $out, (New-Object System.Text.UTF8Encoding($false)))
    Write-Host '    写入成功' -ForegroundColor Green
} catch {
    Write-Host "[失败] 写入被拒：$($_.Exception.Message)" -ForegroundColor Red
    Write-Host '  请确认是以管理员身份运行的。'
    Read-Host '按回车退出'
    exit 1
}

& ipconfig /flushdns | Out-Null
Write-Host '[完成] DNS 缓存已清空。' -ForegroundColor Green
Write-Host ''
Write-Host '重要：请完全关闭浏览器再打开（浏览器有自己的 DNS 缓存），然后访问 https://github.com' -ForegroundColor Yellow
Write-Host ''
Write-Host '还原命令：' -ForegroundColor Cyan
Write-Host "    copy /Y `"$bak`" `"$HostsPath`""
Write-Host ''
Read-Host '按回车退出'
