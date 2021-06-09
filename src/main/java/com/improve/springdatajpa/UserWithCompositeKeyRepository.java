package com.improve.springdatajpa;

import org.springframework.data.repository.CrudRepository;

public interface UserWithCompositeKeyRepository extends CrudRepository<UserWithCompositeKey, UserWithCompositeKeyId> {

}
