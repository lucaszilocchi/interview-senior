package br.com.brainweb.interview.core.features.hero.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class HeroEntity {

    private UUID id;
    private String name;
    private String race;
    private UUID powerStatsId;
    private String enabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private PowerStatsEntity powerStatsEntity;

    private HeroEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.race = builder.race;
        this.powerStatsId = builder.powerStatsId;
        this.enabled = builder.enabled;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.powerStatsEntity = builder.powerStatsEntity;
    }

    public static Builder newHeroEntity() {
        return new Builder();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public UUID getPowerStatsId() {
        return powerStatsId;
    }

    public void setPowerStatsId(UUID powerStatsId) {
        this.powerStatsId = powerStatsId;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public PowerStatsEntity getPowerStatsEntity() {
		return powerStatsEntity;
	}

	public void setPowerStatsEntity(PowerStatsEntity powerStatsEntity) {
		this.powerStatsEntity = powerStatsEntity;
	}



	public static final class Builder {

        private UUID id;
        private String name;
        private String race;
        private UUID powerStatsId;
        private String enabled;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private PowerStatsEntity powerStatsEntity; 

        private Builder() {
        }

        public HeroEntity build() {
            return new HeroEntity(this);
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder race(String race) {
            this.race = race;
            return this;
        }

        public Builder powerStatsId(UUID powerStatsId) {
            this.powerStatsId = powerStatsId;
            return this;
        }

        public Builder enabled(String enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        
        public Builder powerStatsEntity(PowerStatsEntity powerStatsEntity) {
            this.powerStatsEntity = powerStatsEntity;
            return this;
        }
    }
}
