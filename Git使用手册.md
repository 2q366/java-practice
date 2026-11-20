# Git 使用手册（陈喻涛专用 · 傻瓜版）

> **一句话：以后每天写完全部代码，双击桌面上那个「一键推送.bat」就行了。**
> 这份手册是给「哪天想自己敲命令」和「出错了怎么办」准备的。

---

## ✅ 已经全部配好了（2026-11-20）

| 项目 | 状态 |
|---|---|
| 本地仓库 | `E:\DSH工作区\Java练习`（已 init，已有多次提交） |
| GitHub 仓库 | https://github.com/2q366/java-practice |
| Gitee 仓库 | https://gitee.com/a2_39056/java-practice （私有） |
| SSH 密钥 | 已生成，两个平台都已添加，`ssh -T` 双向验证通过 |
| 本地 / GitHub / Gitee | **三处 commit 完全一致** ✅ |
| 一键推送脚本 | `E:\DSH工作区\Java练习\一键推送.bat`（已验证可用） |

---

## 一、日常就一条路：双击「一键推送.bat」

**做法**：写完代码 → 双击 `一键推送.bat` → 在弹出的黑窗口里输入一句话（比如 `学了数组求和`）→ 回车 → 等它自己跑完。

它会自动做完三件事：
1. `git add -A` 把所有改动装袋
2. `git commit` 封箱
3. 推 GitHub（失败自动重试 3 次）→ 推 Gitee

> 这个 bat 里已经把 `E:\Git\bin` 加进 PATH 了，所以不用管环境变量。

---

## 二、想自己敲命令（三步走）

打开 PowerShell，先 `cd E:\DSH工作区\Java练习`：

```powershell
git add -A                          # 装袋：把所有改动放进待提交区
git commit -m "今天学了数组求和"      # 封箱：写一句话说明这次改了啥
git push origin main                # 寄出：推到 GitHub
git push gitee main                 # （可选）再推到 Gitee 备份
```

**口诀：add → commit → push。** 装袋 → 封口 → 寄出。

⚠️ 注意：`git` 不在默认 PATH 里。自己敲命令前先执行一次：
```powershell
$env:Path = "E:\Git\bin;" + $env:Path
```
（双击 bat 的话不需要，bat 里已经处理了。）

---

## 三、只想看看自己改了什么（不改任何东西）

```powershell
git status          # 哪些文件改了、哪些还没提交
git log --oneline   # 我以前都提交过什么（一行一条）
git diff            # 具体改了哪几行（红色删、绿色加）
```

---

## 四、⚠️ 你这台电脑的网络情况（我实测过，很重要）

| 通道 | 状态 | 说明 |
|---|---|---|
| HTTPS（443，浏览器网页那种） | **时通时断** ❌ | `github.com` 的 HTTPS 经常卡死，等 10 秒也不通 |
| **SSH（22 端口）** | **完全通** ✅ | 推代码就走这条，稳 |
| Gitee HTTPS | 通 ✅ | 但为了统一，也用 SSH |

**结论：推 GitHub 一律走 SSH（`git@github.com:...`），不要用 `https://github.com/...`。**
网上的"改 hosts 修复 GitHub"教程对你这台机器**没用**（我试过，改了 IP 照样不通，已经帮你把 hosts 恢复干净了）。

**GitHub 推送偶尔会报 `Connection reset by ... port 22`**——这是线路抖动，不是你配错了。脚本会自动重试 3 次；还不行就过几分钟再双击一次。

---

## 五、常见报错对照表

| 报错 | 意思 | 怎么办 |
|---|---|---|
| `Connection reset by ... port 22` | 线路抖动 | 正常，重试即可（脚本自动重试 3 次） |
| `Permission denied (publickey)` | SSH 公钥没加对 | 去 https://github.com/settings/keys 和 https://gitee.com/profile/sshkeys 检查 |
| `Host key verification failed` | 第一次连没有信任指纹 | 已帮你处理过；若再犯：`ssh-keyscan gitee.com >> ~/.ssh/known_hosts` |
| `nothing to commit, working tree clean` | 没改动可提交 | 正常，说明你还没改东西 |
| `remote origin already exists` | 远程地址已存在 | `git remote remove origin` 再重新 add |
| `Authentication failed` | 用了 HTTPS 方式 | 改回 SSH 地址：`git remote set-url origin git@github.com:2q366/java-practice.git` |
| `Updates were rejected` | 远程有你本地没有的提交 | 先 `git pull origin main` 再 push |

---

## 六、我帮你做完的完整清单

- [x] 建本地 git 仓库 + 写 `.gitignore`（自动忽略 target/、.idea/ 等垃圾）
- [x] 配 git 身份：2q366 / 2685482839@qq.com
- [x] 生成 ed25519 SSH 密钥，配好 `~/.ssh/config`（GitHub + Gitee 都写了），修好私钥权限
- [x] 两个平台都加了公钥，`ssh -T` 双向验证通过
- [x] 配好两个远程：`origin`(GitHub) + `gitee`(Gitee)
- [x] **首次 push 成功**，本地/GitHub/Gitee 三处 commit 一致
- [x] 写好一键推送脚本 `一键推送.bat`（含 GitHub 失败重试）
- [x] 处理 Gitee 主机指纹问题，修复 hosts（已恢复原状）
