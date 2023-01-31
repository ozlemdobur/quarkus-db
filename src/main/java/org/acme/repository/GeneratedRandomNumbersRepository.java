package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.GeneratedRandomNumbers;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GeneratedRandomNumbersRepository implements PanacheRepository<GeneratedRandomNumbers> {
}
