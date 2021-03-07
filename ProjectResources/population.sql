/*=======================idUser, username ====================*/
delete from User;
insert into User(idUser, firstName) values('3236914126410485', 'Rida Abd Lghani');
insert into User(idUser, firstName) values('0001', 'user01');
insert into User(idUser, firstName) values('0002', 'user02');



/*=======================senderId, recieverId, idMessage,message, date field automatically filled=====================*/
delete from Messages;
insert into Messages(sender_id_user, idUser, message ) values('3236914126410485','0001','hi interrested in your offer mate');
insert into Messages(sender_id_user, idUser, message ) values('0001','3236914126410485','ok pass by at noon in 4th street, prince palace, Casa');
insert into Messages(sender_id_user, idUser, message ) values('0002', '3236914126410485', 'sorry offer still available sir');




/*=======================offerId, idUser,title ,description, city, category====================*/
delete from Offer;
insert into Offer(offerId, idUser,title, description,city, category) values(1, "0001", "smartphone bon état", "galaxy S2 si quelqu'un interessé", 1, 3);
insert into Offer(offerId, idUser,title, description,city, category) values(2, "0001", "pc bon état", "Pc hp dual core si quelqu'un interessé 06000000", 2, 3);
insert into Offer(offerId, idUser,title, description,city, category) values(3, "3236914126410485", "vêtement pour enfant", "une chemise et pantalon pour un enfant age de 6 ans veuillez me contacter si vous êtes interessés", 3, 2);
insert into Offer(offerId, idUser,title, description,city, category) values(4, "3236914126410485", "bicyclette", "bicyclette pour un adult demande un peu de maintenace mais bon c'etait ma propre bicyclette quelqu'un me contacter ce week-end", 1, 5);
insert into Offer(offerId, idUser,title, description,city, category) values(5, "3236914126410485", "chemise des fêtes", "une belle chemise. encore en bon état.", 1, 2);

delete from Images;
/*=======================imgId, offerId, imgpath=====================*/
insert into Images values(1,1,"test2.jpg");
insert into Images values(2,2,"test2.jpg");
insert into Images values(3,3,"test2.jpg");
insert into Images values(4,4,"test2.jpg");
insert into Images values(5,5,"test2.jpg");



/*=======================idUser, offerId,rate ====================*/
delete from Ratings;
insert into Ratings(idUser, offerId, rate) values('3236914126410485', 1, 'D');
insert into Ratings(idUser, offerId, rate) values('3236914126410485', 2, 'U');




/*=======================offerId, idUser ====================*/
delete from favoritize;
insert into favoritize(offerId, idUser) values(1, '3236914126410485');
insert into favoritize(offerId, idUser) values(2, '3236914126410485');
