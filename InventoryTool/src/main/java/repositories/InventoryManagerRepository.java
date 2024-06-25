package repositories;

import entities.InventoryManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryManagerRepository extends JpaRepository<InventoryManager, Long> {

}
