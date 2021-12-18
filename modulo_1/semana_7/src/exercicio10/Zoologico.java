package exercicio10;

import java.util.ArrayList;

public class Zoologico {

    private static ArrayList<Animal> animais = new ArrayList<Animal>();

    private static Animal[] jaulas = new Animal[10];

    public static void main(String[] args) {

        animais.add(new Ave("Avestruz", "grasnando", "tam-tam, aaahn"));
        animais.add(new Ave("Bem-te-vi", "cantando", "bem-te-vi"));
        animais.add(new Ave("Coruja", "piando", "uuh uuh"));
        animais.add(new Ave("Galinha-d'angola", "fraquejando", "tô-fraco"));
        animais.add(new Ave("Ganso", "grasnando", "quá quá"));
        animais.add(new Ave("Periquito", "palrando", "piu piu piu"));
        animais.add(new Ave("Peru", "grugulejando", "glu glu glu"));
        animais.add(new Ave("Pica-pau", "estridulando", "priii priii"));
        animais.add(new Ave("Sabiá", "cantando", "tuí-tuí"));
        animais.add(new Ave("Urubu", "crocitando", "croac, cuá, cuá"));

        animais.add(new Mamifero("Bode", "bodejando", "bééééé"));
        animais.add(new Mamifero("Burro", "zurrando", "inhóóó inhóóó"));
        animais.add(new Mamifero("Capivara", "assobiando", "ahn ahn"));
        animais.add(new Mamifero("Cavalo", "relinchando", "iiirrrrí, rilinchin"));
        animais.add(new Mamifero("Coelho", "chiando", "iiii iiii"));
        animais.add(new Mamifero("Elefante", "barrendo", "fuumm uuuuh"));
        animais.add(new Mamifero("Gambá", "chiando", "tziii tziiii"));
        animais.add(new Mamifero("Javali", "grunhindo", "oinc oinc, iiihhh"));
        animais.add(new Mamifero("Onça", "rugindo", "grrr, roar"));
        animais.add(new Mamifero("Zebra", "zurrando", "inhóóó inhóóó"));

        animais.add(new Reptil("Cobra", "sibilando", "ssssss"));
        animais.add(new Reptil("Crocodilo", "bramindo", "roar, roooor"));
        animais.add(new Reptil("Jacaré", "bramindo", "roar, roooor"));
        animais.add(new Reptil("Lagarto", "farfalhando", "crrriiii"));

        for (int i = 0; i < jaulas.length; i++) {

            int posicaoAnimal = (int)((Math.random() * animais.size() + 1) - 1);

            jaulas[i] = animais.get(posicaoAnimal);

            animais.remove(posicaoAnimal);
        }

        for (int i = 0; i < jaulas.length; i++) {

            System.out.println("\nNa jaula " + (i + 1) + ": " + jaulas[i].toString());
        }
    }
}
