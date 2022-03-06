-- Remoção de um dado da tabela 
delete from university.alunos where mat_alu = 5;

-- Remoção dos dados de cada tabela
truncate university.alunos;

truncate university.cursos;

truncate university.departamentos;

truncate university.disciplinas;

truncate university.matriculas;

truncate university.matrizes_cursos;

-- Remoção de uma tabela
drop table university.alunos;

-- Remoção de todas as tabelas do schema
drop schema university cascade;

