package br.com.engsoftware.appVoceAluga.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.engsoftware.appVoceAluga.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
}