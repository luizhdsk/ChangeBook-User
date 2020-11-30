package com.projeto.changebookusers.repository;

import com.projeto.changebookusers.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByCpf(String cpf);
    Boolean existsByCpf(String cpf);
}
