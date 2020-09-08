alter table categories add column list_id LONG;
alter table categories add foreign key (list_id) references lists (id);


alter table comments add column category_id LONG;
alter table comments add foreign key (category_id) references categories (id);

alter table comments add column list_id LONG;
alter table comments add foreign key (list_id) references lists (id);


alter table tasks add column category_id LONG;
alter table tasks add foreign key (category_id) references categories (id);