package com.example.catalog_service.repository;

import com.example.catalog_service.entity.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogEntity, Long> {

	CatalogEntity findByProductId(String productId);
}
