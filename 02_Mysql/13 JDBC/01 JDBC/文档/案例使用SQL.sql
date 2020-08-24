-- 1.查询所有员工的详细信息 包含部门编号和部门名称 和领导编号 领导名称
SELECT
	E.EMPNO,
  E.ENAME,
  E.JOB,
  E.MGR,
  M.ENAME AS MNAME,
  E.HIREDATE,
  E.SAL,
  E.COMM,
  E.DEPTNO,
  D.DNAME
FROM
	EMP E,
	DEPT D,
	EMP M
WHERE
	E.DEPTNO = D.DEPTNO
AND E.MGR = M.EMPNO;

-- 2.根据员工编号获取一个员工的详细信息
SELECT * FROM EMP WHERE EMPNO=7902;

-- 3.新增一个员工信息
INSERT INTO EMP VALUES(?,?,?,?,?,?,?,?);

UPDATE EMP SET ENAME=?, JOB=?,SAL=? WHERE EMPNO = ？；

UPDATE EMP SET 1=1 WHERE EMPNO=7902;


-- 按条件查询员工信息  查询条件：
    -- 姓名 -- 支持模糊查询
    -- 职位 -- 精确查询
    -- 部门编号 --- 精确查询
    -- 入职日期 --- 范围
    --  如果这些条件都不输入 查询所有的员工  条件与条件之间是and关系
SELECT  ROWNUM,  E.* FROM EMP  E WHERE 1=1
AND E.ENAME LIKE '%J%';
--AND JOB = 'CLERK'
--AND DEPTNO = 10
--AND HIREDATE BETWEEN TO_DATE ('1981-12-17', 'YYYY-MM-DD') AND TO_DATE ('1985-12-17', 'YYYY-MM-DD');

-- 分页 + 多条件查询
SELECT * FROM 
  (SELECT  ROWNUM RW, E.* FROM EMP E WHERE 1=1
			AND E.ENAME LIKE '%J%'
	-- AND JOB = 'CLERK'
	-- AND DEPTNO = 10
	-- AND HIREDATE BETWEEN TO_DATE ('1981-12-17', 'YYYY-MM-DD') AND TO_DATE ('1985-12-17', 'YYYY-MM-DD');
      AND ROWNUM<=6 
  )  WHERE RW>=2



















