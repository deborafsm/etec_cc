create database controlecomissao;
use controlecomissao;
create table vendedor(
	id_vendedor int auto_increment primary key,
    nome varchar(200),
    salario double
);
select * from vendedor;

insert into vendedor (nome,salario) values("Teste1" ,100000);
insert into vendedor (nome,salario) values("Teste2" ,34141);
insert into vendedor (nome,salario) values("Teste3" ,5252);
insert into vendedor (nome,salario) values("Teste4" ,4141);