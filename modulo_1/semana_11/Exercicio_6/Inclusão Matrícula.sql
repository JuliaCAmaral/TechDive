CREATE TABLE TechDive.Matricula (
    CursoId int NOT NULL,
    AlunoId int NOT NULL,
    CONSTRAINT Matricula_Curso_fk
        FOREIGN KEY(CursoId)
        REFERENCES TechDive.Curso(Id)
            ON DELETE CASCADE,
    CONSTRAINT Matricula_Aluno_fk
        FOREIGN KEY(AlunoId)
        REFERENCES TechDive.Aluno(Id)
            ON DELETE CASCADE
);

insert into techdive.Matricula (CursoId, AlunoId) values
    (1,1),
    (1,4),
    (2,2),
    (2,3),
    (3,1),
    (3,5),
    (4,3),
    (4,5),
    (5,2),
    (5,4);

