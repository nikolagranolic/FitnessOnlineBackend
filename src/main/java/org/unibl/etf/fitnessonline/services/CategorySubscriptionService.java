package org.unibl.etf.fitnessonline.services;

import org.unibl.etf.fitnessonline.models.requests.CategorySubscriptionRequest;

public interface CategorySubscriptionService {
    void addCategorySubscription(CategorySubscriptionRequest request);
    void removeCategorySubscription(CategorySubscriptionRequest request);
    boolean checkIfSubscribed(CategorySubscriptionRequest request);
}
