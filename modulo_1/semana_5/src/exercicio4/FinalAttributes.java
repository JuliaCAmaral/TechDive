package exercicio4;

public class FinalAttributes {

    private final int FINAL_ATTRIBUTE1;
    private final static int FINAL_ATTRIBUTE2;

    static{
        FINAL_ATTRIBUTE2 = 2;
    }

    public FinalAttributes() {
        FINAL_ATTRIBUTE1 = 1;
    }

    public static void main(String[] args) {

        FinalAttributes valor = new FinalAttributes();

        System.out.println(FINAL_ATTRIBUTE2);
        System.out.println(valor.FINAL_ATTRIBUTE1);

    }

}
