package api.repository;


import api.entity.OperacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacaoRepository extends JpaRepository<OperacaoEntity,Long> {
}
