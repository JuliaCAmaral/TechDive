-- 1) Listar o número total de reprovações dos alunos cotistas em disciplinas;
select 
		d.nome_disc as Disciplina, 
		count(*) as Cotistas_reprovados 
	from disciplinas d
	join matriculas m on m.cod_disc = d.cod_disc
	join alunos a on a.mat_alu = m.mat_alu 
	where a.cotista = 's' and m.status = 'R'
	group by d.nome_disc
	order by Cotistas_reprovados desc; 

-- 2) Listar o número total de matrículas de alunos cotistas em disciplinas;
select 
		d.nome_disc as Disciplina, 
		count(*) as Cotistas 
	from disciplinas d
	join matriculas m on m.cod_disc = d.cod_disc
	join alunos a on a.mat_alu = m.mat_alu 
	where a.cotista = 's'
	group by d.nome_disc
	order by Cotistas desc; 

