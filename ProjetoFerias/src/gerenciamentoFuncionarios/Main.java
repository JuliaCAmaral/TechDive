package gerenciamentoFuncionarios;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);

    private static final Empresa empresa = new Empresa();

    public static void main(String[] args) {

        while (true) {
            String opcao = lerOpcao();

            try {
                switch (opcao) {
                    case "1":
                        novoFuncionario();
                        break;

                    case "2":
                        exibirFuncionario();
                        break;

                    case "3":
                        demitirFuncionario();
                        break;

                    case "4":
                        atualizarInformacoes();
                        break;

                    case "5":
                        listarFuncionarios();
                        break;

                    case "6":
                        listarFuncionariosAtivos();
                        break;

                    case "7":
                        listarFuncionariosInativos();
                        break;

                    case "8":
                        System.out.println("Encerrando...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (opcao.equals("8")) {
                break;

            } else {

                System.out.println("\n----------------------------\n");
                System.out.println("Digite enter para continuar.");
                System.out.println("----------------------------\n\n");
                input.nextLine();
            }
        }
    }

    public static String lerOpcao() {
        System.out.println("Digite:");
        System.out.println("1 - Adicionar funcionário");
        System.out.println("2 - Ver detalhes de um funcionário");
        System.out.println("3 - Demitir funcionário");
        System.out.println("4 - Atualizar informações de um funcionário");
        System.out.println("5 - Listar todos os funcionários");
        System.out.println("6 - Listar somente os funcionários trabalhando");
        System.out.println("7 - Listar somente os funcionários demitidos");
        System.out.println("8 - Sair");

        return input.nextLine();
    }

    public static int lerMatricula() {

        System.out.println("Digite a matrícula do funcionário: ");

        String line = input.nextLine().trim();

        return Integer.parseInt(line);
    }

    public static int exibirFuncionario() {

        int matricula = lerMatricula();

        Funcionario funcionario = empresa.getFuncionario(matricula);

        if ((funcionario instanceof Colaborador)) {
            exibirFuncionario((Colaborador) funcionario);
        }
        if ((funcionario instanceof LiderTecnico)) {
            exibirFuncionario((LiderTecnico) funcionario);
        }
        if ((funcionario instanceof GerenteDeDepartamento)) {
            exibirFuncionario((GerenteDeDepartamento) funcionario);
        }
        if ((funcionario instanceof GerenteGeral)) {
            exibirFuncionario((GerenteGeral) funcionario);
        }

        System.out.println("--------------------------------------");

        return matricula;
    }

    public static void exibirFuncionario(Funcionario funcionario) {

        System.out.println("-------- Dados do funcionário --------");
        System.out.printf("Matrícula: %05d%n", funcionario.getMatricula());
        System.out.printf("Ativo: %s%n", funcionario.isAtivo());
        System.out.printf("Nome: %s%n", funcionario.getNome());
        System.out.printf("CPF: %s%n", funcionario.getCpf());
        System.out.printf("Telefone: %s%n", funcionario.getTelefone());
        System.out.printf("Cargo: %s%n", funcionario.getCargo());
        System.out.printf("Salário: R$ %.2f%n", funcionario.getSalario());
    }

    public static void exibirFuncionario(Colaborador colaborador) {

        exibirFuncionario((Funcionario) colaborador);

        System.out.printf("Função: %s%n", colaborador.getFuncao());
        System.out.println(colaborador.getLiderTecnico());
    }

    public static void exibirFuncionario(LiderTecnico liderTecnico) {

        exibirFuncionario((Funcionario) liderTecnico);

        System.out.printf("Setor: %s%n", liderTecnico.getSetor());
        System.out.println(liderTecnico.getGerenteDeDepartamento());
    }

    public static void exibirFuncionario(GerenteDeDepartamento gerenteDeDepartamento) {

        exibirFuncionario((Funcionario) gerenteDeDepartamento);

        System.out.println("Departamento: " + gerenteDeDepartamento.getDepartamento());
        System.out.println(gerenteDeDepartamento.getGerenteGeral());
    }

    public static void exibirFuncionario(GerenteGeral gerenteGeral) {

        exibirFuncionario((Funcionario) gerenteGeral);
    }

    public static void novoFuncionario() {

        System.out.println("\nQual é o cargo do novo funcionário?");
        System.out.println("1 - Gerente Geral");
        System.out.println("2 - Gerente de Departamento");
        System.out.println("3 - Líder Técnico");
        System.out.println("4 - Colaborador");

        String cargo = input.nextLine();

        System.out.println("Digite o nome do funcionário: ");
        String nome = input.nextLine();

        String cpf = lerCpf();

        System.out.println("Digite o telefone do funcionário apenas números com o código de área: ");
        String telefone = input.nextLine();

        double salario = lerSalario();

        switch (cargo) {

            case "1":
                novoGerenteGeral(nome, cpf, telefone, salario);
                break;

            case "2":
                novoGerenteDeDepartamento(nome, cpf, telefone, salario);
                break;

            case "3":
                novoLiderTecnico(nome, cpf, telefone, salario);
                break;

            case "4":
                novoColaborador(nome, cpf, telefone, salario);
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    public static void novoColaborador(String nome, String cpf, String telefone, double salario) {

        Colaborador colaborador = new Colaborador();
        colaborador.setNome(nome);
        colaborador.setCpf(cpf);
        colaborador.setTelefone(telefone);
        colaborador.setSalario(salario);

        System.out.print("Qual será a função do novo colaborador? ");
        String funcao = input.nextLine();
        colaborador.setFuncao(funcao);


        System.out.println("Digite a matrícula do líder técnico do novo colaborador: ");
        String line = input.nextLine().trim();
        int matricula = Integer.parseInt(line);

        Funcionario liderTecnico = empresa.getFuncionario(matricula);

        if (!(liderTecnico instanceof LiderTecnico)) {
            throw new InvalidParameterException("A matrícula digitada não corresponde a um funcionário com cargo de Líder Técnico.");
        }

        if (!(liderTecnico.isAtivo())) {
            throw new InvalidParameterException("Não foi possível cadastrar novo funcionário. Pois o cadastro do líder técnico encontra-se desativado.");
        }

        colaborador.setLiderTecnico((LiderTecnico) liderTecnico);

        empresa.addFuncionario(colaborador);

        System.out.println("Novo funcionário cadastrado com sucesso.");
        System.out.printf("Colaborador: %s, Matrícula: %05d%n", colaborador.getNome(), colaborador.getMatricula());
    }

    public static void novoLiderTecnico(String nome, String cpf, String telefone, double salario) {

        LiderTecnico liderTecnico = new LiderTecnico();
        liderTecnico.setNome(nome);
        liderTecnico.setCpf(cpf);
        liderTecnico.setTelefone(telefone);
        liderTecnico.setSalario(salario);

        System.out.print("Qual será o setor do novo líder técnico? ");
        String setor = input.nextLine();
        liderTecnico.setSetor(setor);

        System.out.println("Digite a matrícula do gerente de departamento do novo líder técnico: ");
        String line = input.nextLine().trim();
        int matricula = Integer.parseInt(line);

        Funcionario gerenteDeDepartamento = empresa.getFuncionario(matricula);

        if (!(gerenteDeDepartamento instanceof GerenteDeDepartamento)) {
            throw new InvalidParameterException("A matrícula digitada não corresponde a um funcionário com cargo de Gerente de Departamento.");
        }

        if (!(gerenteDeDepartamento.isAtivo())) {
            throw new InvalidParameterException("Não foi possível cadastrar novo funcionário. Pois o cadastro do gerente de departamento encontra-se desativado.");
        }

        liderTecnico.setGerenteDeDepartamento((GerenteDeDepartamento) gerenteDeDepartamento);

        empresa.addFuncionario(liderTecnico);

        System.out.println("Novo funcionário cadastrado com sucesso.");
        System.out.printf("Líder Técnico: %s, Matrícula: %05d%n", liderTecnico.getNome(), liderTecnico.getMatricula());
    }

    public static void novoGerenteDeDepartamento(String nome, String cpf, String telefone, double salario) {

        GerenteDeDepartamento gerenteDeDepartamento = new GerenteDeDepartamento();
        gerenteDeDepartamento.setNome(nome);
        gerenteDeDepartamento.setCpf(cpf);
        gerenteDeDepartamento.setTelefone(telefone);
        gerenteDeDepartamento.setSalario(salario);

        System.out.print("Qual será o departamento do novo gerente de departamento? ");
        String departamento = input.nextLine();
        gerenteDeDepartamento.setDepartamento(departamento);

        System.out.println("Digite a matrícula do gerente geral do novo gerente de departamento: ");
        String line = input.nextLine().trim();
        int matricula = Integer.parseInt(line);

        Funcionario gerenteGeral = empresa.getFuncionario(matricula);

        if (!(gerenteGeral instanceof GerenteGeral)) {
            throw new InvalidParameterException("A matrícula digitada não corresponde a um funcionário com cargo de Gerente Geral.");
        }

        if (!(gerenteGeral.isAtivo())) {
            throw new InvalidParameterException("Não foi possível cadastrar novo funcionário. Pois o cadastro do gerente geral encontra-se desativado.");
        }

        gerenteDeDepartamento.setGerenteGeral((GerenteGeral) gerenteGeral);

        empresa.addFuncionario(gerenteDeDepartamento);

        System.out.println("Novo funcionário cadastrado com sucesso.");
        System.out.printf("Gerente de departamento: %s, Matrícula: %05d%n", gerenteDeDepartamento.getNome(), gerenteDeDepartamento.getMatricula());

    }

    public static void novoGerenteGeral(String nome, String cpf, String telefone, double salario) {

        GerenteGeral gerenteGeral = new GerenteGeral();
        gerenteGeral.setNome(nome);
        gerenteGeral.setCpf(cpf);
        gerenteGeral.setTelefone(telefone);
        gerenteGeral.setSalario(salario);

        empresa.addFuncionario(gerenteGeral);

        System.out.println("Novo funcionário cadastrado com sucesso.");
        System.out.printf("Gerente geral: %s, Matrícula: %05d%n", gerenteGeral.getNome(), gerenteGeral.getMatricula());

    }

    public static void demitirFuncionario() {

        int matricula = exibirFuncionario();

        System.out.print("Confirme a demissão do funcionário citado acima [S/n]: ");
        String entrada = input.nextLine();

        if (!(entrada.equals("S") || entrada.equals("s") || entrada.equals("N") || entrada.equals("n"))) {
            throw new InvalidParameterException("\nOpção inválida.");
        }

        if (entrada.equals("S") || entrada.equals("s")) {
            empresa.demitir(matricula);
            System.out.println("\nO processo de demissão foi realizado com sucesso. O cadastro do funcionário foi desativado.");
        }

        if (entrada.equals("N") || entrada.equals("n")) {
            System.out.println("\nO processo de demissão foi cancelado.");
        }
    }

    public static void atualizarInformacoes() {

        int matricula = lerMatricula();
        Funcionario funcionario = empresa.getFuncionario(matricula);

        if (funcionario.isAtivo()) {

            System.out.println("Qual informação precisa ser alterada? ");
            System.out.println("1 - Nome");
            System.out.println("2 - Telefone");
            System.out.println("3 - Salário");

            String opcao = input.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Digite o nome atualizado: ");
                    String novoNome = input.nextLine();
                    empresa.atualizarNome(matricula, novoNome);
                    break;

                case "2":
                    System.out.print("Digite o salário atualizado: ");
                    String novoTelefone = input.nextLine();
                    empresa.atualizaTelefone(matricula, novoTelefone);
                    break;

                case "3":
                    System.out.print("Digite o salário atualizado: ");
                    String line = input.nextLine().trim();
                    double novoSalario = Integer.parseInt(line);
                    empresa.atualizarSalario(matricula, novoSalario);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } else {
                System.out.println("Não é possível fazer alteração em um cadastro desativado.");
        }
    }

    public static void listarFuncionarios() {

        Funcionario[] funcionarios = empresa.getTodos();

        for (Funcionario funcionario : funcionarios) {
            System.out.printf("Matrícula: %05d - Funcionário: %s - Cargo: %s%n", funcionario.getMatricula(), funcionario.getNome(), funcionario.getCargo());
        }

        if (funcionarios.length == 0) {
            System.out.println("Nenhum funcionário cadastrado.");
        }

        System.out.println("\nOperação realizada com sucesso.");
    }

    public static void listarFuncionariosAtivos() {

        List<Funcionario> funcionarios = empresa.getAtivos();

        for (Funcionario funcionario : funcionarios) {
            System.out.printf("Matrícula: %05d - Funcionário: %s - Cargo: %s%n", funcionario.getMatricula(), funcionario.getNome(), funcionario.getCargo());

        }

        if (funcionarios.size() == 0) {
            System.out.println("Nenhum funcionário cadastrado.");
        }

        System.out.println("\nOperação realizada com sucesso.");
    }

    public static void listarFuncionariosInativos() {

        List<Funcionario> funcionarios = empresa.getDemitidos();

        for (Funcionario funcionario : funcionarios) {
            System.out.printf("Matrícula: %05d - Funcionário: %s - Cargo: %s%n", funcionario.getMatricula(), funcionario.getNome(), funcionario.getCargo());
        }

        if (funcionarios.size() == 0) {
            System.out.println("Nenhum funcionário cadastrado.");
        }

        System.out.println("\nOperação realizada com sucesso.");
    }

    public static String lerCpf() {

        System.out.println("Digite o CPF do novo funcionário ou 0 para sair:");

        String entrada = input.nextLine().trim();

        if (entrada.equals("0")){
            throw new InvalidParameterException("Operação abortada.");
        }

        if (!Cpf.valido(entrada)){
            throw new InvalidParameterException("Opção inválida.");

        }
        return entrada;
    }

    public static double lerSalario() {

        System.out.println("Digite o salário do funcionário ou 0 para sair: ");

        String entrada = input.nextLine().trim();

        try {
            double salario = Double.parseDouble(entrada);

            if (salario == 0) {
                throw new InvalidParameterException("Operação abortada.");
            }

            return salario;
        } catch (NumberFormatException e) {
            throw new InvalidParameterException("Opção inválida.");
        }
    }
}
