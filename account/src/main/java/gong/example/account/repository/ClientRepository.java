package gong.example.account.repository;

import gong.example.account.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClientRepository extends MongoRepository<Client, Long> {
    @Override
    List<Client> findAll();

    @Override
    <S extends Client> S save(S entity);
}
