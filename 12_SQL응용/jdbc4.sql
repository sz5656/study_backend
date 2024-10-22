DROP TABLE employee;
DROP TABLE department;

CREATE TABLE department ( deptid   NUMBER(10) PRIMARY KEY NOT NULL
                         ,deptname VARCHAR2(10)
                         ,location VARCHAR2(10)
                         ,tel      VARCHAR2(15));
CREATE TABLE employee   ( empid    NUMBER(10) PRIMARY KEY NOT NULL
                         ,empname  VARCHAR2(10)
                         ,hiredate DATE
                         ,addr     VARCHAR2(12)
                         ,tel      VARCHAR2(15)
                         ,deptid   NUMBER(10),
                         CONSTRAINT emp_dept_deptid_FK FOREIGN KEY(deptid) REFERENCES department(deptid));
ALTER TABLE employee
ADD         birthday DATE;

INSERT INTO department ( deptid
                        ,deptname
                        ,location
                        ,tel )
VALUES                 ( 1001
                        ,'총무팀'
                        ,'본101호'
                        ,'053-777-8777');
INSERT INTO department ( deptid
                        ,deptname
                        ,location
                        ,tel )
VALUES                 ( 1002
                        ,'회계팀'
                        ,'본102호'
                        ,'053-888-9999');
INSERT INTO department ( deptid
                        ,deptname
                        ,location
                        ,tel )
VALUES                 ( 1003
                        ,'영업팀'
                        ,'본102호'
                        ,'053-222-3333');
SELECT  deptid
       ,deptname
       ,location
       ,tel
FROM   department;
INSERT INTO employee   ( empid
                        ,empname
                        ,hiredate
                        ,addr
                        ,tel
                        ,deptid )
VALUES                 ( 20121945
                        ,'박민수'
                        ,TO_DATE('20120302','yy/MM/dd')
                        ,'대구'
                        ,'010-1111-1234'
                        ,1001);
INSERT INTO employee   ( empid
                        ,empname
                        ,hiredate
                        ,addr
                        ,tel
                        ,deptid )
VALUES                 ( 20101817
                        ,'박준식'
                        ,TO_DATE('20100901','yy/MM/dd')
                        ,'경산'
                        ,'010-2222-1234'
                        ,1003);
INSERT INTO employee   ( empid
                        ,empname
                        ,hiredate
                        ,addr
                        ,tel
                        ,deptid )
VALUES                 ( 20122245
                        ,'선아라'
                        ,TO_DATE('20120302','yy/MM/dd')
                        ,'대구'
                        ,'010-3333-1222'
                        ,1002);
INSERT INTO employee   ( empid
                        ,empname
                        ,hiredate
                        ,addr
                        ,tel
                        ,deptid )
VALUES                 ( 20121729
                        ,'이범수'
                        ,TO_DATE('20110302','yy/MM/dd')
                        ,'서울'
                        ,'010-3333-4444'
                        ,1001);
INSERT INTO employee   ( empid
                        ,empname
                        ,hiredate
                        ,addr
                        ,tel
                        ,deptid )
VALUES                 ( 20121646
                        ,'이용희'
                        ,TO_DATE('20120901','yy/MM/dd')
                        ,'부산'
                        ,'010-1234-2222'
                        ,1003);
SELECT *
FROM   employee;

-- 9 NOTNULL 제약조건 추가
ALTER TABLE employee
MODIFY empname NOT NULL;

--10 총무팀에 근무하는 직원의 이름, 입사일, 부서명 출력
SELECT e.empname, e.hiredate, d.deptname
FROM   employee e JOIN department d
ON  e.deptid = d.deptid
AND    d.deptname = '총무팀';

--11 직원테이블에서 대구에 살고 있는 직원을 모두 삭제
DELETE employee
WHERE  addr = '대구';

SELECT *
FROM   department;
--12 직원 테이블에서 영업팀에 근무하는 직원을 모두 회계팀으로 수정
UPDATE employee
SET    deptid = (SELECT deptid
                 FROM   department
                 WHERE  deptname = '회계팀')
WHERE  deptid = (SELECT deptid
                 FROM   department
                 WHERE  deptname = '영업팀');

--13 직원 테이블에서 직원번호가 20121729 인 직원의 입사일보다 늦게 입사한
--   직원의 직원번호, 이름, 생년월일, 부서이름을 출력
SELECT e.empid, e.empname, e.birthday, d.deptname
FROM   employee e 
       JOIN department d
       ON     e.deptid = d.deptid
WHERE  e.hiredate > (SELECT hiredate
                     FROM   employee
                     WHERE  empid = 20121729);

--14 총무팀에 근무하는 직원의 이름, 주소, 부서명을 볼 수 있는 뷰 생성
CREATE OR REPLACE VIEW emp_view
AS      SELECT e.empname, e.addr, d.deptname
        FROM   employee e 
               JOIN department d
               ON   e.deptid = d.deptid
        WHERE  d.deptname = '총무팀';