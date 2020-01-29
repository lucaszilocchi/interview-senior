package br.com.brainweb.interview.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotNull;

public class Hero {

	@NotNull
	private UUID id;
    @NotNull
    private String name;
    @NotNull
    private Race race;
    @NotNull
    private PowerStats powerStats;
    @NotNull
    private String enabled;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;
    

    public enum Race {
        HUMAN,
        ALIEN,
        DIVINE,
        CYBORG
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public PowerStats getPowerStats() {
        return powerStats;
    }

    public void setPowerStats(PowerStats powerStats) {
        this.powerStats = powerStats;
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
	
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    
    
}
