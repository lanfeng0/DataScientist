-- 1.查询已存在数据库列表
SHOW DATABASES;

-- 2.创建数据库
CREATE DATABASE IF NOT EXISTS JJA2004_3;

-- 3.删除数据库
DROP DATABASE JJA2004_3;

-- 4.查看数据库的定义声明
SHOW CREATE DATABASE  JJA2004_3;

-- 5.使用指定数据库
USE JJA2004_3;


-- 6.在指定的数据库创建表
CREATE TABLE account(
   account_id VARCHAR(36) PRIMARY KEY,-- 使用uuid()生成唯一值
   account_name VARCHAR(15) NOT NULL,
	 balance  DECIMAL(10,2) NOT NULL,
   reg_date DATE
);

-- 7.删除表
DROP TABLE account;

-- 8.日期时间相关函数
SELECT NOW(),SYSDATE(),CURDATE(),CURTIME();
-- 日期转换成指定格式字符串输出
SELECT DATE_FORMAT(NOW(),'%Y年%m月%d日 %H时:%i分:%s秒');
-- 日期时间转成时间戳
SELECT UNIX_TIMESTAMP(NOW());

-- 9. 查询今天注册的用户信息
SELECT * from account where reg_date=CURDATE();
--    查询昨天注册的用户信息
SELECT * from account where reg_date=CURDATE()-1;
--    查询前天注册的用户信息
SELECT * from account where reg_date=CURDATE()-2;

-- 10.使用uuid()插入数据
INSERT INTO account(account_id,account_name,balance,reg_date)VALUES(UUID(),'小红帽',2000,CURDATE());
INSERT INTO account(account_id,account_name,balance,reg_date)VALUES(UUID(),'伟文',500,CURDATE());

-- 11.使用uuid_short()插入数据
INSERT INTO account(account_id,account_name,balance,reg_date)VALUES(UUID_SHORT(),'尔康',1000,CURDATE());
INSERT INTO account(account_id,account_name,balance,reg_date)VALUES(UUID_SHORT(),'陆亮',500,CURDATE());


-- mysql默认自动提交事务
INSERT INTO account(account_id,account_name,balance,reg_date)VALUES(UUID_SHORT(),'测试',500,CURDATE());

-- 事务
-- 开启事务
START TRANSACTION;
-- 进行更新数据
UPDATE account SET balance=balance-500 WHERE account_id='7b3338c5-d073-11ea-a13a-2c56dc4c3374';-- 单旺

-- 继续更新
UPDATE account SET balance=balance+500 WHERE account_id='7b41430d-d073-11ea-a13a-2c56dc4c3374';-- 伟文

-- 提交事务
COMMIT;


-- 开启事务
START TRANSACTION;
-- 进行更新数据
UPDATE account SET balance=balance-1000 WHERE account_id='7b3338c5-d073-11ea-a13a-2c56dc4c3374';-- 单旺

-- 在本窗口中查询
SELECT * from account

-- 回滚事务
ROLLBACK;

SELECT * from account;



create table transrecord(
  trans_id      varchar(36) primary key,  -- 使用UUID_SHORT函数生成唯一值
  sender_id     varchar(36),
  receiver_id    varchar(36),
  trans_balance  decimal(10,2),
  trans_datetime  datetime
);


INSERT INTO transrecord(trans_id,sender_id,receiver_id,trans_balance,trans_datetime)VALUES(UUID_SHORT(),?,?,?,SYSDATE());





-- 创建视图 VIEW
CREATE VIEW view_account 
AS
SELECT * FROM account;

-- 使用视图
SELECT * FROM view_account;



-- 插入测试数据
INSERT INTO transrecord(trans_id,sender_id,receiver_id,trans_balance,trans_datetime) 
	VALUES(UUID_SHORT(),
'26774712205967362',
'26774712205967363',
200,
SYSDATE());

INSERT INTO transrecord(trans_id,sender_id,receiver_id,trans_balance,trans_datetime) 
	VALUES(UUID_SHORT(),
'26774712205967362',
'26774712205967363',
100,
SYSDATE());

-- 示例  列出流水表详细信息
-- 流水号  发送者 ID 发送者姓名 收款者ID 收款者姓名 转账金额  转账时间
SELECT a.trans_id,
a.sender_id,
b.account_name,
a.receiver_id,
c.account_name,
a.trans_balance,
a.trans_datetime        
FROM transrecord a INNER JOIN account b ON a.sender_id=b.account_id 
INNER JOIN account c ON a.receiver_id=c.account_id


