package br.com.brainweb.interview.core.features.powerstats;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.brainweb.interview.core.features.hero.entity.PowerStatsEntity;
import br.com.brainweb.interview.core.features.powerstats.commands.InsertPowerStatsCommand;

@Repository
public class PowerStatsRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
    public Optional<PowerStatsEntity> insertPowerStats(PowerStatsEntity powerStatsInsertion) {
        return new InsertPowerStatsCommand(jdbcTemplate, powerStatsInsertion).get().stream().findFirst();
    }
    
    public Optional<PowerStatsEntity> findPowerStatsById(PowerStatsEntity filter){
    	return Optional.of(new InsertPowerStatsCommand(jdbcTemplate, filter).findPowerStatsByid());
    }
	
}
