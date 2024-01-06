package org.unibl.etf.fitnessonline.models.specifications;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.unibl.etf.fitnessonline.models.entities.CategoryEntity;
import org.unibl.etf.fitnessonline.models.entities.ProgramEntity;
import org.unibl.etf.fitnessonline.models.requests.FilterRequest;

import java.util.ArrayList;
import java.util.List;

public class ProgramSpecification {
    public static Specification<ProgramEntity> createSpecification(FilterRequest filterRequest) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filterRequest != null) {
                if (filterRequest.getName() != null && !filterRequest.getName().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("name"), "%" + filterRequest.getName() + "%"));
                }

                if (filterRequest.getLocation() != null && !filterRequest.getLocation().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("location"), "%" + filterRequest.getLocation() + "%"));
                }

                if (filterRequest.getDescription() != null && !filterRequest.getDescription().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("description"), "%" + filterRequest.getDescription() + "%"));
                }

                if (filterRequest.getCategoryId() != null) {
                    Join<ProgramEntity, CategoryEntity> categoryJoin = root.join("category", JoinType.INNER);
                    predicates.add(criteriaBuilder.equal(categoryJoin.get("id"), filterRequest.getCategoryId()));
                }


                if (filterRequest.getMinPrice() != null) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), filterRequest.getMinPrice()));
                }

                if (filterRequest.getMaxPrice() != null) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), filterRequest.getMaxPrice()));
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