-- ②查询指定用户的转出详情  -- 单旺的支出
SELECT a.trans_id,
a.sender_id,
b.account_name,
a.receiver_id,
c.account_name,
a.trans_balance,
a.trans_datetime        
FROM transrecord a INNER JOIN account b ON a.sender_id=b.account_id 
INNER JOIN account c ON a.receiver_id=c.account_id
where a.sender_id='7b3338c5-d073-11ea-a13a-2c56dc4c3374';


-- ③查询指定用户的转入详情 -- 陆亮的转入
SELECT a.trans_id,
a.sender_id,
b.account_name,
a.receiver_id,
c.account_name,
a.trans_balance,
a.trans_datetime        
FROM transrecord a INNER JOIN account b ON a.sender_id=b.account_id 
INNER JOIN account c ON a.receiver_id=c.account_id
where a.receiver_id='26774712205967363';


-- 使用创建视图,查询流水账详情
CREATE VIEW view_transrecord_detail
AS
SELECT a.trans_id as transId,
a.sender_id    as sendeId,
b.account_name  as sendeName,
a.receiver_id as receiverId,
c.account_name as receiverName,
a.trans_balance as transBalance,
a.trans_datetime   as transNatetime      
FROM transrecord a INNER JOIN account b ON a.sender_id=b.account_id 
INNER JOIN account c ON a.receiver_id=c.account_id;


-- 使用视图 查询流水账详情
SELECT * FROM view_transrecord_detail;

-- 使用视图,查询指定用户的转出详情
SELECT * FROM view_transrecord_detail  where sendeId='7b3338c5-d073-11ea-a13a-2c56dc4c3374';


-- 使用视图,查询指定用户的转入详情
SELECT * FROM view_transrecord_detail  where receiverId='26774712205967363';


-- 统计函数
SELECT COUNT(*) FROM account;


-- if函数
SELECT IF(1=1,'true','false');-- true
SELECT IF(1=2,'true','false');-- false

-- 应用

-- SELECT 用户名,用户状态,IF(用户状态=0,'普通用户','会员') as 用户状态名称 from 用户表;
SELECT account_id,account_name,balance,reg_date,status,IF(status=0,'普通用户','会员') 
as status_name  FROM  account;


-- 自定义变量
-- 1.用户变量,必须加@符号,不用限定类型
-- 声明变量并初始化
-- 方式1: SET @变量名=初始值;
SET @num1=1;
-- 也可以用:=
SET @num2 :=2;

-- 查询变量
SELECT @num1,@num2;

-- 或
SELECT @num3 :=3;

-- 方式2: SELECT 列名 INTO @变量名 FROM 表
SELECT COUNT(*) INTO @num FROM account;
-- 查询变量
SELECT @num;

-- SELECT 列名1,列名2 INTO @变量名1, @变量名2  FROM 表;
SELECT COUNT(*),SUM(balance) INTO @num,@sum1 FROM account;
-- 查询变量
SELECT @num,@sum1;



-- 2.局部变量,只能在begin end 之间
BEGIN

  # 声明局部变量,需要指定数据类型
  DECLARE num INT DEFAULT 0;
  # 对局部变量赋值方式1  SET 变量名=值;
  SET num=1;
  # 对局部变量赋值方式2  SELECT 列名 INTO 变量名 FROM 表
  SELECT COUNT(*) INTO num FROM account;
  
  #查询变量
  SELECT num;

END



-- CASE分支结构:
-- 情况1：类似switch ，实现等值判断
-- 查询用户余额
-- 余额=500,显示余额2倍
-- 余额=1000,显示余额3倍
-- 余额=1500,显示余额4倍
-- 否则,显示原来的余额
SELECT * FROM account;

SELECT account_id,account_name,balance,
CASE balance
 WHEN 500 THEN balance*2
 WHEN 1000 THEN balance*3
 WHEN 1500 THEN balance*4
 ELSE balance END
AS newBalance,reg_date FROM  account;


-- 查询账号信息
-- 余额>=2000,显示用户等级'砖石会员'
-- 余额>=1500,显示用户等级'铂金会员'
-- 余额>=1000,显示用户等级'黄金会员'
-- 余额>=500,显示用户等级'大众会员'


SELECT account_id,account_name,balance,
CASE 
 WHEN balance>=2000 THEN '砖石会员'
 WHEN balance>=1500 THEN '铂金会员'
 WHEN balance>=1000 THEN '黄金会员'
 WHEN balance>=500 THEN '大众会员'
 ELSE '普通用户' END
AS balance_level,reg_date FROM  account;













