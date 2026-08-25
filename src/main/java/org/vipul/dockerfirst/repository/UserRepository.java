package org.vipul.dockerfirst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vipul.dockerfirst.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
