package br.com.brainweb.interview.core.features.powerstats;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.brainweb.interview.core.features.hero.entity.PowerStatsEntity;
import br.com.brainweb.interview.core.features.powerstats.util.PowerStatsMapper;
import br.com.brainweb.interview.model.PowerStats;

@Service
public class PowerStatsService {
	
    @Autowired
    private PowerStatsRepository repository;
/*
    public PowerStats save(PowerStats powerStats) {
        return PowerStatsMapper.mapBack(repository.insertHero(HeroMapper.map(powerStats)));
    }
    */
    public PowerStats findPowerStastById(PowerStatsEntity powerStatsEntity){
    	Optional<PowerStatsEntity> result = repository.findPowerStatsById(PowerStatsMapper.mapNameFilter(powerStatsEntity));
    	if (!result.isPresent()) {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PowerStatus" + powerStatsEntity.getId() + " not found.");
		}
    	
    	return PowerStatsMapper.mapBack(result);
    }
    
}
