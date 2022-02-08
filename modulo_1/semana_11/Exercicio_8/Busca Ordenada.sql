select * from techdive.aluno a
left join techdive.endereco e
	on e.alunoid = a.id
order by a.nome
