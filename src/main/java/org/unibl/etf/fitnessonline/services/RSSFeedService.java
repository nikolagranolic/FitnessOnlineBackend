package org.unibl.etf.fitnessonline.services;

import org.unibl.etf.fitnessonline.models.dtos.RSSFeedItemDTO;

import java.util.List;

public interface RSSFeedService {
    public List<RSSFeedItemDTO> getRssFeedItems(String rssFeedUrl);
}
