package br.com.brainweb.interview.core.features.hero;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.brainweb.interview.model.Hero;

@RestController
public class HeroController {
	
	@Autowired
	private HeroService heroService;
	
	@PostMapping("/heroes")
	public ResponseEntity<String> saveHero(@RequestBody Hero hero) {
		ResponseEntity<String> response;
		try {
			if (heroService.save(hero) != null) {
				response = ResponseEntity.ok("Hero saved successfully!");
			} else {
				response = ResponseEntity.status(500).body("Error saving hero.");
			}
		} catch (Exception e) {
			response = ResponseEntity.status(500).body("Error saving hero: " + e.getMessage());
		}
		return response;
	}
	
	@GetMapping("/heroes")
	public ResponseEntity<Hero> getHeroByName(@RequestParam("name") String name) {
		ResponseEntity<Hero> response;
		Hero result = null;
		
		Hero heroFilter = new Hero();
		heroFilter.setName(name);
		
		try {
			result = heroService.findHeroByName(heroFilter);
			if(result == null) {
				response = ResponseEntity.status(404).body(null);
			}
		}catch(EmptyResultDataAccessException e) {
			return ResponseEntity.status(404).body(null);
		}catch(Exception e) {
			return ResponseEntity.status(500).body(heroFilter);
		}
		
		return ResponseEntity.status(200).body(result);
	}
	
	@GetMapping("/heroes/{id}")
	public ResponseEntity<Hero> getHeroById(@PathVariable(value = "id") String id) {
		ResponseEntity<Hero> response;
		Hero result = null;
		
		Hero heroFilter = new Hero();
		heroFilter.setId(UUID.fromString(id));
		
		try {
			result = heroService.findHeroById(heroFilter);
			if(result == null) {
				response = ResponseEntity.status(404).body(null);
			}
		}catch(EmptyResultDataAccessException e) {
			return ResponseEntity.ok(null);
		}catch(Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
		return ResponseEntity.status(200).body(result);
	}
}
