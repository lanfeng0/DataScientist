-- 创建测试表
CREATE TABLE test(
  tid int
)


-- 删除存储过程
DROP PROCEDURE p1;
-- 示例1:无参数的存储过程
-- 创建存储过程
CREATE PROCEDURE p1()
BEGIN
  # 声明局部变量
  DECLARE i INT DEFAULT 1;
  #循环
  WHILE i<=10 DO
		# 循环体  往test表批量插入数据
		INSERT INTO test(tid) VALUES(i);
		# 改变循环条件
		SET i=i+1;
  END WHILE;
  -- 查看test表数据
	SELECT * from test;
END


-- 调用存储过程
CALL p1();

-- 创建存储过程
CREATE PROCEDURE p2()
BEGIN
  # 声明局部变量
  DECLARE i INT DEFAULT 1;
  #循环
  lp:LOOP
		# 循环体  往test表批量插入数据
		INSERT INTO test(tid) VALUES(i);
		# 改变循环条件
		SET i=i+1;
    # 条件语句判断循环结束条件
    IF i>10 THEN
      LEAVE lp; # 退出循环
    END IF;
  END LOOP;
  -- 查看test表数据
	SELECT * from test;
END

-- 调用存储过程
CALL p2();

-- 创建存储过程
CREATE PROCEDURE p3()
BEGIN
  # 声明局部变量
  DECLARE i INT DEFAULT 1;
  #循环
  REPEAT
		# 循环体  往test表批量插入数据
		INSERT INTO test(tid) VALUES(i);
		# 改变循环条件
		SET i=i+1;
	  # 退出循环
    UNTIL i>10  
  END REPEAT;
  -- 查看test表数据
	SELECT * from test;
END

-- 调用存储过程
CALL p3();


-- 练习:根据账户编号,返回账户余额,用户等级
-- 余额>=2000,显示用户等级'砖石会员'
-- 余额>=1500,显示用户等级'铂金会员'
-- 余额>=1000,显示用户等级'黄金会员'
-- 余额>=500,显示用户等级'大众会员'

-- 创建存储过程
CREATE PROCEDURE p4(
IN in_account_id VARCHAR(36),
OUT out_balance DECIMAL,
OUT out_level VARCHAR(20)
 )
BEGIN
 SELECT balance,
 CASE 
	 WHEN balance>=2000 THEN '砖石会员'
	 WHEN balance>=1500 THEN '铂金会员'
	 WHEN balance>=1000 THEN '黄金会员'
	 WHEN balance>=500 THEN '大众会员'
   ELSE '普通用户' END
 AS balance_level INTO out_balance,out_level
 FROM account where account_id=in_account_id;# 入参就是指定的账户编号
END

-- 调用存储过程
-- 1.声明一个用户变量
SET @in_account_id='1bf953b4-d0ac-11ea-a13a-2c56dc4c3374';
-- 2.执行存储过程
-- 入参为上面定义的用户变量id的值
-- 出参为@out_balance,@out_level
CALL p4(@in_account_id,@out_balance,@out_level);
-- 在执行完存储过程之后,使用select 输出出参
SELECT @out_balance,@out_level;


-- 示例3：用户表、转账记录表、测试表等多张表的统计分析
CREATE PROCEDURE p_count(
OUT account_count INT,
OUT transrecord_count INT,
OUT test_count INT)

BEGIN
  SELECT COUNT(*) INTO account_count  FROM account;
	SELECT COUNT(*) INTO transrecord_count FROM  transrecord;
	SELECT COUNT(*) INTO test_count FROM test;
END

-- 调用
CALL p_count(@account_count,@transrecord_count,@test_count);
-- 查询
SELECT @account_count,@transrecord_count,@test_count;

-- 删除存储过程
DROP PROCEDURE p_trans;
-- 示例4：存储过程+事务+异常处理模拟转账
CREATE PROCEDURE p_trans(
IN in_sender_id VARCHAR(36),
IN in_resceiver_id VARCHAR(36),
IN in_balance DECIMAL,
OUT out_result VARCHAR(30)
)
BEGIN
  # 声明局部变量,存储转出者余额
  DECLARE senderBalance DECIMAL DEFAULT 0.0; 
  # 声明局部变量,标识是否出现异常:0没有异常  1 代表异常
  DECLARE hasSqlError INT DEFAULT 0; 
  # 在存储过程执行中出现任何异常
  DECLARE CONTINUE HANDLER FOR SQLWARNING,NOT FOUND,SQLEXCEPTION SET hasSqlError=1;
  # 开启事务管理
	START TRANSACTION;

  # 查询转出者的余额,赋值给变量
  SELECT balance INTO senderBalance FROM account WHERE account_id=in_sender_id;

	# 转出 减少金额
	UPDATE account SET balance=balance-in_balance WHERE account_id=in_sender_id;

	# 转入  增加金额
	UPDATE account SET balance=balance+in_balance WHERE account_id=in_resceiver_id;

  # 添加记录信息
  INSERT INTO transrecord(trans_id,sender_id,receiver_id,trans_balance,trans_datetime)VALUES(UUID_SHORT()
  ,in_sender_id,in_resceiver_id,in_balance,SYSDATE());
  
  # 分支,判断是否有异常
  IF hasSqlError=1 THEN
     # 回滚事务
     ROLLBACK;
     SET out_result='系统异常,转账失败!';
  ELSEIF senderBalance<in_balance THEN
     # 回滚事务
     ROLLBACK;
     SET out_result='余额不足,转账失败!';
  ELSE
		 # 提交事务
		 COMMIT;
     SET out_result='转账成功!';
  END IF;
