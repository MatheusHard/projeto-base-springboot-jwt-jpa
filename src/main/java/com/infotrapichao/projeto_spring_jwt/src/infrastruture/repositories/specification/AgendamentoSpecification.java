package com.infotrapichao.projeto_spring_jwt.src.infrastruture.repositories.specification;

import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common.AgendamentoDTO;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common.ClienteDTO;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Agendamento;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Cliente;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoSpecification {

    public static Specification<Agendamento> withFiltersDTO(AgendamentoDTO filtro) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            /// Por Nome Cliente
            if (filtro.getCliente().getName() != null && !filtro.getCliente().getName().isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + filtro.getCliente().getName().toLowerCase() + "%"));
            }
            /// Por Cliente Id
            if (filtro.getCliente().getId() != null && filtro.getCliente().getId() != 0) {
                predicates.add(cb.equal(root.get("cliente").get("id"), filtro.getCliente().getId()));
            }
            /// por User Id:
            if (filtro.getUser().getId() != null && filtro.getUser().getId() != 0) {
                predicates.add(cb.equal(root.get("user").get("id"), filtro.getUser().getId()));
            }
            /// Data
            if (filtro.getCreatedAt() != null) {
                predicates.add(cb.equal(root.get("createdAt"), filtro.getCreatedAt()));
            }
            /// Finalizado
            if (filtro.getFinalizado() != null) {
                predicates.add(cb.equal(root.get("finalizado"), filtro.getFinalizado()));
            }
            /// Deletado
            if (filtro.getDeletado() != null) {
                predicates.add(cb.equal(root.get("deletado"), filtro.getDeletado()));
            }
            /// Filtro por intervalo de datas (between)
            if (filtro.getDataInicial() != null && filtro.getDataFinal() != null) {
                LocalDateTime inicio = filtro.getDataInicial().atStartOfDay();
                LocalDateTime fim = filtro.getDataFinal().atTime(LocalTime.MAX); // 23:59:59.999...
                predicates.add(cb.between(root.get("dataAtendimento"), inicio, fim));
            } else if (filtro.getDataInicial() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("dataAtendimento"), filtro.getDataInicial().atStartOfDay()));
            } else if (filtro.getDataFinal() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("dataAtendimento"), filtro.getDataFinal().atTime(LocalTime.MAX)));
            }

            // 🔽 Ordenação por updatedAt DESC
            assert query != null;

            query.orderBy(cb.asc(root.get("updatedAt")));

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
