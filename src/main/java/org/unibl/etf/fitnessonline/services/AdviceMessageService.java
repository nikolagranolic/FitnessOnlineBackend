package org.unibl.etf.fitnessonline.services;

import org.unibl.etf.fitnessonline.models.requests.AdviceMessageRequest;

public interface AdviceMessageService {
    void sendAdviceMessage(AdviceMessageRequest request);
}
