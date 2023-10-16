package org.data.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.data.entity.Aadhar;
@ApplicationScoped
public class AddharRepository implements PanacheRepository<Aadhar> {
}
