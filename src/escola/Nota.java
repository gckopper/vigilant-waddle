package escola;

public class Nota {
    private Double primeira, segunda;
    private Disciplina disciplina;

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Double getPrimeira() {
        return primeira;
    }

    public void setPrimeira(Double primeira) {
        this.primeira = primeira;
    }

    public Double getSegunda() {
        return segunda;
    }

    public void setSegunda(Double segunda) {
        this.segunda = segunda;
    }

    public Nota(double primeira, double segunda, Disciplina disciplina) {
        this(primeira, disciplina);
        if (!intervalo(segunda)) {
            throw new NumberFormatException("Ambas as notas devem estar contidas em [0,10]");
        }
        this.segunda = segunda;
    }

    public Nota(double primeira, Disciplina disciplina) {
        if (!intervalo(primeira)) {
            throw new NumberFormatException("Ambas as notas devem estar contidas em [0,10]");
        }
        this.primeira = primeira;
        this.disciplina = disciplina;
    }

    public Nota(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public double media() {
        double acumulador = 0;
        int quantNotas = 0;
        if (primeira != null) {
            acumulador += primeira;
            quantNotas++;
        }
        if (segunda != null) {
            acumulador += 2 * segunda;
            quantNotas += 2;
        }
        return quantNotas != 0 ? (acumulador / quantNotas) : 0;
    }


    public boolean passou() {
        return media() >= 7;
    }

    public boolean adicionaNota(double nota) {
        if (primeira == null) {
            primeira = nota;
            return true;
        }
        if (segunda == null) {
            segunda = nota;
            return true;
        }
        return false;
    }

    private boolean intervalo(double valor) {
        return valor <= 10.0 && valor >= 0.0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(disciplina.toString());
        result.append(":\n\t\t");
        result.append("Nota 1 = ");
        result.append(primeira);
        result.append("\n\t\t");
        result.append("Nota 2 = ");
        result.append(segunda);
        result.append("\n\t\t");
        result.append("Média = ");
        result.append(media());
        result.append("\n\t\t");
        result.append("Aprovado? = ");
        result.append(passou() ? "Sim" : "Não");
        return result.toString();
    }
}
