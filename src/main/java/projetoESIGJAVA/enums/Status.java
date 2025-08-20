package projetoESIGJAVA.enums;

public enum Status {
    EM_ANDAMENTO(1),
    CONCLUIDO(2);

    private final int codigo;

    private Status(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static Status valueOf(int codigo) {
        for(Status s : Status.values()) {
            if (s.getCodigo() == codigo) {
                return s;
            }
        }
        throw new IllegalArgumentException("Código de Status inválido!");
    }

}
