package br.com.system.lava_tech.Enum;

public enum TipoTrabalho {

    LAVAGEM(1),
    HIGINIZACAO(2),
    POLIMENTO(3),
    CHECK_UP(4);

    private int escolha;

    TipoTrabalho(int escolha) {
        this.escolha = escolha;
    }

    public int getEscolha() {
        return escolha;
    }

}
