create table student_address(
address_id int not null auto_increment,
addressline1 varchar(200),
addressline2 varchar(200),
city varchar(100),
state varchar(100),
postal varchar(10),
address_phonenumber varchar(10),
sms_phone_number varchar(10),
address_email varchar(100),
address_type varchar(100),
student_id int,
primary key (address_id),
foreign key (student_id) references student_basic_detail(student_id)
);

