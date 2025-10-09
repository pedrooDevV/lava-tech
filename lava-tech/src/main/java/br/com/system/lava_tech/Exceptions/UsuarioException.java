package br.com.system.lava_tech.Exceptions;

public class UsuarioException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "Usuario não existe";

    public UsuarioException(String message) {
        super(message);
    }

    public UsuarioException() {
        super(DEFAULT_MESSAGE);
    }
}
