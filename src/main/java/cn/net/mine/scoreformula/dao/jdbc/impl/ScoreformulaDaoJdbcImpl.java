package cn.net.mine.scoreformula.dao.jdbc.impl;

import java.util.List;
import java.util.Map;

import cn.net.mine.scoreformula.dao.ScoreformulaDao;
import org.springframework.stereotype.Repository;


import cn.net.mine.common.SuperJdbcTemplate;

@Repository
public class ScoreformulaDaoJdbcImpl extends SuperJdbcTemplate implements ScoreformulaDao {


    @Override
    public Object scoreformulaAdd(String formula, String type, String explain) {
        StringBuffer sql = new StringBuffer();


        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String format = sdf.format(date);
        sql.append("INSERT INTO Scoreformula( formula,  type,  explain  )");
        sql.append(" VALUES(");
        sql.append("'").append(formula).append("',");
        sql.append("'").append(type).append("',");
        sql.append("'").append(explain).append("'");


        sql.append(")");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object scoreformulaUpdate(String id, String formula, String type, String explain) {
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        // String format = sdf.format(date);

        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE Scoreformula SET ");
        if (formula != null && !formula.equals(""))
            sql.append(" formula = '").append(formula).append("',");
        if (type != null && !type.equals(""))
            sql.append(" type = '").append(type).append("',");
        if (explain != null && !explain.equals(""))
            sql.append(" explain = '").append(explain).append("',");

        sql.append(" id = '").append(id).append("'");
        sql.append(" WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object scoreformulaDel(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM Scoreformula WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }


    @Override
    public List<Map<String, Object>> selectScoreformulaList(Integer pageNo, Integer pagesize, String formula, String type, String explain) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Scoreformula u where 1=1 ");
        if (formula != null && !formula.equals("")) {
            sql.append(" and u.formula LIKE '%").append(formula).append("%'");
        }
        if (type != null && !type.equals("")) {
            sql.append(" and u.type LIKE '%").append(type).append("%'");
        }
        if (explain != null && !explain.equals("")) {
            sql.append(" and u.explain LIKE '%").append(explain).append("%'");
        }


        sql.append(" limit " + (pageNo - 1) * pagesize + " , " + pagesize + " ");

        return jdbcTemplateCsms.queryForList(sql.toString());

    }

    @Override
    public Integer count(String formula, String type, String explain) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Scoreformula u where 1=1 ");
        if (formula != null && !formula.equals("")) {
            sql.append(" and u.formula LIKE '%").append(formula).append("%'");
        }
        if (type != null && !type.equals("")) {
            sql.append(" and u.type LIKE '%").append(type).append("%'");
        }
        if (explain != null && !explain.equals("")) {
            sql.append(" and u.explain LIKE '%").append(explain).append("%'");
        }


        return jdbcTemplateCsms.queryForList(sql.toString()).size();
    }


    @Override
    public List<Map<String, Object>> selectScoreformula(String id) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Scoreformula u where 1=1 ");

        sql.append(" and u.id = '").append(id).append("'");


        return jdbcTemplateCsms.queryForList(sql.toString());

    }


    @Override
    public List<Map<String, Object>> selectGetScoreformulaList(String formula, String type, String explain) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Scoreformula u where 1=1 ");
        if (formula != null && !formula.equals("")) {
            sql.append(" and u.formula LIKE '%").append(formula).append("%'");
        }
        if (type != null && !type.equals("")) {
            sql.append(" and u.type LIKE '%").append(type).append("%'");
        }
        if (explain != null && !explain.equals("")) {
            sql.append(" and u.explain LIKE '%").append(explain).append("%'");
        }

        return jdbcTemplateCsms.queryForList(sql.toString());
    }

}
