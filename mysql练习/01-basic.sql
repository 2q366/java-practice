-- ============================================
-- 阶段 0 · MySQL 练习（在命令行里一条条敲，或粘贴执行）
-- 连接命令：mysql -u root -p
-- 进去之后：提示符变成 mysql>
-- ============================================

-- 1. 看现在有哪些数据库
SHOW DATABASES;

-- 2. 建一个自己的库
CREATE DATABASE IF NOT EXISTS study DEFAULT CHARACTER SET utf8mb4;

-- 3. 进入这个库（之后所有操作都在 study 里）
USE study;

-- 4. 建一张表
CREATE TABLE IF NOT EXISTS student (
  id    INT PRIMARY KEY AUTO_INCREMENT,
  name  VARCHAR(20) NOT NULL,
  score INT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 5. 插 3 条数据
INSERT INTO student (name, score) VALUES ('张三',85),('李四',92),('王五',78);

-- 6. 查全部
SELECT * FROM student;

-- 7. 聚合：人数、平均分、最高分
SELECT COUNT(*) AS 人数, AVG(score) AS 平均分, MAX(score) AS 最高 FROM student;

-- 8. 按分数排序（从高到低）
SELECT name, score FROM student ORDER BY score DESC;

-- 9. 单独改一条（把张三改成 90 分）
UPDATE student SET score = 90 WHERE name = '张三';

-- 10. 再查一次，看改成功没
SELECT * FROM student WHERE name = '张三';

-- 11. 退出
-- exit