package com.flagguesser.dao;

import com.flagguesser.exception.DaoException;
import com.flagguesser.model.Country;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcCountryDao implements CountryDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCountryDao (DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Country getCountry(int id) {
        Country country = null;
        String sql = "SELECT * FROM country WHERE country_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                country = mapRowToCountry(results);
            } else {
                throw new DaoException("Could not retrieve country data");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database", e);
        }
        return country;
    }

    private Country mapRowToCountry(SqlRowSet results) {
        Country country = new Country();
        country.setCountryId(results.getInt("country_id"));
        country.setName(results.getString("name"));
        country.setCode(results.getString("code"));
        country.setCapital(results.getString("capital"));
        country.setContinent(results.getString("continent"));
        country.setFlagImage(results.getString("flag_image"));
        return country;
    }
}
