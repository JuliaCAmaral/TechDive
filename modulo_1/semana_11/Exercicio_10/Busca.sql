select
	a.nome as "aluno",
	a.fone as "fone_aluno",
	a.cpf,
	a.datanascimento,
	a.genero,
	c.nome as "curso",
	c.semestre,
	p.nome as "professor",
	p.graduacao,
	p.fone as "fone_professor"
from techdive.disciplina d 
inner join techdive.curso c
	on c.id = d.cursoid
inner join techdive.professor p
	on p.id = d.professorid
inner join techdive.matricula m
	on m.cursoid = d.cursoid
inner join techdive.aluno a
	on a.id  = m.alunoid
