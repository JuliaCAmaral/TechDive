CREATE TABLE TechDive.Disciplina (
    Id          serial PRIMARY KEY,
    Nome        text,
    ProfessorId int NOT NULL,
    CursoId     int NOT NULL,
    CONSTRAINT Disciplina_Professor_fk
        FOREIGN KEY(ProfessorId)
        REFERENCES TechDive.Professor(Id)
            ON DELETE CASCADE,
    CONSTRAINT Disciplina_Curso_fk
        FOREIGN KEY(CursoId)
        REFERENCES TechDive.Curso(Id)
            ON DELETE CASCADE
);

insert into techdive.Disciplina (ProfessorId, CursoId, Nome) values
    (1,1, 'Introdução a Indústria 4.0'),
    (2,2, 'Monitoramento de Produtos, Processos e Indicadores de Desempenho'),
    (3,3, 'Modelagem de Sistemas'),
    (4,4, 'Rotinas de Segurança e Saúde no Trabalho'),
    (5,5, 'Introdução a Fabricação Mecânica');
