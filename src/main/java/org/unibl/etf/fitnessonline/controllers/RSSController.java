package org.unibl.etf.fitnessonline.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.dtos.RSSFeedItemDTO;
import org.unibl.etf.fitnessonline.services.RSSFeedService;

import java.util.List;

@RestController
@RequestMapping("/api/rss")
public class RSSController {
    @Value("${rss.feed.url}")
    private String rssFeedUrl;
    private final RSSFeedService rssFeedService;

    public RSSController(RSSFeedService rssFeedService) {
        this.rssFeedService = rssFeedService;
    }

    @GetMapping
    public List<RSSFeedItemDTO> getRssFeed() {
        return rssFeedService.getRssFeedItems(rssFeedUrl);
    }
}
