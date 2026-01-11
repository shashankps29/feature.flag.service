package com.backend.featureflagservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "feature_flags")
public class FeatureFlag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "feature_key", unique = true, nullable = false)
    private String featureKey;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    public FeatureFlag() {
    }

    public FeatureFlag(String featureKey, boolean enabled) {
        this.featureKey = featureKey;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public String getFeatureKey() {
        return featureKey;
    }

    public void setFeatureKey(String featureKey) {
        this.featureKey = featureKey;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
