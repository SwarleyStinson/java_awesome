select
       'Post' || 'greSQL', -- PostgreSQL
       'Value: ' || 42;    -- Value: 42

select char_length('Hello World');  -- 11
select length('Hello World');       -- 11
select lower('HeLlO');              -- hello
select upper('HeLlO');              -- HELLO

select overlay('Hello World from XXX' placing 'James' from 18 for 3);

select trim(both 'xyz' from 'yxTHOMASxx');
select trim(' hi    ');

select concat('first', '_second', null, '_third');

select replace('Hello, XXXX', 'XXXX', 'World');  -- Hello, World
select format('Hello, %s', 'World');
select format('|%-10s|', 'foo');    -- |foo       |
select format('Testing %3$s, %2$s, %1$s', 'one', 'two', 'three'); -- Testing three, two, one

select 'abc' like '%b%';                    -- true
select 'prefix_abc' similar to 'prefix%';   -- true
select 'prefix_abc' ~ 'prefix.*';           -- true
select 'PrEfiX_abc' ~* 'prefix.*';          -- true   CASE INSENSITIVE



