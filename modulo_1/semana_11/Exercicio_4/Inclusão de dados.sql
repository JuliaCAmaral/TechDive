insert into techdive.Aluno (Nome, Fone, CPF, DataNascimento, Genero) values
    ('Maria Luiza', '048xxxxxxxxx', 25035605043, '26/05/2000', 'F'),
    ('Luan Figueiredo', '048xxxxxxxxx', 88604936092, '07/04/2001', 'M'),
    ('João Paulo', '047xxxxxxxxx', 88413790069, '28/11/1999', 'M'),
    ('Luana Souza', '048xxxxxxxxx', 52451994088, '03/01/2000', 'F'),
    ('Roberta Santos', '047xxxxxxxxx', 72455170020, '15/06/2000', 'F');

insert into techdive.Endereco (Rua, Numero, Bairro, Cidade, Estado, Outros, AlunoId) values
    ('Rua José Nazareno Coelho', 'xxxx', 'João Paulo', 'Florianópolis', 'SC', 'Casa', 1),
    ('Rua Gentil Leandro dos Santos', 'xxxx', 'Carvoeira', 'Florianópolis', 'SC', 'Casa', 2),
    ('Rua Vinícius de Moraes', 'xxxx', 'Ponte do Imaruim', 'Palhoça', 'SC', 'Casa', 3),
    ('Rua Lauri de Souza Barbosa', 'xxxx', 'Ipiranga', 'São José', 'SC', 'Apto 601, Bloco A ', 4),
    ('Rua Manoel Florêncio da Cunha', 'xxxx', 'Rio Caveiras', 'Biguaçú', 'SC', 'Casa', 5);

insert into techdive.Curso (Nome, Semestre) values
    ('Técnico em Têxtil', 1),
    ('Técnico em Qualidade', 2),
    ('Técnico em Desenvolvimento de Sistemas', 3),
    ('Técnico em Segurança do Trabalho', 2),
    ('Técnico em Eletromecânica', 1);

insert into techdive.Professor (Nome, Graduacao, Fone) values
    ('Giovana Fernandez', 'Engenharia Química', '048xxxxxxxxx'),
    ('Luiz Antônio', 'Bacharel em Química', '048xxxxxxxxx'),
    ('Rafaela Costa', 'Sistemas da Informação', '047xxxxxxxxx'),
    ('Guilherme Alves', 'Engenharia de Produção', '048xxxxxxxxx'),
    ('Paulo Oliveira', 'Engenheira Mecânica', '049xxxxxxxxx');
