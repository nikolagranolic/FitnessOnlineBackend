package org.unibl.etf.fitnessonline.models.dtos;

import lombok.Data;

@Data
public class RSSFeedItemDTO {
    private String category;
    private String title;
    private String description;
    private String link;
}
