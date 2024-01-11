package org.unibl.etf.fitnessonline.models.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ImageRequest {
    @NotNull
    private String url;
    @NotNull
    private Integer programId;
}
