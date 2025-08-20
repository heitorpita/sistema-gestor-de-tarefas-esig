package projetoESIGJAVA.enums;

public enum Prioridade {

    ALTA(1), MEDIA(2), BAIXA(3);

    private final int codigo;

    private Prioridade(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static Prioridade valueOf(int codigo) {
        for (Prioridade p : Prioridade.values()){
            if (p.getCodigo() == codigo){
                return p;
            }
        }
        throw new IllegalArgumentException("CODIGO INVALIDO!");
    }

}
