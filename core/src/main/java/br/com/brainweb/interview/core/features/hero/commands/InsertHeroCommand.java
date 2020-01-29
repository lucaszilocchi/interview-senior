package br.com.brainweb.interview.core.features.hero.commands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import br.com.brainweb.interview.core.features.hero.entity.HeroEntity;
import br.com.brainweb.interview.core.features.hero.entity.PowerStatsEntity;
import br.com.brainweb.interview.core.features.powerstats.commands.InsertPowerStatsCommand;

public class InsertHeroCommand implements Supplier<List<HeroEntity>> {

    private NamedParameterJdbcTemplate jdbcTemplate;

    private HeroEntity heroEntity;

    private static final String INSERT = "INSERT INTO HERO( " +
                                         "name, " +
                                         "race, " +
                                         "power_stats_id, " +
                                         "enabled, " +
                                         "created_at, " +
                                         "updated_at) " +
                                         "VALUES(:name, :race, :power_stats_id, :enabled, :created_at, :updated_at) " +
                                         "RETURNING id, name, race, power_stats_id, enabled, created_at, updated_at";
    
    private static final String SELECT_BY_NAME = "SELECT * FROM hero WHERE name = :name ";
    
    private static final String SELECT_BY_ID = "SELECT * FROM hero WHERE id = :id ";

    public InsertHeroCommand(NamedParameterJdbcTemplate jdbcTemplate, HeroEntity heroInsertion) {
        this.jdbcTemplate = jdbcTemplate;
        this.heroEntity = heroInsertion;
    }

    @Override
    public List<HeroEntity> get() {
    	List<PowerStatsEntity> result = new InsertPowerStatsCommand(jdbcTemplate, heroEntity.getPowerStatsEntity()).get();
    	if(result != null && !result.isEmpty()) {
    		this.heroEntity.setPowerStatsEntity(result.get(0));
    		this.heroEntity.setPowerStatsId(result.get(0).getId());
    	}
        return jdbcTemplate.query(INSERT, parameterSource(), rowMapper());
    }

    private SqlParameterSource parameterSource() {
        return new MapSqlParameterSource().addValue("id", heroEntity.getId())
        	 .addValue("name", heroEntity.getName())
            .addValue("race", heroEntity.getRace())
            .addValue("power_stats_id", heroEntity.getPowerStatsId())
            .addValue("enabled", Boolean.valueOf(heroEntity.getEnabled()))
            .addValue("created_at", heroEntity.getCreatedAt())
            .addValue("updated_at", heroEntity.getUpdatedAt());
    }
    
    private RowMapper<HeroEntity> rowMapper() {
        return (resultSet, i) -> HeroEntity.newHeroEntity()
            .id(resultSet.getObject("id", UUID.class))
            .name(heroEntity.getName())
            .powerStatsId(heroEntity.getPowerStatsId())
            .race(heroEntity.getRace())
            .enabled(heroEntity.getEnabled())
            .createdAt(heroEntity.getCreatedAt())
            .updatedAt(heroEntity.getUpdatedAt())
            .powerStatsEntity(heroEntity.getPowerStatsEntity())
            .powerStatsId(heroEntity.getPowerStatsEntity().getId())
            .build();
    }
    
    RowMapper<HeroEntity> mapper = new RowMapper<HeroEntity>() {
        public HeroEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        	HeroEntity heroEntity = HeroEntity.newHeroEntity().build();
        	heroEntity.setId(rs.getObject("id", UUID.class));
        	heroEntity.setName(rs.getString("name"));
        	heroEntity.setRace(rs.getString("race"));
        	heroEntity.setPowerStatsId(rs.getObject("power_stats_id", UUID.class));
        	heroEntity.setEnabled(rs.getString("enabled"));
        	heroEntity.setCreatedAt(rs.getObject("created_at", Timestamp.class).toLocalDateTime());
        	heroEntity.setUpdatedAt(rs.getObject("updated_at", Timestamp.class).toLocalDateTime());
            return heroEntity;
        }
    };

    
    public HeroEntity findHeroByName() {
    	return (HeroEntity) jdbcTemplate.queryForObject(SELECT_BY_NAME, this.parameterSource(), mapper);
    }
    
    public HeroEntity findHeroById() {
    	return (HeroEntity) jdbcTemplate.queryForObject(SELECT_BY_ID, this.parameterSource(), mapper);
    }
}
