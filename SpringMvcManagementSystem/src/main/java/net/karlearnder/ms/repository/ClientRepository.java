package net.karlearnder.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.karlearnder.ms.entity.Client;



public interface ClientRepository extends JpaRepository<Client, Long> {

}
