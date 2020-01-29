package br.com.brainweb.interview.core.features.hero.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.brainweb.interview.core.features.hero.entity.HeroEntity;
import br.com.brainweb.interview.core.features.powerstats.util.PowerStatsMapper;
import br.com.brainweb.interview.model.Hero;
import br.com.brainweb.interview.model.Hero.Race;

public class HeroMapper {

    public static HeroEntity map(Hero hero) {
        return HeroEntity.newHeroEntity()
            .name(hero.getName())
            .race(hero.getRace().name())
            .enabled(hero.getEnabled())
            .updatedAt(LocalDateTime.now())
            .createdAt(LocalDateTime.now())
            .powerStatsId(hero.getPowerStats().getId())
            .powerStatsEntity(PowerStatsMapper.map(hero.getPowerStats()))
            .build();
    }
    
    public static HeroEntity mapNameFilter(Hero hero) {
        return HeroEntity.newHeroEntity()
            .name(hero.getName())
            .build();
    }
    
    public static HeroEntity mapIdFilter(Hero hero) {
        return HeroEntity.newHeroEntity()
            .id(hero.getId())
            .build();
    }

    public static List<Hero> mapBackList(Optional<List<HeroEntity>> heroEntityOptionalList) {
    	List<HeroEntity> heroEntityList = heroEntityOptionalList.get();
    	List<Hero> heroList = new ArrayList<>();
    	for(HeroEntity current : heroEntityList) {
        	Hero hero = new Hero();
        	hero.setName(current.getName());
        	heroList.add(hero);
    	}
    	
    	return heroList;


    }
    
    public static Hero mapBack(Optional<HeroEntity> heroEntityOptional) {
    	HeroEntity heroEntity = heroEntityOptional.get();
    	Hero hero = new Hero();
    	hero.setId(heroEntity.getId());
    	hero.setName(heroEntity.getName());
    	hero.setRace(Race.valueOf(heroEntity.getRace()));
    	hero.setEnabled(heroEntity.getEnabled());
    	hero.setUpdatedAt(heroEntity.getUpdatedAt());
    	hero.setCreatedAt(heroEntity.getCreatedAt());
    	//hero.setPowerStats(PowerStatsMapper.mapBack(powerStatsEntityOptional)(heroEntity.getPowerStatsEntity()));
    	
    	return hero;
    }
}
