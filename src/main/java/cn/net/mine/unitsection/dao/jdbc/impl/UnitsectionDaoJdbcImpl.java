package cn.net.mine.unitsection.dao.jdbc.impl;

import java.util.List;
import java.util.Map;

import cn.net.mine.unitsection.dao.UnitsectionDao;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import cn.net.mine.common.SuperJdbcTemplate;

@Repository
public class UnitsectionDaoJdbcImpl extends SuperJdbcTemplate implements UnitsectionDao {

    @Override
    public Object unitsectionAdd(String sectionno, String sectionname, String unitno) {
        StringBuffer sql = new StringBuffer();
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String format = sdf.format(date);
        sql.append("INSERT INTO unitsection ( sectionno,sectionname,unitno )");
        sql.append(" VALUES(");
        sql.append("'").append(sectionno).append("',");
        sql.append("'").append(sectionname).append("',");
        sql.append("'").append(unitno).append("'");

        sql.append(")");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object unitsectionUpdate(String id, String sectionno, String sectionname, String unitno) {
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        // String format = sdf.format(date);

        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE unitsection SET ");
        if (sectionno != null && !sectionno.equals(""))
            sql.append(" sectionno = '").append(sectionno).append("',");
        if (sectionname != null && !sectionname.equals(""))
            sql.append(" sectionname = '").append(sectionname).append("',");
        if (unitno != null && !unitno.equals(""))
            sql.append(" unitno = '").append(unitno).append("',");

        sql.append(" id = '").append(id).append("'");
        sql.append(" WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object unitsectionDel(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM unitsection WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public int findBtName(String sectionno) {
        StringBuffer sql = new StringBuffer();
        sql.append("select count(id) from unitsection where sectionno ='");
        sql.append(sectionno).append("'");
        List<Integer> list = jdbcTemplateCsms.queryForList(sql.toString(), Integer.class);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return 0;
    }

    @Override
    public int findBtName(String sectionno, String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("select count(id) from unitsection where sectionno ='");
        sql.append(sectionno).append("' AND id !='").append(id).append("'");
        List<Integer> list = jdbcTemplateCsms.queryForList(sql.toString(), Integer.class);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return 0;
    }


    @Override
    public List<Map<String, Object>> selectUnitsectionList(Integer pageNo, Integer pagesize, String sectionno, String sectionname, String unitno) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from unitsection u where 1=1 ");
        if (sectionno != null && !sectionno.equals("")) {
            sql.append(" and u.sectionno LIKE '%").append(sectionno).append("%'");
        }
        if (sectionname != null && !sectionname.equals("")) {
            sql.append(" AND u.sectionname LIKE '%").append(sectionname).append("%'");
        }
        if (unitno != null && !unitno.equals("")) {
            sql.append(" AND u.unitno LIKE '%").append(unitno).append("%'");
        }


        sql.append(" limit " + (pageNo - 1) * pagesize + " , " + pagesize + " ");

        return jdbcTemplateCsms.queryForList(sql.toString());

    }

    @Override
    public Integer count(String sectionno, String sectionname, String unitno) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from unitsection u where 1=1 ");
        if (sectionno != null && !sectionno.equals("")) {
            sql.append(" and u.sectionno LIKE '%").append(sectionno).append("%'");
        }
        if (sectionname != null && !sectionname.equals("")) {
            sql.append(" AND u.sectionname LIKE '%'").append(sectionname).append("%'");
        }
        if (unitno != null && !unitno.equals("")) {
            sql.append(" AND u.unitno LIKE '%'").append(unitno).append("%'");
        }


        return jdbcTemplateCsms.queryForList(sql.toString()).size();
    }


    @Override
    public List<Map<String, Object>> selectUnitsection(String id) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from unitsection u where 1=1 ");

        sql.append(" and u.id = '").append(id).append("'");


        return jdbcTemplateCsms.queryForList(sql.toString());

    }

    @Override
    public List<Map<String, Object>> selectGetUnitsectionList(String sectionno, String sectionname, String unitno) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from unitsection u where 1=1 ");
        if (sectionno != null && !sectionno.equals("")) {
            sql.append(" and u.sectionno LIKE '%").append(sectionno).append("%'");
        }
        if (sectionname != null && !sectionname.equals("")) {
            sql.append(" AND u.sectionname LIKE '%").append(sectionname).append("%'");
        }
        if (unitno != null && !unitno.equals("")) {
            sql.append(" AND u.unitno = '").append(unitno).append("'");
        }

        return jdbcTemplateCsms.queryForList(sql.toString());
    }
}
