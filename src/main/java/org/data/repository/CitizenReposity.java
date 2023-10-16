package org.data.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.data.entity.Citizen;
@ApplicationScoped
public class CitizenReposity implements PanacheRepository<Citizen> {
}
