package escola;

public class Nota {
    private Double primeira, segunda;

    public double media() {
        double acumulador = 0;
        int pessoas = 0;
        if (primeira != null) {
            acumulador += primeira;
            pessoas++;
        }
        if (segunda != null) {
            acumulador += segunda;
            pessoas++;
        }
        return acumulador / (pessoas != 0 ? pessoas : 1);
    }
}
