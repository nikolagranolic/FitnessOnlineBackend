package org.unibl.etf.fitnessonline.services.impl;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.models.dtos.RSSFeedItemDTO;
import org.unibl.etf.fitnessonline.services.RSSFeedService;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class RSSFeedServiceImpl implements RSSFeedService {

    @Override
    public List<RSSFeedItemDTO> getRssFeedItems(String rssFeedUrl) {
        List<RSSFeedItemDTO> rssFeedItems = new ArrayList<>();

        try {
            URL feedUrl = new URL(rssFeedUrl);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            for (SyndEntry entry : feed.getEntries()) {
                RSSFeedItemDTO dto = new RSSFeedItemDTO();
                dto.setCategory(entry.getCategories().isEmpty() ? "" : entry.getCategories().get(0).getName());
                dto.setTitle(entry.getTitle());
                dto.setDescription(entry.getDescription().getValue());
                dto.setLink(entry.getLink());

                rssFeedItems.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //TODO implement logging (after you have implemented controller and everything for LogEntity)
        }

        return rssFeedItems;
    }
}
