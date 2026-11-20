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

## 三、第一次绑定 GitHub（只做一次）

### 方式 A：SSH 密钥（推荐，配一次以后永久免密）

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

### 方式 B：HTTPS + Token（不想配 SSH 就用这个）

1. 打开 https://github.com/settings/tokens → **Generate new token (classic)**
2. Note 随便写，Expiration 选 90 天，勾选 **repo** 这一项 → 生成
3. **立刻复制那串 token**（只显示一次！）
4. 推送时：
   ```powershell
   git remote add origin https://github.com/2q366/你的仓库名.git
   git push
   ```
   弹窗要用户名密码时：用户名填 `2q366`，**密码填那串 token**（不是你的登录密码！）

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
- [x] 生成 SSH 密钥（公钥已复制到剪贴板）

## 七、还差你自己做的 3 件事

1. **加 SSH 公钥到 GitHub**（第三节方式 A 第 2 步）
2. **在 GitHub 网页建一个空仓库**，名字建议 `java-practice`，**不要**勾选 "Add a README"（勾了会冲突）
   → 建好后把地址发我，或自己执行：
   ```powershell
   cd E:\DSH工作区\Java练习
   git remote add origin git@github.com:2q366/java-practice.git
   git push -u origin main
   ```
3. **Gitee 也注册一个**，同样加公钥（公钥直接粘同一行）
