alter table tasks add column user_id LONG;
alter table tasks add foreign key (user_id) references users (id);

alter table lists add column user_id LONG;
alter table lists add foreign key (user_id) references users (id);

alter table categories add column user_id LONG;
alter table categories add foreign key (user_id) references users (id);

alter table comments add column user_id LONG;
alter table comments add foreign key (user_id) references users (id);