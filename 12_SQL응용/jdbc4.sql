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
                        ,'�ѹ���'
                        ,'��101ȣ'
                        ,'053-777-8777');
INSERT INTO department ( deptid
                        ,deptname
                        ,location
                        ,tel )
VALUES                 ( 1002
                        ,'ȸ����'
                        ,'��102ȣ'
                        ,'053-888-9999');
INSERT INTO department ( deptid
                        ,deptname
                        ,location
                        ,tel )
VALUES                 ( 1003
                        ,'������'
                        ,'��102ȣ'
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
                        ,'�ڹμ�'
                        ,TO_DATE('20120302','yy/MM/dd')
                        ,'�뱸'
                        ,'010-1111-1234'
                        ,1001);
INSERT INTO employee   ( empid
                        ,empname
                        ,hiredate
                        ,addr
                        ,tel
                        ,deptid )
VALUES                 ( 20101817
                        ,'���ؽ�'
                        ,TO_DATE('20100901','yy/MM/dd')
                        ,'���'
                        ,'010-2222-1234'
                        ,1003);
INSERT INTO employee   ( empid
                        ,empname
                        ,hiredate
                        ,addr
                        ,tel
                        ,deptid )
VALUES                 ( 20122245
                        ,'���ƶ�'
                        ,TO_DATE('20120302','yy/MM/dd')
                        ,'�뱸'
                        ,'010-3333-1222'
                        ,1002);
INSERT INTO employee   ( empid
                        ,empname
                        ,hiredate
                        ,addr
                        ,tel
                        ,deptid )
VALUES                 ( 20121729
                        ,'�̹���'
                        ,TO_DATE('20110302','yy/MM/dd')
                        ,'����'
                        ,'010-3333-4444'
                        ,1001);
INSERT INTO employee   ( empid
                        ,empname
                        ,hiredate
                        ,addr
                        ,tel
                        ,deptid )
VALUES                 ( 20121646
                        ,'�̿���'
                        ,TO_DATE('20120901','yy/MM/dd')
                        ,'�λ�'
                        ,'010-1234-2222'
                        ,1003);
SELECT *
FROM   employee;

-- 9 NOTNULL �������� �߰�
ALTER TABLE employee
MODIFY empname NOT NULL;

--10 �ѹ����� �ٹ��ϴ� ������ �̸�, �Ի���, �μ��� ���
SELECT e.empname, e.hiredate, d.deptname
FROM   employee e JOIN department d
ON  e.deptid = d.deptid
AND    d.deptname = '�ѹ���';

--11 �������̺��� �뱸�� ��� �ִ� ������ ��� ����
DELETE employee
WHERE  addr = '�뱸';

SELECT *
FROM   department;
--12 ���� ���̺��� �������� �ٹ��ϴ� ������ ��� ȸ�������� ����
UPDATE employee
SET    deptid = (SELECT deptid
                 FROM   department
                 WHERE  deptname = 'ȸ����')
WHERE  deptid = (SELECT deptid
                 FROM   department
                 WHERE  deptname = '������');

--13 ���� ���̺��� ������ȣ�� 20121729 �� ������ �Ի��Ϻ��� �ʰ� �Ի���
--   ������ ������ȣ, �̸�, �������, �μ��̸��� ���
SELECT e.empid, e.empname, e.birthday, d.deptname
FROM   employee e 
       JOIN department d
       ON     e.deptid = d.deptid
WHERE  e.hiredate > (SELECT hiredate
                     FROM   employee
                     WHERE  empid = 20121729);

--14 �ѹ����� �ٹ��ϴ� ������ �̸�, �ּ�, �μ����� �� �� �ִ� �� ����
CREATE OR REPLACE VIEW emp_view
AS      SELECT e.empname, e.addr, d.deptname
        FROM   employee e 
               JOIN department d
               ON   e.deptid = d.deptid
        WHERE  d.deptname = '�ѹ���';