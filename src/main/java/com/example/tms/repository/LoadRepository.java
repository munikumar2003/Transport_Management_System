package com.example.tms.repository;

import com.example.tms.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface LoadRepository extends JpaRepository<Load, UUID> {
}
