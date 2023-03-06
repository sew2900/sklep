package pl.sewkus.sklep.itemOpinions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemOpinionsRepo extends JpaRepository<ItemOpinions, Long> {

    List<ItemOpinions> findAllByItemId(Long id);
}

