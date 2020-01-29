package br.com.brainweb.interview.core.features.hero;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.brainweb.interview.core.features.hero.entity.HeroEntity;
import br.com.brainweb.interview.core.features.hero.util.HeroMapper;
import br.com.brainweb.interview.model.Hero;

@Service
public class HeroService {

    @Autowired
    private HeroRepository repository;

    public Hero save(Hero hero) {
        return HeroMapper.mapBack(repository.insertHero(HeroMapper.map(hero)));
    }
    
    public Hero findHeroByName(Hero heroEntityFilter){
    	Optional<HeroEntity> result = repository.findHeroByName(HeroMapper.mapNameFilter(heroEntityFilter));
    	if (!result.isPresent()) {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hero " + heroEntityFilter.getName() + " not found.");
		}
    	
    	return HeroMapper.mapBack(result);
    }
    
    public Hero findHeroById(Hero heroEntityFilter){
    	Optional<HeroEntity> result = repository.findHeroById(HeroMapper.mapIdFilter(heroEntityFilter));
    	if (!result.isPresent()) {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hero " + heroEntityFilter.getName() + " not found.");
		}
    	
    	return HeroMapper.mapBack(result);
    }
    
}
