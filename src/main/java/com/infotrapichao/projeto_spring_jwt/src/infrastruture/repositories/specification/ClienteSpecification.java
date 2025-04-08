package com.infotrapichao.projeto_spring_jwt.src.infrastruture.repositories.specification;

import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common.AgendamentoDTO;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common.ClienteDTO;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Cliente;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ClienteSpecification {

    public static Specification<Cliente> withFiltersDTO(ClienteDTO filtro) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            ///Agendamentos por Cliente:
            if (filtro.getName() != null && !filtro.getName().isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("cliente").get("name")), "%" + filtro.getName().toLowerCase() + "%"));
            }
            ///Agendamentos por User:
            if (filtro.getUser().getId() != null && filtro.getUser().getId() != 0) {
                predicates.add(cb.equal(root.get("user").get("id"), filtro.getUser().getId()));
            }

            if (filtro.getUpdatedAt() != null) {
                predicates.add(cb.equal(root.get("createdAt"), filtro.getCreatedAt()));
            }

           // 🔽 Ordenação por createdAt DESC
            assert query != null;
            
            query.orderBy(cb.desc(root.get("createdAt")));

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
