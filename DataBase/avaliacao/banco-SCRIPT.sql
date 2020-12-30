create database banco;

create table curso(
cod_curso int not null auto_increment,
descricao varchar(50) not null,
data_inicio date not null,
data_termino date not null,
quantidade_pessoas int,
categoria int not null,

primary key (cod_curso)

);


create table categoria(
codigo int  not null,
descricao_categoria varchar (50) not null,

primary key (codigo)
);


alter table curso
add foreign key (categoria)
references categoria(codigo);

insert into categoria
values 
(1, 'Comportamental'),
(2, 'Programacao'),
(3, 'Qualidade'),
(4, 'Processos');








