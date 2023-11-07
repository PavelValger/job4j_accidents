package ru.job4j.accidents.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Rule;

import java.util.Collection;

@Repository
@AllArgsConstructor
public class JdbcRuleRepository implements RuleRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Rule> ruleRowMapper = (resultSet, rowNum) -> {
        Rule rule = new Rule();
        rule.setId(resultSet.getInt("id"));
        rule.setName(resultSet.getString("rule_name"));
        return rule;
    };

    @Override
    public Collection<Rule> findAll() {
        return jdbcTemplate.query("select * from rules", ruleRowMapper);
    }

    @Override
    public Collection<Rule> findAllById(Collection<Integer> rulesId) {
        return rulesId.stream().map(ruleId -> jdbcTemplate.queryForObject(
                "select * from rules where id = ?", ruleRowMapper, ruleId)).toList();
    }
}
