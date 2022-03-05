drop schema if exists university cascade;

create schema university;

create table university.departamentos (
	cod_dpto	int primary key,
	nome_dpto	text,
	ativo		boolean not null default true
);

create table university.cursos (
	cod_curso	int primary key,
	nom_curso	text,
	cod_dpto	int,
	ativo		boolean not null default true,
	
	constraint cur_der_fk
		foreign key (cod_dpto)
		references university.departamentos(cod_dpto)
			on delete cascade
);

create table university.alunos (
	mat_alu		int primary key,
	nome		text,
	dat_entrada	date,
	cod_curso	int,
	cotista		char,
	ativo		boolean not null default true,
	
	constraint alu_cur_fk
		foreign key (cod_curso)
		references university.cursos (cod_curso)
			on delete set null
);

create table university.disciplinas (
	cod_disc		int primary key,
	nome_disc		text,
	carga_horaria	decimal,
	ativo			boolean not null default true
);

create table university.matrizes_cursos (
	cod_curso	int,
	cod_disc	int,
	periodo		int,
	ativo		boolean not null default true,
	
	primary key (cod_curso, cod_disc),
	
	constraint mcu_cur_fk
		foreign key (cod_curso)
		references university.cursos (cod_curso)
			on delete cascade,
			
	constraint mcu_dis_fk
		foreign key (cod_disc)
		references university.disciplinas (cod_disc)
			on delete cascade 
);

create table university.matriculas (
	semestre	int,
	mat_alu		int,
	cod_disc	int,
	nota		int,
	faltas		int,
	status		char,
	ativo		boolean not null default true,
	
	primary key (mat_alu, semestre),
	
	constraint mat_alu_fk
		foreign key (mat_alu)
		references university.alunos 
			on delete cascade,
			
	constraint mat_dis_fk
		foreign key (cod_disc)
		references university.disciplinas (cod_disc)
			on delete cascade 
);

--alter table university.matriculas alter nota type decimal;
