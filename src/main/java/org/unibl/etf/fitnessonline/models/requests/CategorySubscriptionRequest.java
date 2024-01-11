package org.unibl.etf.fitnessonline.models.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategorySubscriptionRequest {
    @NotNull(message = "UserId cannot be null")
    private Integer userId;

    @NotNull(message = "CategoryId cannot be null")
    private Integer categoryId;
}
