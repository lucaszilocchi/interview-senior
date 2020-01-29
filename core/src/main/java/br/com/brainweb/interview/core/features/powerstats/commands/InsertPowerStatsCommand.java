package br.com.brainweb.interview.core.features.powerstats.commands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import br.com.brainweb.interview.core.features.hero.entity.PowerStatsEntity;

public class InsertPowerStatsCommand implements Supplier<List<PowerStatsEntity>>{

    private NamedParameterJdbcTemplate jdbcTemplate;

    private PowerStatsEntity powerStats;

    private static final String INSERT = "INSERT INTO POWER_STATS( " +
                                         "strength, " +
                                         "agility, " +
                                         "dexterity, " +
                                         "intelligence, " +
                                         "created_at, " +
                                         "updated_at) " +
                                         "VALUES(:strength, :agility, :dexterity, :intelligence, :created_at, :updated_at) " +
                                         "RETURNING id, strength, agility, dexterity, intelligence, created_at, updated_at";
    
    private static final String SELECT = "SELECT * FROM POWER_STATS WHERE id = :id ";

    public InsertPowerStatsCommand(NamedParameterJdbcTemplate jdbcTemplate, PowerStatsEntity powerStatsInsertion) {
        this.jdbcTemplate = jdbcTemplate;
        this.powerStats = powerStatsInsertion;
    }
    
    private SqlParameterSource parameterSource() {
        return new MapSqlParameterSource().addValue("strength", powerStats.getStrength())
            .addValue("agility", powerStats.getAgility())
            .addValue("dexterity", powerStats.getDexterity())
            .addValue("intelligence", powerStats.getIntelligence())
            .addValue("created_at", powerStats.getCreated_at())
            .addValue("updated_at", powerStats.getUpdated_at());
    }
    
    RowMapper<PowerStatsEntity> mapper = new RowMapper<PowerStatsEntity>() {
        public PowerStatsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        	PowerStatsEntity powerStatsEntity = PowerStatsEntity.newPowerStatsEntity().build();
        	powerStatsEntity.setId(rs.getObject("id", UUID.class));
        	powerStatsEntity.setAgility(rs.getShort("agility"));
        	powerStatsEntity.setDexterity(rs.getShort("dexterity"));
        	powerStatsEntity.setIntelligence(rs.getShort("intelligence"));
        	powerStatsEntity.setStrength(rs.getShort("strength"));
        	powerStatsEntity.setCreated_at(rs.getObject("created_at", Timestamp.class).toLocalDateTime());
        	powerStatsEntity.setUpdated_at(rs.getObject("updated_at", Timestamp.class).toLocalDateTime());
            
        	return powerStatsEntity;
        }
    };
	
	@Override
	public List<PowerStatsEntity> get() {
        return jdbcTemplate.query(INSERT, parameterSource(), mapper);
	}
	
    public PowerStatsEntity findPowerStatsByid() {
    	return (PowerStatsEntity) jdbcTemplate.queryForObject(SELECT, this.parameterSource(), mapper);
    }

}
