drop schema if exists university cascade;

create schema university;

create table university.departamentos (
	cod_dpto	serial primary key,
	nome_dpto	text
);

create table university.cursos (
	cod_curso	serial primary key,
	nom_curso	text,
	cod_dpto	int
);

create table university.alunos (
	mat_alu		serial primary key,
	nome		text,
	dat_entrada	date,
	cod_curso	int,
	cotista		char
);

create table university.disciplinas (
	cod_disc		serial primary key,
	nome_disc		text,
	carga_horaria	decimal
);

create table university.matrizes_cursos (
	cod_curso	int,
	cod_disc	int,
	periodo		int,
	
	primary key (cod_curso, cod_disc)
);

create table university.matriculas (
	semestre	int,
	mat_alu		int,
	cod_disc	int,
	nota		int,
	faltas		int,
	status		char,

	primary key (mat_alu, semestre)
);

--alter table university.matriculas alter nota type decimal;
