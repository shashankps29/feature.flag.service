package com.backend.featureflagservice.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.backend.featureflagservice.model.FeatureFlag;
import com.backend.featureflagservice.repository.FeatureFlagRepository;
import org.springframework.stereotype.Service;

@Service
public class FeatureFlagService {

    private final FeatureFlagRepository repository;

    public FeatureFlagService(FeatureFlagRepository repository) {
        this.repository = repository;
    }

    public FeatureFlag createFeature(String key, boolean enabled) {

        if (repository.findByFeatureKey(key).isPresent()) {
            throw new RuntimeException("Feature already exists: " + key);
        }

        FeatureFlag feature = new FeatureFlag(key, enabled);
        return repository.save(feature);
    }

    public boolean isFeatureEnabled(String key) {
        return repository.findByFeatureKey(key)
                .map(FeatureFlag::isEnabled)
                .orElse(false);
    }
    public FeatureFlag updateFeature(String key, boolean enabled) {

        FeatureFlag feature = repository.findByFeatureKey(key)
                .orElseThrow(() -> new RuntimeException("Feature not found: " + key));

        feature.setEnabled(enabled);
        return repository.save(feature);
    }
}
