package cn.net.mine.projectunit.dao.jdbc.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import cn.net.mine.common.SuperJdbcTemplate;
import cn.net.mine.projectunit.dao.ProjectunitDao;

@Repository
public class ProjectunitDaoJdbcImpl extends SuperJdbcTemplate implements ProjectunitDao {

    @Override
    public Object projectunitAdd(String unitno, String unitname, String prono) {
        StringBuffer sql = new StringBuffer();
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String format = sdf.format(date);
        sql.append("INSERT INTO projectunit(unitno,  unitname,  prono )");
        sql.append(" VALUES(");
        sql.append("'").append(unitno).append("',");
        sql.append("'").append(unitname).append("',");
        sql.append("'").append(prono).append("'");

        sql.append(")");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object projectunitUpdate(String id, String unitno, String unitname, String prono) {
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        // String format = sdf.format(date);

        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE projectunit SET ");
        sql.append(" unitno = '").append(unitno).append("',");
        sql.append(" unitname = '").append(unitname).append("',");
        sql.append(" prono = '").append(prono).append("'");


        sql.append(" WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object projectunitDel(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM projectunit WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public int findBtName(String unitno) {
        StringBuffer sql = new StringBuffer();
        sql.append("select count(id) from projectunit where unitno ='");
        sql.append(unitno).append("'");
        List<Integer> list = jdbcTemplateCsms.queryForList(sql.toString(), Integer.class);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return 0;
    }

    @Override
    public int findBtName(String unitno, String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("select count(id) from projectunit where unitno ='");
        sql.append(unitno).append("' AND id !='").append(id).append("'");
        List<Integer> list = jdbcTemplateCsms.queryForList(sql.toString(), Integer.class);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return 0;
    }


    @Override
    public List<Map<String, Object>> selectProjectunitList(Integer pageNo, Integer pagesize, String unitno, String unitname, String prono) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from projectunit u where 1=1 ");
        if (unitno != null && !unitno.equals("")) {
            sql.append(" and u.unitno = '").append(unitno).append("'");
        }
        if (unitname != null && !unitname.equals("")) {
            sql.append(" AND u.unitname = '").append(unitname).append("'");
        }

        if (prono != null && !prono.equals("")) {
            sql.append(" AND u.prono = '").append(prono).append("'");
        }

        sql.append(" limit " + (pageNo - 1) * pagesize + " , " + pagesize + " ");

        return jdbcTemplateCsms.queryForList(sql.toString());

    }

    @Override
    public Integer count(String unitno, String unitname, String prono) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from projectunit u where 1=1 ");
        if (unitno != null && !unitno.equals("")) {
            sql.append(" and u.unitno = '").append(unitno).append("'");
        }
        if (unitname != null && !unitname.equals("")) {
            sql.append(" AND u.unitname = '").append(unitname).append("'");
        }

        if (prono != null && !prono.equals("")) {
            sql.append(" AND u.prono = '").append(prono).append("'");
        }
        return jdbcTemplateCsms.queryForList(sql.toString()).size();
    }

    @Override
    public List<Map<String, Object>> selectProjectunit(String id) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from projectunit u where 1=1 ");

        sql.append(" and u.id = '").append(id).append("'");


        return jdbcTemplateCsms.queryForList(sql.toString());

    }


}
