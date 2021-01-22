package com.spring.repositories;

import com.spring.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin // важно, почитать
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
