package br.com.brainweb.interview.core.features.hero;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.brainweb.interview.core.features.hero.commands.InsertHeroCommand;
import br.com.brainweb.interview.core.features.hero.entity.HeroEntity;

@Repository
public class HeroRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Optional<HeroEntity> insertHero(HeroEntity heroInsertion) {
        return new InsertHeroCommand(jdbcTemplate, heroInsertion).get().stream().findFirst();
    }
    
    public Optional<HeroEntity> findHeroByName(HeroEntity filter){
    	return Optional.of(new InsertHeroCommand(jdbcTemplate, filter).findHeroByName());
    }
    
    public Optional<HeroEntity> findHeroById(HeroEntity filter){
    	return Optional.of(new InsertHeroCommand(jdbcTemplate, filter).findHeroById());
    }
}