END

-- 调用
SET @in_sender_id='1bf953b4-d0ac-11ea-a13a-2c56dc4c3374';
SET @in_resceiver_id='26774712205967362';
SET @in_balance=2000;

CALL p_trans(@in_sender_id,@in_resceiver_id,@in_balance,@out_result);

SELECT @out_result;


-- 查询结果集
CREATE PROCEDURE p_getaccount()
BEGIN
  SELECT * FROM account;
END

-- 调用
CALL p_getaccount();








-- 函数
-- mysql自带函数
SELECT NOW(),SYSDATE();

-- 自定义函数
-- 示例1:计算2个数的和
CREATE FUNCTION fun1(a INT,b INT)
RETURNS INT
BEGIN
  # 函数体
  RETURN a+b;
END

-- 调用函数
SET @num1=1;
SET @num2=2;
SELECT fun1(@num1,@num2);

-- 返回用户表总数
CREATE FUNCTION fun2()
RETURNS INT
BEGIN
  # 函数体
  # 声明局部变量,存放数量
   DECLARE count INT;
  # sql语句
  SELECT COUNT(*) INTO count FROM account;
  RETURN count;
END

-- 调用函数
SELECT fun2();



-- 根据账号返回账号余额
CREATE FUNCTION fun3(f_account_id VARCHAR(36))
RETURNS DECIMAL
BEGIN
   
  #声明一个变量存储账号余额
  DECLARE f_balance DECIMAL;
  #通过SQL查出账户余额赋值给变量
  SELECT balance INTO f_balance FROM account WHERE account_id=f_account_id;

  RETURN f_balance;

END

-- 调用函数
SET @account_id='1bf953b4-d0ac-11ea-a13a-2c56dc4c3374';
SELECT fun3(@account_id);


-- 创建一张日志表 COMMENT注释的内容
CREATE TABLE account_logs(
  id INT PRIMARY KEY AUTO_INCREMENT,
  operation VARCHAR(20)  COMMENT '操作类型, insert/update/delete',
  operate_time DATETIME  COMMENT '操作时间',
  operate_id VARCHAR(36) COMMENT '操作表的ID',
  operate_params VARCHAR(500) COMMENT '操作参数'
);


DROP TRIGGER account_insert;
-- 创建针对account表的insert操作触发器
CREATE TRIGGER account_insert
AFTER INSERT ON account FOR EACH ROW
BEGIN
   # 当account表发生insert插入操作时要执行的sql语句
   # 往日志表account_logs添加一个记录   # CONCAT('','')拼接字符串的函数
   INSERT INTO account_logs VALUES(NULL,'insert',NOW(),new.account_id,
   CONCAT('插入数据(account_id:',new.account_id,'account_name:',new.account_name,'balance:',new.balance,
    'reg_date:',new.reg_date,'t_status:',new.t_status,')') );
END

-- 测试:往account表中新增一条记录
INSERT INTO account(account_id,account_name,balance,reg_date,t_status)VALUES(UUID(),'小绿2',2000,CURDATE(),1);

DROP TRIGGER account_update;
-- 创建针对account表的update操作触发器
CREATE TRIGGER account_update
AFTER UPDATE ON account FOR EACH ROW
BEGIN
   # 当account表发生update操作时要执行的sql语句
   # 往日志表account_logs添加一个记录   # CONCAT('','')拼接字符串的函数
   INSERT INTO account_logs VALUES(NULL,'update',NOW(),new.account_id,
   CONCAT('修改之前的数据:(account_id:',old.account_id,'account_name:',old.account_name,'balance:',old.balance,')',
   '修改之后的数据:(account_id:',new.account_id,'account_name:',new.account_name,'balance:',new.balance,')'
) );
END

-- 测试:往account表中修改一条记录
UPDATE account SET account_name='周杰',balance=20000 WHERE account_id='26774712205967362';




-- 创建针对account表的delete操作触发器
CREATE TRIGGER account_delete
AFTER DELETE ON account FOR EACH ROW
BEGIN
   # 当account表发生update操作时要执行的sql语句
   # 往日志表account_logs添加一个记录   # CONCAT('','')拼接字符串的函数
   INSERT INTO account_logs VALUES(NULL,'delete',NOW(),old.account_id,
   CONCAT('删除的数据:(account_id:',old.account_id,
											'account_name:',old.account_name,
											'balance:',old.balance,
											'reg_date:',old.reg_date,
											't_status:',old.t_status,')')
 );
END

-- 删除一条数据,查看日志表
DELETE FROM account where account_id='26774712205967365';
SELECT * from account_logs;


