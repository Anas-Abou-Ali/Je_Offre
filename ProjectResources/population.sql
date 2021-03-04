
delete from Images;
/*=======================imgId, offerId, imgpath=====================*/
insert into Images values(1,1,"test2.jpg");
insert into Images values(2,2,"test2.jpg");
insert into Images values(3,3,"test2.jpg");
insert into Images values(4,4,"test2.jpg");


/*=======================senderId, recieverId, idMessage,message, date field automatically filled=====================*/
delete from Messages;
insert into Messages(sender_id_user, idUser,id_message, message ) values(,,1,"test2.jpg");
insert into Messages(sender_id_user, idUser,id_message, message ) values(,,1,"test2.jpg");
insert into Messages(sender_id_user, idUser,id_message, message ) values(,,1,"test2.jpg");




/*=======================offerId, idUser,title ,description, city, category====================*/
delete from Offer;
insert into Offer(offerId, idUser,title, description,city, category) values();




/*=======================idUser, offerId,rate ====================*/
delete from Offer;
insert into Offer(idUser, offerId, rate) values();



/*=======================idUser, username ====================*/
delete from User;
insert into User(idUser, firstName) values();


/*=======================offerId, idUser ====================*/
delete from favoritize;
insert into User(offerId, idUser) values();
