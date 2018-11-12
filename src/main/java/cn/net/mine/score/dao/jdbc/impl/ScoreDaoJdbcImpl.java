package cn.net.mine.score.dao.jdbc.impl;

import java.util.List;
import java.util.Map;

import cn.net.mine.score.dao.ScoreDao;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;


import cn.net.mine.common.SuperJdbcTemplate;

@Repository
public class ScoreDaoJdbcImpl extends SuperJdbcTemplate implements ScoreDao {


    @Override
    public Object scoreAdd(String prono, String unitno, String sectionno, String type, String tablename, String score ) {
        StringBuffer sql = new StringBuffer();

        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String format = sdf.format(date);
        sql.append("INSERT INTO Score( prono,  unitno,  sectionno,  type,  tablename,score  )");
        sql.append(" VALUES(");
        sql.append("'").append(prono).append("',");
        sql.append("'").append(unitno).append("',");
        sql.append("'").append(sectionno).append("',");
        sql.append("'").append(type).append("',");
        sql.append("'").append(tablename).append("',");
        sql.append("'").append(score).append("'");
        sql.append(")");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object scoreUpdate(String id, String prono, String unitno, String sectionno, String type, String tablename, String score ) {
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        // String format = sdf.format(date);

        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE Score SET ");
        if (prono != null && !prono.equals(""))
            sql.append(" prono = '").append(prono).append("',");
        if (unitno != null && !unitno.equals(""))
            sql.append(" unitno = '").append(unitno).append("',");
        if (sectionno != null && !sectionno.equals(""))
            sql.append(" sectionno = '").append(sectionno).append("',");
        if (type != null && !type.equals(""))
            sql.append(" type = '").append(type).append("',");
        if (tablename != null && !tablename.equals(""))
            sql.append(" tablename = '").append(tablename).append("',");
        if (score != null && !score.equals(""))
            sql.append(" score = '").append(score).append("',");


        sql.append(" id = '").append(id).append("'");
        sql.append(" WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object scoreDel(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM Score WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }


    @Override
    public List<Map<String, Object>> selectScoreList(Integer pageNo, Integer pagesize, String prono, String unitno, String sectionno, String type, String tablename, String score ) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Score u where 1=1 ");
        if (prono != null && !prono.equals("")) {
            sql.append(" and u.prono LIKE '%").append(prono).append("%'");
        }
        if (unitno != null && !unitno.equals("")) {
            sql.append(" and u.unitno LIKE '%").append(unitno).append("%'");
        }
        if (sectionno != null && !sectionno.equals("")) {
            sql.append(" and u.sectionno LIKE '%").append(sectionno).append("%'");
        }
        if (type != null && !type.equals("")) {
            sql.append(" and u.type LIKE '%").append(type).append("%'");
        }
        if (tablename != null && !tablename.equals("")) {
            sql.append(" and u.tablename LIKE '%").append(tablename).append("%'");
        }
        if (score != null && !score.equals("")) {
            sql.append(" and u.score LIKE '%").append(score).append("%'");
        }

        sql.append(" limit " + (pageNo - 1) * pagesize + " , " + pagesize + " ");

        return jdbcTemplateCsms.queryForList(sql.toString());

    }

    @Override
    public Integer count(String prono, String unitno, String sectionno, String type, String tablename, String score ) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Score u where 1=1 ");
        if (prono != null && !prono.equals("")) {
            sql.append(" and u.prono LIKE '%").append(prono).append("%'");
        }
        if (unitno != null && !unitno.equals("")) {
            sql.append(" and u.unitno LIKE '%").append(unitno).append("%'");
        }
        if (sectionno != null && !sectionno.equals("")) {
            sql.append(" and u.sectionno LIKE '%").append(sectionno).append("%'");
        }
        if (type != null && !type.equals("")) {
            sql.append(" and u.type LIKE '%").append(type).append("%'");
        }
        if (tablename != null && !tablename.equals("")) {
            sql.append(" and u.tablename LIKE '%").append(tablename).append("%'");
        }
        if (score != null && !score.equals("")) {
            sql.append(" and u.score LIKE '%").append(score).append("%'");
        }

        return jdbcTemplateCsms.queryForList(sql.toString()).size();
    }


    @Override
    public List<Map<String, Object>> selectScore(String id) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Score u where 1=1 ");

        sql.append(" and u.id = '").append(id).append("'");


        return jdbcTemplateCsms.queryForList(sql.toString());

    }


    @Override
    public List<Map<String, Object>> selectGetScoreList(String prono, String unitno, String sectionno, String type, String tablename, String score) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Score u where 1=1 ");
        if (prono != null && !prono.equals("")) {
            sql.append(" and u.prono LIKE '%").append(prono).append("%'");
        }
        if (unitno != null && !unitno.equals("")) {
            sql.append(" and u.unitno LIKE '%").append(unitno).append("%'");
        }
        if (sectionno != null && !sectionno.equals("")) {
            sql.append(" and u.sectionno LIKE '%").append(sectionno).append("%'");
        }
        if (type != null && !type.equals("")) {
            sql.append(" and u.type LIKE '%").append(type).append("%'");
        }
        if (tablename != null && !tablename.equals("")) {
            sql.append(" and u.tablename LIKE '%").append(tablename).append("%'");
        }
        if (score != null && !score.equals("")) {
            sql.append(" and u.score LIKE '%").append(score).append("%'");
        }

        return jdbcTemplateCsms.queryForList(sql.toString());
    }


}
