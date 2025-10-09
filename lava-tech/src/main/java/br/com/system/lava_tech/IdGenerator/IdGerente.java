package br.com.system.lava_tech.IdGenerator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGerente implements IdentifierGenerator {
    private final AtomicInteger counter = new AtomicInteger(1);

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        int idGerente = counter.getAndIncrement();

        return "lava_tech"+String.format("%02d",idGerente);
    }
}
