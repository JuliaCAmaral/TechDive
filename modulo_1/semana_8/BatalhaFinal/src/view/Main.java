package view;

import model.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Seja bem vindo(a) à BATALHA FINAL!");

        Player player = createPlayer();

        clearConsole();

        System.out.println("A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo,\n"
                + "e sob a luz do crepúsculo você está prestes a entrar na fase final da sua missão.\n"
                + "Você olha para o portal à sua frente, e sabe que a partir desse ponto, sua vida mudará para sempre.");

        input.nextLine();

        System.out.println("Memórias do caminho percorrido para chegar até aqui invadem sua mente.\n"
                + "Você se lembra de todos os inimigos já derrotados para alcançar o covil do líder maligno.\n"
                + "Olha para seu equipamento de combate, já danificado e desgastado depois de tantas lutas.\n"
                + "Você está a um passo de encerrar para sempre esse mal.");

        input.nextLine();

        System.out.println("Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.");

        input.nextLine();

        GoalEnum getGoal = readOption(GoalEnum.values(), "Qual sua motivação?");

        clearConsole();

        switch (getGoal) {
            case REVENGE:
                player.setGoalEnum(GoalEnum.REVENGE);
                System.out.println("Imagens daquela noite trágica invadem sua mente.\n"
                        + "Você nem precisa se esforçar para lembrar, pois essas memórias estão sempre presentes,\n"
                        + "mesmo que de pano de fundo, quando você tem outros pensamentos em foco, elas nunca o deixaram.\n"
                        + "Elas são o combustível que te fizeram chegar até aqui.\n"
                        + "E você sabe que não irá desistir até ter vingado a morte\n"
                        + "daqueles que foram - e pra sempre serão - sua fonte de amor e desejo de continuar vivo.\n"
                        + "O maldito líder finalmente pagará por tanto mal causado na vida de tantos\n"
                        + "(e principalmente na sua).");
                break;

            case HONOR:
                player.setGoalEnum(GoalEnum.HONOR);
                System.out.println("Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços abertos,\n"
                        + "bardos criando canções sobre seus feitos heróicos, nobres te presenteando com jóias e diversas riquezas,\n"
                        + "taberneiros se recusando a cobrar por suas bebedeiras e comilanças.\n"
                        + "Desde já, você sente o amor do público, te louvando a cada passo que dá pelas ruas,\n"
                        + "depois de destruir o vilão que tanto assombrou a paz de todos.\n"
                        + "Porém, você sabe que ainda falta o último ato dessa história.\n"
                        + "Você se concentra na missão.\n"
                        + "A glória o aguarda, mas não antes da última batalha.");
                break;
        }

        input.nextLine();

        System.out.println("Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas,\n"
                + "suas mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado.\n"
                + "Você avança pelo portal.");

        input.nextLine();

        System.out.println("A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas.\n"
                + "À sua frente, só é possível perceber que você se encontra em um corredor extenso.\n"
                + "Você só pode ir à frente, ou desistir.");

        YesNoEnum giveUp = readOption(YesNoEnum.values(), "\nDeseja desistir?");

        clearConsole();

        switch (giveUp) {
            case YES:
                System.out.println("O medo invade o seu coração e você sente que ainda não está à altura do desafio.\n"
                        + "Você se volta para a noite lá fora, e corre em direção à segurança.");
                System.exit(0);

            case NO:
                System.out.println("Você caminha, atento a todos os seus sentidos, por vários metros,\n"
                        + "até visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha,\n"
                        + "vindo de dentro de uma porta aberta.");

                System.out.println("Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha,\n"
                        + "e pondera sobre como passar pela porta.");
                break;

        }

        input.nextLine();

        WalkingModeEnum getWalkingDecision = readOption(WalkingModeEnum.values(), "\nComo você deseja passar pela porta?");

        clearConsole();

        switch (getWalkingDecision) {
            case JUMPING:
                System.out.println("Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.");
                break;

            case RUNNING:
                System.out.println("Você respira fundo e desata a correr em direção à sala.\n"
                        + "Quando passa pela porta, sente que pisou em uma pedra solta,\n"
                        + "mas não dá muita importância e segue para dentro da sala, olhando ao redor à procura de inimigos.\n"
                        + "Não tem ninguém, mas você ouve sons de flechas batendo na pedra atrás de você,\n"
                        + "e quando se vira, vê várias flechas no chão.\n"
                        + "Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto,\n"
                        + "mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.");
                break;

            case CAREFULLY:
                System.out.println("Você toma cuidado e vai caminhando vagarosamente em direção à luz.\n"
                        + "Quando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta.\n"
                        + "Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor.\n"
                        + "Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma delas te acerta na perna.");

                trap(player);
                break;
        }

        input.nextLine();

        System.out.println("Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede.\n"
                + "Uma delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas.\n"
                + "A porta à sua frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler,\n"
                + "mas reconhece como sendo a língua antiga utilizada pelo inimigo.\n"
                + "Você se aproxima da porta e percebe que ela está trancada por duas fechaduras douradas,\n"
                + "e você entende que precisará primeiro derrotar o que estiver nas outras duas portas laterais,\n"
                + "antes de conseguir enfrentar o líder.");

        input.nextLine();

        System.out.println("Você se dirige para a porta à direita.");

        input.nextLine();
        clearConsole();

        System.out.println("Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.\n"
                + "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.\n"
                + "Ao entrar, você se depara com uma sala espaçosa,\n"
                + "com vários equipamentos de batalha pendurados nas paredes e dispostos em armários e mesas.\n"
                + "Você imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos que seus soldados\n"
                + "utilizam quando saem para espalhar o terror nas cidades e vilas da região.\n"
                + "Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para trás.\n");

        System.out.println("Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, está um dos capitães do inimigo.\n"
                + "Um orc horrendo, de armadura, capacete e espada em punho, em posição de combate.\n"
                + "Ele avança em sua direção.\n");


        OrcWarrior orcWarrior = new OrcWarrior();

        System.out.println("Se prepare para o combate!");

        input.nextLine();

        combat(player, orcWarrior, 2);

        System.out.println("Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados.\n"
                + "Olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.");

        input.nextLine();

        YesNoEnum changeArmor = readOption(YesNoEnum.values(), "\nDeseja pegar as armaduras novas?");

        switch (changeArmor) {
            case YES:
                System.out.println("Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas,\n"
                        + "que estavam danificadas, pelas peças de armaduras existentes na sala.\n"
                        + "De armadura nova, você se sente mais protegido para os desafios à sua frente.\n");
                player.setArmor(new Armor());
                break;

            case NO:
                System.out.println("Você decide que não precisa utilizar nada que venha das mãos do inimigo.");
                break;
        }

        input.nextLine();

        System.out.println("Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do líder inimigo.\n"
                + "Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.");

        input.nextLine();

        System.out.println("Você retorna à sala anterior e se dirige à porta da esquerda.\n"
                + "Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.\n"
                + "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.\n"
                + "Ao entrar, você se depara com uma sala parecida com a do arsenal, mas em vez de armaduras,\n"
                + "existem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas,\n"
                + "e você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes,\n"
                + "criando poções utilizadas pelos soldados para aterrorizar a região.");

        input.nextLine();

        System.out.println("No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo.\n"
                + "Um orc horrendo, de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.\n");

        OrcAlchemist orcAlchemist = new OrcAlchemist();

        System.out.println("Se prepare para o combate!");

        input.nextLine();

        combat(player, orcAlchemist, 2);

        System.out.println("Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque do inimigo.\n"
                + "Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente rosado,\n"
                + "pega a garrafa e pondera se deve beber um gole.");

        input.nextLine();

        YesNoEnum drinkPotion = readOption(YesNoEnum.values(), "Deseja beber a poção? ");

        switch (drinkPotion) {
            case YES:
                System.out.println("Você se sente revigorado para seguir adiante!");
                player.restoreHealth();
                break;

            case NO:
                System.out.println("Você fica receoso de beber algo produzido pelo inimigo.");
                break;
        }

        input.nextLine();

        System.out.println("Ao lado da porta, você vê uma chave dourada em cima de uma mesa,\n"
                + "e sabe que aquela chave abre a outra fechadura da porta do líder inimigo.\n"
                + "Você pega a chave e guarda na pequena bolsa que leva presa ao cinto.\n");

        input.nextLine();

        System.out.println("De volta à sala das portas, você se dirige à porta final.\n"
                + "Coloca as chaves nas fechaduras, e a porta se abre.\n"
                + "Seu coração acelera, memórias de toda a sua vida passam pela sua mente,\n"
                + "e você percebe que está muito próximo do seu objetivo final.\n"
                + "Segura sua arma com mais firmeza, foca no combate que você sabe que irá se seguir, e adentra a porta.\n");

        input.nextLine();

        System.out.println("Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados às paredes.\n");

        input.nextLine();

        System.out.println("Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.\n");

        OrcLeader orcLeader = new OrcLeader();

        AttackOrWaitEnum attackOrWait = readOption(AttackOrWaitEnum.values(), "Deseja atacar ou esperar?");

        switch (attackOrWait) {
            case ATTACK:
                combat(player, orcLeader, 1);
                break;

            case WAIT:
                System.out.println("O líder rapidamente te ataca com seu machado duplo.");
                combat(player, orcLeader, 2);
                break;
        }

        input.nextLine();

        System.out.println("Você conseguiu!");

        input.nextLine();

        switch (player.getGoalEnum()) {
            case REVENGE:
                System.out.println("Você obteve sua vingança. "
                        + "Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade. "
                        + "Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.");
                break;

            case HONOR:
                System.out.println("O êxtase em que você se encontra não cabe dentro de si. "
                        + "Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.");
                break;
        }

        input.nextLine();

        System.out.println("Você se levanta, olha para os prisioneiros, vai de um em um e os liberta,\n"
                + "e todos vocês saem em direção à noite, retornando à cidade.\n"
                + "Seu dever está cumprido.");

        input.close();

    }

    private static void trap(Player player) {
        Trap doorTrap = new Trap();
        AttackResult attackResult = doorTrap.attack(player);

        if (attackResult.isMissed()) {
            System.out.println("\nO ataque da armadilha te pegou de raspão e você não sofreu dano.\n");
        } else {
            System.out.printf("\nVocê sofreu %d de dano e agora possui %d pontos de vida.\n", attackResult.getDamage(), attackResult.getHealth());
        }
    }

    private static void combat(Player player, Enemy enemy, int turn){
        while (true){
            if (turn++ % 2 == 1) {
                GiveUpEnum giveUp = readOption(GiveUpEnum.values(), "\nVocê deseja fugir ou atacar?");

                if (giveUp == GiveUpEnum.YES) {
                    System.out.println("Você não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez.");
                    System.exit(0);
                }

                AttackResult result = player.attack(enemy);

                if (result.isMissed()){
                    System.out.println("Você errou seu ataque! O inimigo não sofreu dano algum.");
                    continue;
                }

                if (result.isCritical()) {
                    System.out.printf("Você acertou um ataque crítico %s e causou %d de dano no inimigo!\n", result.getWeapon().getMessage(), result.getDamage());
                }
                if (result.getDamage() == 0) { //
                    System.out.println("O inimigo defendeu o seu ataque!"); //
                } else {
                    System.out.printf("Você atacou %s e causou %d de dano no inimigo!\n", result.getWeapon().getMessage(), result.getDamage());
                }

                if (result.isDead()) {
                    clearConsole();
                    System.out.println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.\n");
                    break;
                } else {
                    System.out.printf("O inimigo ainda possui %d de energia.\n", enemy.getHealthPoints());
                }
            } else {
                AttackResult result = enemy.attack(player);

                System.out.printf("\nO inimigo %s avança em um ataque!\n", enemy.getWeapon().getMessage());

                if (result.isMissed()){
                    System.out.println("O inimigo errou o ataque! Você não sofreu dano.");
                    continue;
                }

                if (result.isCritical()) {
                    System.out.println("O inimigo acertou um ataque crítico!");
                }

                if (result.getDamage() == 0) { //
                        System.out.println("Você defendeu o ataque!"); //
                } else {
                    System.out.printf("Você sofreu %d de dano e agora possui %d pontos de vida.\n", result.getDamage(), result.getHealth());
                }

                if (result.isDead()) {
                    clearConsole();
                    System.out.println("\nVocê não estava preparado para a força do inimigo.");

                    switch (player.getGoalEnum()) {
                        case REVENGE:
                            System.out.println("Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.");

                        case HONOR:
                            if (player.getGender().equals("M")) {
                                System.out.println("A glória que buscavas não será sua, e a cidade aguarda por seu próximo herói.");
                            } else {
                                System.out.println("A glória que buscavas não será sua, e a cidade aguarda por sua próxima heróina.");
                            }
                    }

                    System.exit(0);
                }
            }
        }
    }

    private static Player createPlayer() {
        Player player = null;
        String name = readName();
        String gender = readGender();

        CharacterEnum getCharacter = readOption(CharacterEnum.values(), "\nDigite o código da vocação do personagem: ");

        try {
            switch (getCharacter) {
                case WARRIOR:
                    player = createWarrior(name, gender);
                    break;

                case PALADIN:
                    player = createPaladin(name, gender);
                    break;

                case BOWMAN:
                    player = createBowman(name, gender);
                    break;

                case DRUID:
                    player = createDruid(name, gender);
                    break;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Personagem cadastrado com sucesso.\n");

        return player;
    }

    private static Warrior createWarrior(String name, String gender) {
        WeaponEnum[] weapons = Warrior.getWeapons();

        WeaponEnum weapon = readWeapon(weapons);

        return new Warrior(name, gender, weapon);
    }

    private static Paladin createPaladin(String name, String gender) {
        WeaponEnum[] weapons = Paladin.getWeapons();

        WeaponEnum weapon = readWeapon(weapons);

        return new Paladin(name, gender, weapon);
    }

    private static Bowman createBowman(String name, String gender) {
        WeaponEnum[] weapons = Bowman.getWeapons();

        WeaponEnum weapon = readWeapon(weapons);

        return new Bowman(name, gender, weapon);
    }

    private static Druid createDruid(String name, String gender) {
        WeaponEnum[] weapons = Druid.getWeapons();

        WeaponEnum weapon = readWeapon(weapons);

        return new Druid(name, gender, weapon);
    }

    private static WeaponEnum readWeapon(WeaponEnum[] weapons) {

        System.out.println("\nDigite o código da arma que o personagem usará nas batalhas");

        for (int i = 0; i < weapons.length ; i++) {
            System.out.printf("%d - %s%n", i + 1, weapons[i].getDisplayName());
        }

        while (true) {
            int idWeapon = readInt();

            if (idWeapon <= 0 || idWeapon > weapons.length) {
                System.out.println("Código de arma inválido. Digite novamente.");
                continue;
            }

            WeaponEnum weapon = weapons[idWeapon - 1];

            return weapon;
        }
    }

    private static String readName() {
        System.out.print("\nNome do personagem: ");

        while (true) {
            String userInput = input.nextLine();

            if (userInput.isEmpty() || userInput.equals(" ")) {
                System.out.println("\nO nome não pode ser vazio.");
                System.out.print("Nome do personagem: ");
                continue;
            }
            return userInput;
        }
    }

    private static String readGender() {
        System.out.print("\nGênero do personagem [M/F]: ");

        while (true) {
            String userInput = input.nextLine();

            if (!(userInput.equalsIgnoreCase("M") || userInput.equalsIgnoreCase("F"))) {
                System.out.println("\nA opção deve ser M ou F.");
                System.out.print("Gênero do personagem [M/F]: ");
                continue;
            }
            return userInput;
        }
    }

    private static int readInt() {
        while (true) {
            String userInput = input.nextLine().trim();
            try {
                return Integer.parseInt(userInput);

            } catch (NumberFormatException e) {
                System.out.println("Valor incorreto, digite novamente um número inteiro.");
            }
        }
    }

    private static <TOptions extends DisplayEnum> TOptions readOption(TOptions[] options, String text) {
        System.out.println(text);
        for (TOptions option : options) {
            System.out.println(option.getValue() + " - " + option.getDisplayName());
        }

        while (true) {
            String line = input.nextLine();

            for (TOptions option : options) {
                if(Integer.toString(option.getValue()).equals(line)){
                    return option;
                }
            }

            System.out.println("Escolha uma opção válida.");
        }
    }

    public static void clearConsole() {
        System.out.println(new String(new char[40]).replace("\0", "\r\n"));

    }
}
