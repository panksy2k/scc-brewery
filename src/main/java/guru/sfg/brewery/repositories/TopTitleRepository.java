package guru.sfg.brewery.repositories;

import guru.sfg.brewery.domain.TopTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TopTitleRepository extends JpaRepository<TopTitle, UUID> {
}
