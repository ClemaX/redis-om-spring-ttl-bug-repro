package com.example.demo;

import com.redis.om.spring.repository.RedisDocumentRepository;

import java.util.Optional;

public interface BugRepository extends RedisDocumentRepository<BugEntity, Long> {
    Optional<BugEntity> findByHash(String hash);
}
