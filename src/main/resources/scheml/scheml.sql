create database carServiceCenter;

use carServiceCenter;

create table login(
                      firstName varchar(15),
                      lastName varchar(15),
                      userName varchar(35) primary key ,
                      password varchar(155)
);

create table user(
                     userId varchar(35) primary key ,
                     userName varchar(155),
                     constraint foreign key (userName) references login(userName),
                     address text not null,
                     tel varchar(15) not null

);

create table customer(
                         customerNIC varchar(35) primary key ,
                         customerName varchar(155) not null,
                         address text not null,
                         tel varchar(15) not null,
                         email varchar(30) not null
);

create table customerManage(
                               userId varchar(35),
                               constraint foreign key (userId) references user(userId),
                               customerNIC varchar(35),
                               constraint foreign key (customerNIC) references customer(customerNIC)

);

create table repairCar(
                          repairId varchar(35) primary key ,
                          repairType varchar(155) not null,
                          repairPrice double not null,
                          customerNIC varchar(35),
                          constraint foreign key (customerNIC) references customer(customerNIC)

);

create table item(
                     itemId varchar(35) primary key ,
                     itemName varchar(155) not null,
                     itemPrice double not null,
                     quantity int not null
);

create table repairItem(
                           itemId varchar(35),
                           constraint foreign key (itemId) references item(itemId),
                           repairId varchar(35),
                           constraint foreign key (repairId) references repairCar(repairId)

);

create table booking(
                        bookId varchar(35) primary key ,
                        bookType varchar(155) not null,
                        customerNIC varchar(35),
                        constraint foreign key (customerNIC) references customer(customerNIC),
                        date date not null

);

create table payment(
                        paymentId varchar(35) primary key ,
                        paymentTotal double not null,
                        paymentDate date,
                        payemtnDescription varchar(120),
                        bookId varchar(35),
                        constraint foreign key (bookId) references booking(bookId)
);