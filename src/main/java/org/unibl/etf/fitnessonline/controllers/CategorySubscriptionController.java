package org.unibl.etf.fitnessonline.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.models.requests.CategorySubscriptionRequest;
import org.unibl.etf.fitnessonline.services.CategorySubscriptionService;

@RestController
@RequestMapping("/api/category-subscriptions")
@CrossOrigin(origins = "*")
public class CategorySubscriptionController {
    private final CategorySubscriptionService service;

    public CategorySubscriptionController(CategorySubscriptionService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategorySubscription(@RequestBody CategorySubscriptionRequest request) {
        service.addCategorySubscription(request);
    }

    @DeleteMapping("/{userId}/{categoryId}")
    public void removeCategorySubscription(@PathVariable Integer userId, @PathVariable Integer categoryId) {
        service.removeCategorySubscription(new CategorySubscriptionRequest(userId, categoryId));
    }

    @PostMapping("/check-if-subscriber")
    public boolean checkIfSubscriber(@RequestBody CategorySubscriptionRequest request) {
        return service.checkIfSubscribed(request);
    }

}
