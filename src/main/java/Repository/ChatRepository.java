package Repository;

import Entity.Chat;
import Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
