package br.com.system.lava_tech.Exceptions;

public class UsuarioNaoExisteException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "Usuario não existe";

    public UsuarioNaoExisteException(String message) {
        super(message);
    }

    public UsuarioNaoExisteException() {
        super(DEFAULT_MESSAGE);
    }
}
