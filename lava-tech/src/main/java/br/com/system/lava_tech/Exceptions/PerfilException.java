package br.com.system.lava_tech.Exceptions;

public class PerfilException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Perfil deve ser informado";

    public PerfilException(String message) {
        super(message);
    }

    public PerfilException() {
        super(DEFAULT_MESSAGE);
    }
}
