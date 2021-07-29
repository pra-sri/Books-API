drop database if exists mphasisbook_db;
create database mphasisbook_db;
use  mphasisbook_db;


create table book(
     book_id int primary key,
     title varchar(200),
     authors varchar(50),
     average_rating float(5,3),
     isbn varchar(15),
     language_code varchar(6),
     rating_count int,
     price int
     );
    
    
 insert into Book values(1,"Harry Potter and the Half-Blood Prince (Harry Potter  #6)","J.K. Rowling-Mary GrandPr�",4.56,"439785960","eng",1944099,230);