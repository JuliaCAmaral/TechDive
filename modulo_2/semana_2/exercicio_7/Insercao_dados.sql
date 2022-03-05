insert into university.departamentos (nome_dpto) values ('Centro de Ciências Biológicas (CCB)'				);
insert into university.departamentos (nome_dpto) values ('Centro de Comunicação e Expressão (CCE)'			);
insert into university.departamentos (nome_dpto) values ('Centro de Ciências da Saúde (CCS)'				);
insert into university.departamentos (nome_dpto) values ('Centro de Ciências Jurídicas (CCJ)'				);
insert into university.departamentos (nome_dpto) values ('Centro de Desportos (CDS)'						);
insert into university.departamentos (nome_dpto) values ('Centro de Ciências da Educação (CED)'				);
insert into university.departamentos (nome_dpto) values ('Centro de Filosofia e Ciências Humanas (CFH)'		);
insert into university.departamentos (nome_dpto) values ('Centro de Ciências Físicas e Matemáticas (CFM)'	);
insert into university.departamentos (nome_dpto) values ('Centro Socioeconômico (CSE)'						);
insert into university.departamentos (nome_dpto) values ('Centro Tecnológico (CTC)'							);

insert into university.cursos (nom_curso, cod_dpto) values ('Farmácia', 						1);
insert into university.cursos (nom_curso, cod_dpto) values ('Jornalismo', 						2);
insert into university.cursos (nom_curso, cod_dpto) values ('Odontologia', 						3);
insert into university.cursos (nom_curso, cod_dpto) values ('Direito', 							4);
insert into university.cursos (nom_curso, cod_dpto) values ('Licenciado em Educação Física',	5);
insert into university.cursos (nom_curso, cod_dpto) values ('Ciência da Informação', 			6);
insert into university.cursos (nom_curso, cod_dpto) values ('Psicologia', 						7);
insert into university.cursos (nom_curso, cod_dpto) values ('Bacharelado em Física', 			8);
insert into university.cursos (nom_curso, cod_dpto) values ('Administração', 					9);
insert into university.cursos (nom_curso, cod_dpto) values ('Engenharia Civil', 				10);

insert into university.alunos (nome, dat_entrada, cod_curso, cotista) values ('Adriana Cruz', 		'2022-03-07', 1, 's');
insert into university.alunos (nome, dat_entrada, cod_curso, cotista) values ('Bruno Souza', 		'2021-08-25', 2, 'n');
insert into university.alunos (nome, dat_entrada, cod_curso, cotista) values ('Carolina Ferreira', 	'2020-08-25', 3, 's');
insert into university.alunos (nome, dat_entrada, cod_curso, cotista) values ('Daniel Santos', 		'2022-03-07', 4, 'n');
insert into university.alunos (nome, dat_entrada, cod_curso, cotista) values ('Emílio Luiz', 		'2020-08-25', 5, 'n');
insert into university.alunos (nome, dat_entrada, cod_curso, cotista) values ('Fernanda Moraes', 	'2019-08-25', 6, 'n');
insert into university.alunos (nome, dat_entrada, cod_curso, cotista) values ('Guilherme Pinheiro',	'2018-08-25', 7, 'n');
insert into university.alunos (nome, dat_entrada, cod_curso, cotista) values ('Ian Duarte', 		'2022-03-07', 8, 'n');
insert into university.alunos (nome, dat_entrada, cod_curso, cotista) values ('Joana Fontes', 		'2021-03-07', 9, 'n');
insert into university.alunos (nome, dat_entrada, cod_curso, cotista) values ('Mariana Oliveira',	'2020-08-25', 10, 's');

insert into university.disciplinas (nome_disc, carga_horaria) values ('Anatomia Aplicada à Educação Física',	72);
insert into university.disciplinas (nome_disc, carga_horaria) values ('Aprendizagem e Controle Motor',			72);
insert into university.disciplinas (nome_disc, carga_horaria) values ('Educação Física Adaptada', 				72);
insert into university.disciplinas (nome_disc, carga_horaria) values ('Cálculo I', 								108);
insert into university.disciplinas (nome_disc, carga_horaria) values ('Física Computacional', 					72);
insert into university.disciplinas (nome_disc, carga_horaria) values ('Mecânica Quântica I', 					72);
insert into university.disciplinas (nome_disc, carga_horaria) values ('Estato Sólido', 							72);
insert into university.disciplinas (nome_disc, carga_horaria) values ('Biologia Celular e Embriologia ', 		54);
insert into university.disciplinas (nome_disc, carga_horaria) values ('Fisiologia II ', 						72);
insert into university.disciplinas (nome_disc, carga_horaria) values ('Patologia ', 							32);

insert into university.matrizes_cursos (cod_curso, cod_disc, periodo) values (5, 1, 1);
insert into university.matrizes_cursos (cod_curso, cod_disc, periodo) values (5, 2, 2);
insert into university.matrizes_cursos (cod_curso, cod_disc, periodo) values (5, 3, 4);
insert into university.matrizes_cursos (cod_curso, cod_disc, periodo) values (8, 4, 1);
insert into university.matrizes_cursos (cod_curso, cod_disc, periodo) values (8, 5, 4);
insert into university.matrizes_cursos (cod_curso, cod_disc, periodo) values (8, 6, 6);
insert into university.matrizes_cursos (cod_curso, cod_disc, periodo) values (8, 7, 8);
insert into university.matrizes_cursos (cod_curso, cod_disc, periodo) values (1, 8, 1);
insert into university.matrizes_cursos (cod_curso, cod_disc, periodo) values (1, 9, 3);
insert into university.matrizes_cursos (cod_curso, cod_disc, periodo) values (1, 10, 4);

insert into university.matriculas (semestre, mat_alu, cod_disc, nota, faltas, status) values (1, 1, 1, 8.5, 3, 		'A');
insert into university.matriculas (semestre, mat_alu, cod_disc, nota, faltas, status) values (2, 2, 2, 5.5, 5, 		'R');
insert into university.matriculas (semestre, mat_alu, cod_disc, nota, faltas, status) values (4, 3, 3, 9, 2, 		'A');
insert into university.matriculas (semestre, mat_alu, cod_disc, nota, faltas, status) values (1, 4, 4, 4.5, 1,		'R');
insert into university.matriculas (semestre, mat_alu, cod_disc, nota, faltas, status) values (4, 5, 5, null, null, 	'C');
insert into university.matriculas (semestre, mat_alu, cod_disc, nota, faltas, status) values (6, 6, 6, null, null, 	'C');
insert into university.matriculas (semestre, mat_alu, cod_disc, nota, faltas, status) values (8, 7, 7, 6.5, 8, 		'A');
insert into university.matriculas (semestre, mat_alu, cod_disc, nota, faltas, status) values (1, 8, 8, null, null, 	'C');
insert into university.matriculas (semestre, mat_alu, cod_disc, nota, faltas, status) values (3, 9, 9, null, null, 	'C');
insert into university.matriculas (semestre, mat_alu, cod_disc, nota, faltas, status) values (4, 10, 10, 3.5, 10, 	'R');


