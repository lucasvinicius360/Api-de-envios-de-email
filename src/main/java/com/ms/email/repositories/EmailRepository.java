package com.ms.email.repositories;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.descriptor.java.UUIDJavaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.email.models.EmailModel;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel,UUID>{

    
} 
