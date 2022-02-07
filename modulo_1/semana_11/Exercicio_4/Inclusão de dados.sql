insert into aluno (Nome, Fone, CPF, DataNascimento, Genero, Ativo) values ('Maria Luiza', '048xxxxxxxxx', 25035605043, '26/05/2000', 'F', true);
insert into aluno (Nome, Fone, CPF, DataNascimento, Genero, Ativo) values ('Luan Figueiredo', '048xxxxxxxxx', 88604936092, '07/04/2001', 'M', true);
insert into aluno (Nome, Fone, CPF, DataNascimento, Genero, Ativo) values ('João Paulo', '047xxxxxxxxx', 88413790069, '28/11/1999', 'M', true);
insert into aluno (Nome, Fone, CPF, DataNascimento, Genero, Ativo) values ('Luana Souza', '048xxxxxxxxx', 52451994088, '03/01/2000', 'F', true);
insert into aluno (Nome, Fone, CPF, DataNascimento, Genero, Ativo) values ('Roberta Santos', '047xxxxxxxxx', 72455170020, '15/06/2000', 'F', true);

insert into Endereco (Rua, Numero, Bairro, Cidade, Estado, Outros, alunoid, Ativo) values ('Rua José Nazareno Coelho', 'xxxx', 'João Paulo', 'Florianópolis', 'SC', 'Casa', 1, true);
insert into Endereco (Rua, Numero, Bairro, Cidade, Estado, Outros, alunoid, Ativo) values ('Rua Gentil Leandro dos Santos', 'xxxx', 'Carvoeira', 'Florianópolis', 'SC', 'Casa', 2, true);
insert into Endereco (Rua, Numero, Bairro, Cidade, Estado, Outros, alunoid, Ativo) values ('Rua Vinícius de Moraes', 'xxxx', 'Ponte do Imaruim', 'Palhoça', 'SC', 'Casa', 3, true);
insert into Endereco (Rua, Numero, Bairro, Cidade, Estado, Outros, alunoid, Ativo) values ('Rua Lauri de Souza Barbosa', 'xxxx', 'Ipiranga', 'São José', 'SC', 'Apto 601, Bloco A ', 4, true);
insert into Endereco (Rua, Numero, Bairro, Cidade, Estado, Outros, alunoid, Ativo) values ('Rua Manoel Florêncio da Cunha', 'xxxx', 'Rio Caveiras', 'Biguaçú', 'SC', 'Casa', 5, true);

insert into Curso (Nome, Semestre, Ativo) values ('Técnico em Têxtil', 1, true);
insert into Curso (Nome, Semestre, Ativo) values ('Técnico em Qualidade', 2, true);
insert into Curso (Nome, Semestre, Ativo) values ('Técnico em Desenvolvimento de Sistemas', 3, true);
insert into Curso (Nome, Semestre, Ativo) values ('Técnico em Segurança do Trabalho', 2, true);
insert into Curso (Nome, Semestre, Ativo) values ('Técnico em Eletromecânica', 1, true);

insert into Professor (Nome, Graduacao, Fone, Ativo) values ('Giovana Fernandez', 'Engenharia Química', '048xxxxxxxxx', true);
insert into Professor (Nome, Graduacao, Fone, Ativo) values ('Luiz Antônio', 'Bacharel em Química', '048xxxxxxxxx', true);
insert into Professor (Nome, Graduacao, Fone, Ativo) values ('Rafaela Costa', 'Sistemas da Informação', '047xxxxxxxxx', true);
insert into Professor (Nome, Graduacao, Fone, Ativo) values ('Guilherme Alves', 'Engenharia de Produção', '048xxxxxxxxx', true);
insert into Professor (Nome, Graduacao, Fone, Ativo) values ('Paulo Oliveira', 'Engenheira Mecânica', '049xxxxxxxxx', true);
