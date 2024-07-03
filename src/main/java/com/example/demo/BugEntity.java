package com.example.demo;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Document(value = "BUG", timeToLive = 1)
@Data
public class BugEntity {
    @Id
    private String id;

    @Indexed
    @NonNull
    private String hash;

    @Indexed
    @NonNull
    private Long someId;
}
