package witali.tasks.repos;

import org.springframework.data.repository.CrudRepository;
import witali.tasks.domain.Parts;

public interface PartsRepo extends CrudRepository<Parts, Integer>{
    Iterable<Parts> findByTypeLikeAndNeedTrue(String type);
    Iterable<Parts> findByTypeLikeAndNeedFalse(String type);
    Iterable<Parts> findByNeedTrue();
    Iterable<Parts> findByNeedFalse();
    Iterable<Parts> findByTypeLike(String type);
    int countByNeedIsTrue();
}