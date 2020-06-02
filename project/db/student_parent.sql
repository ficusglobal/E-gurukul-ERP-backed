create table student_parent(
parent_id int not null auto_increment,
parent_name varchar(100),
parent_qualification varchar(100),
parent_profession varchar(100),
parent_phone varchar(10),
parent_email varchar(100),
student_id int,
primary key(parent_id),
foreign key (student_id) references student_basic_detail(student_id)
);