delete from message;
insert into message(id, text, tag, user_id) values
(1, 'first', 'tag', 1),
(2, 'second', 'tag1', 1),
(3, 'third', 'tag', 1),
(4, 'fourth', 'tag2', 1);

alter sequence hibernate_sequence restart with 10;