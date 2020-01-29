package br.com.brainweb.interview.model;

import java.util.UUID;

import javax.validation.constraints.NotNull;

public class PowerStats {

	@NotNull
	private UUID id;
    @NotNull
    private Short strength;
    @NotNull
    private Short agility;
    @NotNull
    private Short dexterity;
    @NotNull
    private Short intelligence;

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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
    
    
}
