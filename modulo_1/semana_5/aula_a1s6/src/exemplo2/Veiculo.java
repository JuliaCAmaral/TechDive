package exemplo1;

public class Veiculo {

    private String marca;

    public Veiculo(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Veiculo {" +
                "marca = '" + marca + '\'' +
                '}';
    }
}
