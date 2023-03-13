package market.habba.repository;

import market.habba.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findByNameAndUserId(String name, UUID userId);
    List<Product> findByUserId(UUID userId);
}
