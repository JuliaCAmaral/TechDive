select
	c.nome as "curso",
	c.semestre,
	p.nome as "professor",
	p.graduacao,
	p.fone
from techdive.disciplina d 
inner join techdive.curso c
	on c.id = d.cursoid
inner join techdive.professor p
	on p.id = d.professorid
