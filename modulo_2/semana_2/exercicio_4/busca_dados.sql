select * 
	from university.departamentos;

select * 
	from university.departamentos 
	where nome_dpto 
	ilike '%ciências%';

select nome_dpto, max(cod_dpto) 
	from university.departamentos 
	group by cod_dpto;

--------------------------------------------------
select * 
	from university.cursos;

select * 
	from university.cursos 
	where nom_curso 
	ilike '%bacharel%';

select count (*) 
	from university.cursos 
	where nom_curso 
	ilike '%bacharel%';

--------------------------------------------------
select * 
	from university.alunos;

select * 
	from university.alunos 
	where cotista = 'S' or cotista = 's';

select cotista, count(cotista) 
	from university.alunos 
	group by cotista;

--------------------------------------------------
select * 
	from university.disciplinas;

select * 
	from university.disciplinas 
	where carga_horaria > 54;

select carga_horaria, count(*) 
	from university.disciplinas 
	group by carga_horaria; 

--------------------------------------------------
select * 
	from university.matrizes_cursos;

select * 
	from university.matrizes_cursos 
	where cod_curso = 8;

select cod_curso, count(cod_disc) 
	from university.matrizes_cursos 
	group by cod_curso; 

--------------------------------------------------
select * 
	from university.matriculas;

select * 
	from university.matriculas 
	where status = 'C';

select status, count(*) 
	from university.matriculas 
	group by status; 


