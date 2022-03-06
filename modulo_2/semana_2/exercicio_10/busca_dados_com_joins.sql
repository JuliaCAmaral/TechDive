select 
		c.nom_curso as curso, 
		d.nome_dpto as departamento
	from cursos c
	inner join departamentos d on c.cod_dpto = d.cod_dpto;  
	
----------------------------------------------------------
select 
		a.nome as nome_aluno,
		c.nom_curso as cursos 
	from alunos a 
	left join cursos c on a.cod_curso = c.cod_curso;

----------------------------------------------------------
select 
		a.nome as nome_aluno,
		c.nom_curso as cursos 
	from cursos c 
	right join alunos a on a.cod_curso = c.cod_curso;

----------------------------------------------------------
select 
		a.nome as nome_aluno,
		c.nom_curso as cursos 
	from cursos c 
	full outer join alunos a on a.cod_curso = c.cod_curso
	where a is null;
