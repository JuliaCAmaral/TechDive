CREATE TABLE TechDive.Aluno (
    Id              serial PRIMARY KEY,
    Nome            text,
    Fone            text,
    CPF             text,
    DataNascimento  date,
    Genero          text,
    Ativo           bool NOT NULL DEFAULT true
);

CREATE TABLE TechDive.Endereco (
    Id      serial PRIMARY KEY,
    Rua     text,
    Numero  text,
    Bairro  text,
    Cidade  text,
    Estado  text,
    Outros  text,
    AlunoId int NOT NULL,
    Ativo   bool NOT NULL DEFAULT true,
    CONSTRAINT endereco_aluno_fk
        FOREIGN KEY(AlunoId)
        REFERENCES TechDive.Aluno(Id)
            ON DELETE CASCADE
);

CREATE TABLE TechDive.Curso (
    Id          serial PRIMARY KEY,
    Nome        text,
    Semestre    int,
    Ativo       bool NOT NULL DEFAULT true
);

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

CREATE TABLE TechDive.Professor (
    Id          serial PRIMARY KEY,
    Nome        text,
    Graduacao   text,
    Fone        text,
    Ativo       bool NOT NULL DEFAULT true
);

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
