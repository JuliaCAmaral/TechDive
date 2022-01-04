package gerenciamentoProfessores;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

public class Turma {

    private int identificacao;

    private int quantidadeAlunos;

    private String nome;

    private LocalDate dataInicio;

    private ArrayList<Assunto> assuntos = new ArrayList<Assunto>();

    private ArrayList<Docente> docentes = new ArrayList<Docente>();

    private static final int duracaoMaxima = 52;

    public Turma(String nome, int quantidadeAlunos, LocalDate dataInicio) {
        this.nome = nome;
        this.quantidadeAlunos = quantidadeAlunos;

        if (!isMonday(dataInicio)) {
            throw new RuntimeException("A turma deverá iniciar apenas na segunda-feira.");
        }

        this.dataInicio = dataInicio;
    }

    public void addDocentes(Docente docente) {
        docentes.add(docente);
    }

    public void addAssunto(String titulo, int duracao) {
        int total = duracaoMaxima - getSemanasDisponiveis();

        int dias = 7 * total;

        LocalDate dataInicioAssunto = this.dataInicio.plusDays(dias);

        total += duracao;

        dias = (7 * duracao) - 3;

        LocalDate dataFinalAssunto = dataInicioAssunto.plusDays(dias);

        if (total > duracaoMaxima) {
            throw new RuntimeException("A duração da turma não poderá ultrapassar 12 meses.");
        }

        Assunto novoAssunto = new Assunto(titulo, duracao, dataInicioAssunto, dataFinalAssunto);

        assuntos.add(novoAssunto);
    }

    public Assunto[] getAssuntos() {
        return assuntos.toArray(new Assunto[0]);
    }

    public Docente[] getDocentes() {
        return docentes.toArray(new Docente[0]);
    }

    public List<Aula> getAulas() {
        if (docentes.size() == 0) {
            throw new RuntimeException("\nNão há docentes cadastrados na turma.");
        }

        if (assuntos.size() == 0) {
            throw new RuntimeException("\nNão há assuntos cadastrados na turma.");
        }

        ArrayList<Aula> aulas = new ArrayList<Aula>();

        LocalDate dataFinal = getDataFinal().plusDays(1);

        for (LocalDate data = dataInicio; data.isBefore(dataFinal); data = data.plusDays(1)) {
            DayOfWeek dayOfWeek = getDayOfWeek(data);

            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY){
                continue;
            }

            Docente docente = docentes.size() == 2 && (dayOfWeek == DayOfWeek.THURSDAY || dayOfWeek == DayOfWeek.WEDNESDAY || dayOfWeek == DayOfWeek.FRIDAY) ? docentes.get(1) : docentes.get(0);

            Assunto assunto = getAssunto(data);

            if (assunto == null) {
                break;
            }

            Aula aula = new Aula(data, docente, assunto);
            aulas.add(aula);
        }

        return aulas;
    }

    public int getSemanasDisponiveis() {
        int totalSemanas = 0;

        for (Assunto assunto: assuntos) {
            totalSemanas += assunto.getDuracao();
        }
        return duracaoMaxima - totalSemanas;
    }

    public int getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFinal() {
        int diasTotal = (7 * duracaoMaxima) - 3;

        return dataInicio.plusDays(diasTotal);
    }

    private Assunto getAssunto(LocalDate data) {
        for (Assunto assunto : assuntos) {
            if ((data.isAfter(assunto.getDataInicio()) || data.isEqual(assunto.getDataInicio())) && (data.isBefore(assunto.getDataFinal()) || data.isEqual(assunto.getDataFinal()))){
                return assunto;
            }
        }
        return null;
    }

    private static boolean isMonday(final LocalDate data)
    {
        DayOfWeek day = DayOfWeek.of(data.get(ChronoField.DAY_OF_WEEK));
        return day == DayOfWeek.MONDAY;
    }

    private static DayOfWeek getDayOfWeek(final LocalDate data)
    {
        return DayOfWeek.of(data.get(ChronoField.DAY_OF_WEEK));
    }

}
