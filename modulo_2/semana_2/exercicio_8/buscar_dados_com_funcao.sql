-- 1) Listar o número total de alunos em cada curso e ordenar os cursos por ordem decrescente;
select c.cod_curso as codigo, c.nom_curso as Curso, count(*) as Alunos_matriculados from cursos c 
	join alunos a on a.cod_curso = c.cod_curso
	group by c.cod_curso, c.nom_curso
	order by Alunos_matriculados desc; 

-- 2) Listar a soma de faltas em cada disciplina e ordenar as disciplinas por ordem decrescente;
select d.nome_disc as Disciplina, sum(m.faltas) as Somatorio_de_faltas from disciplinas d
	join matriculas m on m.cod_disc = d.cod_disc
	group by d.nome_disc
	order by Somatorio_de_faltas desc; 
