package br.com.brainweb.interview.core.features.powerstats.util;

import java.time.LocalDateTime;
import java.util.Optional;

import br.com.brainweb.interview.core.features.hero.entity.PowerStatsEntity;
import br.com.brainweb.interview.model.PowerStats;

public class PowerStatsMapper {
	
    public static PowerStatsEntity map(PowerStats powerStats) {
        return PowerStatsEntity.newPowerStatsEntity()
        	.strength(powerStats.getAgility())
        	.agility(powerStats.getAgility())
        	.dexterity(powerStats.getDexterity())
        	.intelligence(powerStats.getIntelligence())
            .updatedAt(LocalDateTime.now())
            .createdAt(LocalDateTime.now())
            .build();
    }
    
    public static PowerStatsEntity mapNameFilter(PowerStatsEntity powerStats) {
        return PowerStatsEntity.newPowerStatsEntity()
            .id(powerStats.getId())
            .build();
    }

    public static PowerStats mapBack(Optional<PowerStatsEntity> powerStatsEntityOptional) {
    	PowerStatsEntity powerStatsEntity = powerStatsEntityOptional.get();
    	PowerStats powerStats = new PowerStats();
    	powerStats.setId(powerStatsEntity.getId());
    	powerStats.setAgility(Short.valueOf(powerStatsEntity.getAgility()));
    	
    	return powerStats;
    }
}
