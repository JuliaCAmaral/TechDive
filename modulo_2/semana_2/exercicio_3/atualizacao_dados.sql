update university.departamentos 
	set nome_dpto = 'Centro de Ciências Biológicas' 
	where nome_dpto = 'Centro de Ciências Biológicas (CCB)';

update university.departamentos 
	set nome_dpto = 'Centro de Comunicação e Expressão' 
	where nome_dpto = 'Centro de Comunicação e Expressão (CCE)';

-------------------------------------------------------------------
update university.cursos 
	set nom_curso = 'Bacharel em Farmácia' 
	where nom_curso = 'Farmácia';

update university.cursos 
	set nom_curso = 'Jornalismo Digital'
	where nom_curso = 'Jornalismo';

-------------------------------------------------------------------
update university.alunos 
	set nome = 'Bruno de Souza'
	where nome = 'Bruno Souza';

update university.alunos 
	set dat_entrada = '2021-03-08'
	where dat_entrada = '2021-03-07';
	
-------------------------------------------------------------------
update university.disciplinas
	set carga_horaria = '78'
	where carga_horaria = '72';

update university.disciplinas
	set nome_disc = 'Anatomia Aplicada à Musculatura'
	where nome_disc = 'Anatomia Aplicada à Educação Física';

-------------------------------------------------------------------
update university.matrizes_cursos
	set periodo = 2
	where cod_disc = 1;

update university.matrizes_cursos
	set periodo = 3
	where cod_disc = 10;

-------------------------------------------------------------------
update university.matriculas
	set nota = 6.5, faltas = 5, status = 'A'
	where (mat_alu = 5 and cod_disc = 5);

update university.matriculas
	set nota = 5.5, faltas = 10, status = 'R'
	where (mat_alu = 6 and cod_disc = 6);

select * from university.matriculas;

