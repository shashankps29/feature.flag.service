package com.backend.featureflagservice.controller;

import com.backend.featureflagservice.service.FeatureFlagService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/features")
public class FeatureController {

    private final FeatureFlagService featureFlagService;

    public FeatureController(FeatureFlagService featureFlagService) {
        this.featureFlagService = featureFlagService;
    }

    @GetMapping("/info")
    public String info() {
        return "Feature Flag Service is running";
    }

    @PostMapping
    public String createFeature(@RequestParam String key,
                                @RequestParam boolean enabled) {

        featureFlagService.createFeature(key, enabled);
        return "Feature created successfully";
    }

    @PutMapping("/{key}")
    public String updateFeature(@PathVariable String key,
                                @RequestParam boolean enabled) {

        featureFlagService.updateFeature(key, enabled);
        return "Feature updated successfully";
    }

    @GetMapping("/{key}")
    public boolean checkFeature(@PathVariable String key) {
        return featureFlagService.isFeatureEnabled(key);
    }

}

