create table student_application_detail(
application_id int not null auto_increment,
application_num varchar(100),
application_academic_year varchar(100),
application_grade varchar(100),
application_issuedate varchar(100),
student_id int,
primary key(application_id),
foreign key(student_id) references student_basic_detail(student_id)
);