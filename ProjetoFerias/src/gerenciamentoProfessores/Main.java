package gerenciamentoProfessores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);

    private static final Escola escola = new Escola();

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(final String[] args) {

        while (true) {
            String opcao = lerOpcao();

            try {
                switch (opcao) {
                    case "1":
                        novoDocente();
                        break;

                    case "2":
                        novaTurma();
                        break;

                    case "3":
                        inserirConteudo();
                        break;   

                    case "4":
                        ensalarTurma();
                        break;

                    case "5":
                        listarTurmas();
                        break;

                    case "6":
                        listarDocentes();
                        break;

                    case "7":
                        informacoesTurma();
                        break;

                    case "8":
                        listarCronogramaTurma();
                        break;

                    case "9":
                        listarCronogramaDocente();
                        break;

                    case "0":
                        System.out.println("Encerrando...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (opcao.equals("0")) {
                break;

            } else {

                System.out.println("\n\n----------------------------");
                System.out.println("Digite enter para continuar.");
                System.out.println("----------------------------\n\n");
                input.nextLine();
            }
        }
    }

    private static void novoDocente() {

        System.out.println("Digite o nome do docente: ");
        String nome = input.nextLine();

        int idDocente = escola.addDocente(nome);

        Docente docente = escola.getDocente(idDocente);

        System.out.println("Novo docente cadastrado com sucesso.");
        System.out.printf("O docente %s - matrícula: %05d", docente.getNome(), idDocente);
    }

    private static void novaTurma() {

        System.out.println("Digite o nome da turma: ");
        String nome = input.nextLine();

        System.out.println("Digite a quantidade de alunos da turma: ");
        int quantidadeAlunos = lerInt();

        System.out.println("Digite a data do inicio da turma, deve ser segunda-feira [dd/MM/yyyy]: ");
        String str = input.nextLine();
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataInicio = LocalDate.parse(str, dtf);

        int idTurma = escola.addTurma(nome, quantidadeAlunos, dataInicio);

        Turma turma = escola.getTurma(idTurma);

        System.out.println("Nova turma cadastrada com sucesso.");
        System.out.printf("A turma %s - código: %05d", turma.getNome(), idTurma);
    }

    private static void inserirConteudo() {
        System.out.println("Digite o código da turma: ");
        int idTurma = lerInt();

        Turma turma = escola.getTurma(idTurma);

        while (true) {
            if (turma.getSemanasDisponiveis() == 0) {
                System.out.println("Não há semana disponível para cadastrar um novo assunto. A duração da turma não poderá ultrapassar 12 meses.");
                break;
            }

            System.out.println("Digite o título do assunto: ");
            String titulo = input.nextLine();

            System.out.println("Quantas semanas este assunto será abortado? ");
            int duracao = lerInt();

            turma.addAssunto(titulo, duracao);

            if (turma.getSemanasDisponiveis() != 0) {
                System.out.printf("Ainda há %s semanas disponíveis.%n",turma.getSemanasDisponiveis());

                System.out.println("Pressione qualquer tecla para inserir novo conteúdo. Caso ao contrário, digite 0: ");

                String opcao = input.nextLine();

                if (opcao.equals("0")) {
                    System.out.printf("O planejamento de conteúdo da turma %s foi atualizado com sucesso.", turma.getNome());
                    break;
                }
            } else {
                System.out.printf("O planejamento de conteúdo da turma %s foi atualizado com sucesso.", turma.getNome());
                break;
            }
        }
    }

    private static void ensalarTurma() {
        System.out.println("Digite o código da turma: ");
        int idTurma = lerInt();

        Turma turma = escola.getTurma(idTurma);

        if (turma.getDocentes().length >= 2) {
            throw new RuntimeException("A turma já possui 2 docentes cadastrados.");
        }

        System.out.println("Digite a matrícula do docente: ");
        int idDocente = lerInt();

        Docente docente = escola.getDocente(idDocente);

        escola.ensalarTurma(idDocente, idTurma);

        System.out.printf("O docente %s foi definido para ministrar a turma %s.", docente.getNome(), turma.getNome());

    }

    private static void listarTurmas() {

        Turma[] turmas = escola.getTurmas();

        for (Turma turma : turmas) {
            System.out.printf("Código: %05d - Nome: %s - Quantidade de alunos: %s%n", turma.getIdentificacao(), turma.getNome(), turma.getQuantidadeAlunos());
        }

        if (turmas.length == 0) {
            System.out.println("Nenhuma turma cadastrada.");
        }
    }

    private static void listarDocentes() {

        Docente[] docentes = escola.getDocentes();

        for (Docente docente : docentes) {
            System.out.printf("Matrícula: %05d - Nome: %s%n", docente.getIdentificacao(), docente.getNome());
        }

        if (docentes.length == 0) {
            System.out.println("Nenhum docente cadastrado.");
        }
    }

    private static void informacoesTurma() {

        System.out.println("Digite o código da turma: ");
        int idTurma = lerInt();

        Turma turma = escola.getTurma(idTurma);

        System.out.printf("%nNome da turma: %s%n", turma.getNome());

        System.out.print("Docente(s): ");

        if (turma.getDocentes().length != 0) {
            Docente[] docentes = turma.getDocentes();

            for (Docente docente: docentes) {
                System.out.print(docente.getNome() + "; ");
            }

        } else {
            System.out.print("Não há docentes cadastrados na turma.");
        }

        System.out.printf("%nQuantidade de alunos: %s%n", turma.getQuantidadeAlunos());

        System.out.printf("%nPeríodo da turma: %s até %s%n", dtf.format(turma.getDataInicio()), dtf.format(turma.getDataFinal()));

        System.out.println("\n-------- Planejamento de conteúdos --------\n");

        Assunto[] assuntos = turma.getAssuntos();

        for (Assunto assunto: assuntos) {
            System.out.printf("%s até %s - Assunto: %s%n", dtf.format(assunto.getDataInicio()), dtf.format(assunto.getDataFinal()), assunto.getDescricao());
        }

        if (assuntos.length == 0) {
            System.out.println("Nenhum assunto cadastrado na turma.");
        }
    }

    private static void listarCronogramaTurma() {
        System.out.println("Digite o código da turma: ");

        int idTurma = lerInt();

        Turma turma = escola.getTurma(idTurma);

        System.out.printf("%nNome da turma: %s - Período da turma: %s até %s%n", turma.getNome(), dtf.format(turma.getDataInicio()), dtf.format(turma.getDataFinal()));

        for (Aula aula : turma.getAulas()) {

            System.out.printf("%s - Assunto: %s - Docente: %s%n", dtf.format(aula.getDia()), aula.getDescricaoAssunto(), aula.getNomeDocente());

        }
    }

    private static void listarCronogramaDocente() {
        System.out.print("Digite a matrícula do docente: ");

        int idDocente = lerInt();

        Docente docente = escola.getDocente(idDocente);

        if (docente.getTurmasAtendidas().size() != 0) {
            System.out.printf("%nO docente %s está vinculado as seguintes turmas:%n", docente.getNome());

            for (Turma turma : docente.getTurmasAtendidas()) {
                System.out.printf("%nNome da turma: %s - Período da turma: %s até %s%n", turma.getNome(), dtf.format(turma.getDataInicio()), dtf.format(turma.getDataFinal()));

                for(Aula aula : turma.getAulas()) {
                    if (aula.getDocente() == docente){
                        System.out.printf("%s - Turma: %s - Assunto: %s.%n", dtf.format(aula.getDia()), turma.getNome(),aula.getDescricaoAssunto());

                    }
                }
            }
        } else {
            System.out.println("\nO docente não possui turmas cadastradas.");
        }
    }

    private static String lerOpcao() {
        System.out.println("Digite:");
        System.out.println("1 - Cadastrar docente");
        System.out.println("2 - Cadastrar turma");
        System.out.println("3 - Inserir conteúdo da turma");
        System.out.println("4 - Definir docentes para uma turma");
        System.out.println("5 - Listar todas as turmas");
        System.out.println("6 - Listar todos os docentes");
        System.out.println("7 - Exibir informações da turma");
        System.out.println("8 - Exibir cronograma da turma");
        System.out.println("9 - Exibir cronograma do docente");
        System.out.println("0 - Sair");

        return input.nextLine();
    }

    private static int lerInt() {
       while (true) {
           String line = input.nextLine().trim();
           try {
               return Integer.parseInt(line);

           } catch (NumberFormatException e) {
               System.out.println("Valor incorreto, digite novamente um número inteiro.");
           }
       }
    }

}
