# Git 使用手册（陈喻涛专用 · 傻瓜版）

> 这份手册只教你**最常用的 5 条命令**。够你用一整年。
> 全部在 `E:\DSH工作区\Java练习` 这个目录里操作。

---

## 一、以后每次改完代码，三步走（90% 的场景）

打开 PowerShell，先 `cd E:\DSH工作区\Java练习`，然后：

```powershell
git add -A                                   # 第 1 步：把所有改动装进箱子
git commit -m "今天学了数组求和"               # 第 2 步：封箱，写一句话说明
git push                                     # 第 3 步：推到 GitHub（第一次要先绑定，见第三节）
```

**记住口诀：add → commit → push。** 就像：装袋 → 封口 → 寄出。

---

## 二、只想看看自己改了什么（不改任何东西）

```powershell
git status          # 哪些文件改了、哪些还没提交
git log --oneline   # 我以前都提交过什么（一行一条）
git diff            # 具体改了哪几行（红色是删的，绿色是加的）
```

---

## 二·五、⚠️ 你这台电脑的网络情况（重要，实测过）

我实测了你电脑到 GitHub 的连通性，结论很明确：

| 通道 | 状态 | 说明 |
|---|---|---|
| HTTPS（443 端口，浏览器/网页那种） | **不通（时通时断）** | `github.com` 这个域名的 HTTPS 会被卡住，等 10 秒也连不上 |
| **SSH（22 端口）** | **完全通** ✅ | 我测了 `git@github.com`，服务器正常应答，只是"公钥还没上传"（这是正常的，正常就该报这个） |

**所以：你这台机器推代码，一律用 SSH 方式，不要用 HTTPS 方式。**
网上那些"改 hosts 修复 GitHub"的教程对你**没用**（我试过，改了 IP 照样不通，已经帮你把 hosts 恢复干净了）。
`修复GitHub访问.bat` 那个脚本你可以不管它了。

---

## 三、第一次绑定 GitHub（只做一次）

### 方式 A：SSH 密钥（**你就用这个**，配一次以后永久免密）

1. 我已经帮你生成好密钥了，公钥在：
   `C:\Users\26854\.ssh\id_ed25519.pub`
2. 打开 https://github.com/settings/keys
3. 点 **New SSH key** → Title 随便写（比如 `我的笔记本`）→ Key 框里**粘贴整行公钥** → Add SSH key
4. 回来测试：
   ```powershell
   ssh -T git@github.com
   ```
   看到 `Hi 2q366! You've successfully authenticated` 就成了（第一次问 yes/no 打 `yes`）。
5. 把远程仓库地址设成 SSH 格式：
   ```powershell
   git remote add origin git@github.com:2q366/你的仓库名.git
   ```

### 方式 B：HTTPS + Token（**你这台机器不要用**）

> 你的网络走 HTTPS 到 github.com 不稳定，这条路会频繁失败。**优先用方式 A（SSH）。**

如果哪天换了网络环境（比如在学校机房）想用 HTTPS：
1. 打开 https://github.com/settings/tokens → **Generate new token (classic)**
2. Note 随便写，Expiration 选 90 天，勾选 **repo** 这一项 → 生成
3. **立刻复制那串 token**（只显示一次！）
4. 推送时用户名填 `2q366`，**密码填那串 token**（不是登录密码！）

---

## 四、Gitee（国内，速度快，作为备份）

步骤和 GitHub 一样，只是网址不同：

1. 注册 https://gitee.com（用同一个邮箱）
2. 加 SSH 公钥：https://gitee.com/profile/sshkeys —— **公钥内容和 GitHub 用的同一个**，直接粘贴
3. 建仓库，然后：
   ```powershell
   git remote add gitee git@gitee.com:你的用户名/仓库名.git
   git push gitee
   ```
   这样你可以同时推到 GitHub 和 Gitee（两边都是备份）：
   ```powershell
   git push origin    # 推 GitHub
   git push gitee     # 推 Gitee
   ```

---

## 五、常见报错对照表

| 报错 | 意思 | 怎么办 |
|---|---|---|
| `Permission denied (publickey)` | SSH 密钥没加对 | 回第三节方式 A 第 2-4 步重做 |
| `Authentication failed` | HTTPS 密码填错了 | 密码要填 **token**，不是登录密码 |
| `remote origin already exists` | 远程地址已存在 | 先 `git remote remove origin` 再重加 |
| `nothing to commit` | 没改动可提交 | 正常，说明你还没改东西 |
| `src refspec main does not match any` | 还没提交过 | 先 `git add -A` + `git commit` |
| `Failed to connect to github.com port 443` | 网络不通 | 双击 `修复GitHub访问.bat`（管理员运行） |
| `your branch is ahead of 'origin/main' by 1 commit` | 本地比远程多 1 个提交 | 正常，`git push` 一下就行 |

---

## 六、我今天帮你做完的事

- [x] 在 `E:\DSH工作区\Java练习` 建好 git 仓库
- [x] 写好 `.gitignore`（自动忽略 target/、.idea/ 这些垃圾文件，不会传上去）
- [x] 完成**第 1 次提交**（11 个文件，460 行），提交号 `96e24c2`
- [x] 配好 git 身份（2q366 / 2685482839@qq.com）
- [x] 生成 SSH 密钥（ed25519），并**配好 `~/.ssh/config`**（GitHub 和 Gitee 都已写好，自动用这把钥匙）
- [x] 修好私钥文件权限（Windows 上权限不对 ssh 会拒绝用这把钥匙）
- [x] 实测确认：**你这台机器 SSH 通、HTTPS 到 github.com 不稳**，所以手册全部改成 SSH 路线

## 七、还差你自己做的 3 件事

1. **把 SSH 公钥加到 GitHub**
   打开 https://github.com/settings/keys → New SSH key → 粘贴这一整行：
   ```
   ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIO6spF4NiNISdz0VB7P3vlUGRKC4m117RcAd9f//M2+V 2685482839@qq.com
   ```
   加完回来在 PowerShell 里测：`ssh -T git@github.com`
   看到 `Hi 2q366! You've successfully authenticated` 就成了。

2. **在 GitHub 网页建一个空仓库**，名字建议 `java-practice`
   ⚠️ **不要勾 "Add a README file"**（勾了会和你本地的冲突，第一次推会很麻烦）
   建好后执行：
   ```powershell
   cd E:\DSH工作区\Java练习
   git remote add origin git@github.com:2q366/java-practice.git
   git push -u origin main
   ```

3. **Gitee 也注册**（https://gitee.com），加同一把公钥（https://gitee.com/profile/sshkeys），
   然后同样建仓库并推送：
   ```powershell
   git remote add gitee git@gitee.com:你的Gitee用户名/java-practice.git
   git push -u gitee main
   ```
   Gitee 的 HTTPS 是通的，如果 SSH 嫌麻烦，Gitee 也可以用 HTTPS。

> 做完第 1、2 步以后，你每天就只用记三件事：`git add -A` → `git commit -m "说明"` → `git push`。
