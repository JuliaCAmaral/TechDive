CREATE TABLE "TechDive".Aluno (
    IdAluno int PRIMARY KEY,
    Nome text,
    Fone text,
    CPF int,
    DataNascimento date,
    Genero text,
    Ativo bool
);

CREATE TABLE "TechDive".Endereco (
    IdEndereco int PRIMARY KEY,
    Rua text,
    Numero text,
    Bairro text,
    Cidade text,
    Estado text,
    Outros text,
    AlunoId int,
    Ativo bool,
    fk_Aluno_IdAluno int
);
 
ALTER TABLE "TechDive".Endereco ADD CONSTRAINT FK_Endereco_2
    FOREIGN KEY (fk_Aluno_IdAluno)
    REFERENCES Aluno (IdAluno)
    ON DELETE RESTRICT;

CREATE TABLE "TechDive".Curso (
    IdCurso int PRIMARY KEY,
    Nome text,
    Semestre int,
    Ativo bool
);

CREATE TABLE "TechDive".Matricula (
    fk_Curso_IdCurso int,
    fk_Aluno_IdAluno int
);
 
ALTER TABLE "TechDive".Matricula ADD CONSTRAINT FK_Matricula_1
    FOREIGN KEY (fk_Curso_IdCurso)
    REFERENCES Curso (IdCurso)
    ON DELETE RESTRICT;
 
ALTER TABLE "TechDive".Matricula ADD CONSTRAINT FK_Matricula_2
    FOREIGN KEY (fk_Aluno_IdAluno)
    REFERENCES Aluno (IdAluno)
    ON DELETE SET NULL;

CREATE TABLE "TechDive".Professor (
    IdProfessor int PRIMARY KEY,
    Nome text,
    Graduacao text,
    Fone text,
    Ativo bool
);

CREATE TABLE "TechDive".Contrato (
    fk_Professor_IdProfessor int,
    fk_Curso_IdCurso int
);
 
ALTER TABLE "TechDive".Contrato ADD CONSTRAINT FK_Contrato_1
    FOREIGN KEY (fk_Professor_IdProfessor)
    REFERENCES Professor (IdProfessor)
    ON DELETE RESTRICT;
 
ALTER TABLE "TechDive".Contrato ADD CONSTRAINT FK_Contrato_2
    FOREIGN KEY (fk_Curso_IdCurso)
    REFERENCES Curso (IdCurso)
    ON DELETE SET NULL;
