create table student_interest(
interest_id int auto_increment not null,
interest_name varchar(100),
student_id int,
primary key(interest_id),
foreign key (student_id) references student_basic_detail(student_id)
);