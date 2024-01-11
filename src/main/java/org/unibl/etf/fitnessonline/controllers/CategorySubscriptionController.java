package org.unibl.etf.fitnessonline.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.models.entities.UserEntity;
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
    public void addCategorySubscription(Authentication authentication, @RequestBody CategorySubscriptionRequest request) {
        UserEntity user = (UserEntity) authentication.getPrincipal();
        request.setUserId(user.getId());
        service.addCategorySubscription(request);
    }

    @DeleteMapping("/{userId}/{categoryId}")
    public void removeCategorySubscription(Authentication authentication, @PathVariable Integer userId, @PathVariable Integer categoryId) {
        UserEntity user = (UserEntity) authentication.getPrincipal();
        userId = user.getId();
        service.removeCategorySubscription(new CategorySubscriptionRequest(userId, categoryId));
    }

    @PostMapping("/check-if-subscriber")
    public boolean checkIfSubscriber(Authentication authentication, @RequestBody CategorySubscriptionRequest request) {
        UserEntity user = (UserEntity) authentication.getPrincipal();
        request.setUserId(user.getId());
        return service.checkIfSubscribed(request);
    }

}
