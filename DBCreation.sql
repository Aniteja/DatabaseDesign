Create table quality_control
(E_name varchar (20), address varchar (30), prodtype_check varchar (10), primary key (e_name));


Create table tech_staff
(e_name varchar (20), address varchar (30), tech_posn varchar (10), primary key (e_name));


create table worker
(e_name varchar (20), address varchar (30), no_of_prods number (3), primary key (e_name));


create table degrees
(degree varchar (6), e_name varchar (20), PRIMARY KEY (degree, e_name), foreign key (e_name) references tech_staff);


create table products
(prod_id  varchar(10) primary key, p_date varchar(20), time_taken number (4,2), prod_person varchar(20), test_person varchar(20), repair_person varchar(20)); 


create table product1
(prod_id varchar (10), prod1_size character (6), soft_name varchar (15), primary key (prod_id), foreign key (prod_id) references products);


create table product2
(prod_id varchar (10), prod2_size character (6), p_color character (10), primary key (prod_id), foreign key (prod_id) references products);


create table product3
(prod_id varchar (10), prod3_size character (6), weight number (5, 2), primary key (prod_id), foreign key (prod_id) references products);


create table customer
(c_name varchar (20) primary key, address varchar (30));


create table complaint
(comp_id varchar (10) primary key, c_date varchar(20), comp_desc varchar (50), treatment varchar (25));


create table accounts (ac_no number(10) primary key, a_date varchar (20), pcost number (5,2));


create table account1
(ac_no number (10) primary key, a_date varchar(20), pcost number (8, 2));


create table account2
(ac_no number (10) primary key, a_date varchar(20), pcost number (8, 2));


create table account3
(ac_no number (10) primary key, a_date varchar(20), pcost number (8, 2));


Create table prodacc1
(ac_no  number(10) primary key, prod_id varchar(10),pcost (8,2), foreign key (ac_no) references account1, foreign key (prod_id) references product);


Create table prodacc2
(ac_no  number(10) primary key, prod_id varchar(10),pcost (8,2),foreign key (ac_no) references account2, foreign key (prod_id) references product);


Create table prodacc3
(ac_no  number(10) primary key, prod_id varchar(10),pcost (8,2),foreign key (ac_no) references account3, foreign key (prod_id) references product);


create table checks
(e_name varchar (20), prod_id varchar (10) primary key, 
foreign key (prod_id) references product, foreign key (e_name) references quality_control);


create table maintains (ac_no number(10),prod_id varchar(10) primary key,
foreign key (ac_no) references accounts, foreign key (prod_id) references products);


create table produces(e_name varchar (20), prod_id varchar (10) primary key, 
foreign key (prod_id) references product, foreign key (e_name) references worker);


create table repairs
(e_name varchar (20), prod_id varchar (10) primary key, r_date varchar(20),
foreign key (prod_id) references product, foreign key (e_name) references tech_staff);


create table purchase
(prod_id varchar (10), c_name varchar (20), primary key (prod_id, c_name),
foreign key (prod_id) references product, foreign key (c_name) references customer);


create table request
(e_namet varchar (20), e_nameq varchar (20), prod_id varchar(10), primary key (e_namet, e_nameq, prod_id), 
foreign key (e_namet) references tech_staff,  foreign key (e_nameq) references quality_control, 
foreign key (prod_id) references product);


create table accident
(accident_no varchar (10) primary key, workdays_lost number (3), acc_date date);


create table make_complaint
(prod_id varchar(10),c_name varchar (20), complaint_id varchar (10), e_name varchar (20), 
primary key (prod_id, c_name, complaint_id, e_name), foreign key (prod_id) references product, 
foreign key (c_name) references customer, foreign key (complaint_id) references complaint, 
foreign key (e_name) references tech_staff); 


create table maycause
(e_name varchar (20), accident_no varchar (10), prod_id varchar (10), 
primary key (e_name, accident_no, prod_id), foreign key (e_name) references tech_staff, 
foreign key (accident_no) references accident on delete cascade, foreign key (prod_id) references products);


create table maybe
(e_name varchar (20), accident_no varchar (10), prod_id varchar (10), 
primary key (e_name, accident_no, prod_id), foreign key (e_name) references worker, 
foreign key (accident_no) references accident on delete cascade, foreign key (prod_id) references products);


