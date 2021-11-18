create table if not exists posts(
    id serial not null,
    content varchar(10000) not null,
    created date not null,
    updated date not null,
    status integer
);

create table if not exists labels_posts(
  label_id integer,
  post_id integer
);