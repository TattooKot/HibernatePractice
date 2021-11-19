create table if not exists writers(
    id serial,
    firstName varchar(50),
    lastName varchar(50)
);

create table if not exists writers_posts(
    writer_id integer,
    posts_id integer
);