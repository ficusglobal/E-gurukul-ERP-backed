create table student_basic_detail (
student_id int not null auto_increment,
student_name varchar(100) not null,
student_dob timestamp,
student_gender varchar(100),
student_birthplace varchar(100),
student_nationality varchar(100),
student_livingwith varchar(100),
student_mothertongue varchar(100),
student_religion varchar(100),
student_email varchar(100),
student_mobile varchar(10),
primary key (student_id)
);