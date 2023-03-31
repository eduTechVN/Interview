package trinh.vov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trinh.vov.model.entity.item.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
}