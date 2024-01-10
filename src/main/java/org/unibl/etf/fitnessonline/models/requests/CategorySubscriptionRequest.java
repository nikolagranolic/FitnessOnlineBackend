package org.unibl.etf.fitnessonline.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategorySubscriptionRequest {
    private Integer userId;
    private Integer categoryId;
}
