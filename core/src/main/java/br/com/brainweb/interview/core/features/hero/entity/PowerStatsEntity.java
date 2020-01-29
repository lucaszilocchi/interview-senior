package br.com.brainweb.interview.core.features.hero.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class PowerStatsEntity {

    private UUID id;
    private Short strength;
    private Short agility;
    private Short dexterity;
    private Short intelligence;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    
    private PowerStatsEntity(Builder builder) {
        this.id = builder.id;
        this.strength = builder.strength;
        this.agility = builder.agility;
        this.dexterity = builder.dexterity;
        this.intelligence = builder.intelligence;
        this.created_at = builder.created_at;
        this.updated_at = builder.updated_at;
    }
    
    public static Builder newPowerStatsEntity() {
        return new Builder();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Short getStrength() {
        return strength;
    }

    public void setStrength(Short strength) {
        this.strength = strength;
    }

    public Short getAgility() {
        return agility;
    }

    public void setAgility(Short agility) {
        this.agility = agility;
    }

    public Short getDexterity() {
        return dexterity;
    }

    public void setDexterity(Short dexterity) {
        this.dexterity = dexterity;
    }

    public Short getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Short intelligence) {
        this.intelligence = intelligence;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
    
    public static final class Builder {

        private UUID id;
        private Short strength;
        private Short agility;
        private Short dexterity;
        private Short intelligence;
        private LocalDateTime created_at;
        private LocalDateTime updated_at;


        private Builder() {
        }

        public PowerStatsEntity build() {
            return new PowerStatsEntity(this);
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }
        
        public Builder strength(Short strength) {
            this.strength = strength;
            return this;
        }
        
        public Builder agility(Short agility) {
            this.agility = agility;
            return this;
        }
        
        public Builder dexterity(Short dexterity) {
            this.dexterity = dexterity;
            return this;
        }
        
        public Builder intelligence(Short intelligence) {
            this.intelligence = intelligence;
            return this;
        }
        
        public Builder id(Short intelligence) {
            this.intelligence = intelligence;
            return this;
        }

        public Builder createdAt(LocalDateTime created_at) {
            this.created_at = created_at;
            return this;
        }

        public Builder updatedAt(LocalDateTime updated_at) {
            this.updated_at = updated_at;
            return this;
        }
    }
}
