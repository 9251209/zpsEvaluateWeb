package cn.net.mine.scoresum.dao.jdbc.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cn.net.mine.scoresum.dao.ScoresumDao;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;


import cn.net.mine.common.SuperJdbcTemplate;

@Repository
public class ScoresumDaoJdbcImpl extends SuperJdbcTemplate implements ScoresumDao {


    @Override
    public Object scoresumAdd(String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum, String scorename, String userno) {
        StringBuffer sql = new StringBuffer();

        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String format = sdf.format(date);
        sql.append("INSERT INTO Scoresum(id,prono,unitno,sectionno,resourcevalue,energyvalue,manpowervalue,totalvalue,starlevel,resourcenum,energynum,manpowernum,scorename,userno)");
        sql.append(" VALUES(");
        sql.append("'").append(str).append("',");
        sql.append("'").append(prono).append("',");
        sql.append("'").append(unitno).append("',");
        sql.append("'").append(sectionno).append("',");
        sql.append("'").append(resourcevalue).append("',");
        sql.append("'").append(energyvalue).append("',");
        sql.append("'").append(manpowervalue).append("',");
        sql.append("'").append(totalvalue).append("',");
        sql.append("'").append(starlevel).append("',");
        sql.append("'").append(resourcenum).append("',");
        sql.append("'").append(energynum).append("',");
        sql.append("'").append(manpowernum).append("',");
        sql.append("'").append(scorename).append("',");
        sql.append("'").append(userno).append("'");
        sql.append(")");
        Integer a = jdbcTemplateCsms.update(sql.toString());
        if (a > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("data", str);
            return map;//获得刚刚插入的id
        }
        return "";
    }

    @Override
    public Object scoresumUpdate(String id, String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum, String scorename, String userno) {
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        // String format = sdf.format(date);

        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE Scoresum SET ");
        if (prono != null && !prono.equals(""))
            sql.append(" prono = '").append(prono).append("',");
        if (unitno != null && !unitno.equals(""))
            sql.append(" unitno = '").append(unitno).append("',");
        if (sectionno != null && !sectionno.equals(""))
            sql.append(" sectionno = '").append(sectionno).append("',");
        if (resourcevalue != null && !resourcevalue.equals(""))
            sql.append(" resourcevalue = '").append(resourcevalue).append("',");
        if (energyvalue != null && !energyvalue.equals(""))
            sql.append(" energyvalue = '").append(energyvalue).append("',");
        if (manpowervalue != null && !manpowervalue.equals(""))
            sql.append(" manpowervalue = '").append(manpowervalue).append("',");
        if (totalvalue != null && !totalvalue.equals(""))
            sql.append(" totalvalue = '").append(totalvalue).append("',");
        if (starlevel != null && !starlevel.equals(""))
            sql.append(" starlevel = '").append(starlevel).append("',");
        if (resourcenum != null && !resourcenum.equals(""))
            sql.append(" resourcenum = '").append(resourcenum).append("',");
        if (energynum != null && !energynum.equals(""))
            sql.append(" energynum = '").append(energynum).append("',");
        if (manpowernum != null && !manpowernum.equals(""))
            sql.append(" manpowernum = '").append(manpowernum).append("',");

        if (scorename != null && !scorename.equals(""))
            sql.append(" scorename = '").append(scorename).append("',");
        if (userno != null && !userno.equals(""))
            sql.append("userno = '").append(userno).append("',");

        sql.append(" id = '").append(id).append("'");
        sql.append(" WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object scoresumDel(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM Scoresum WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }


    @Override
    public List<Map<String, Object>> selectScoresumList(Integer pageNo, Integer pagesize, String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum, String scorename, String userno) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Scoresum u where 1=1 ");
        if (prono != null && !prono.equals("")) {
            sql.append(" and u.prono = '").append(prono).append("'");
        }
        if (unitno != null && !unitno.equals("")) {
            sql.append(" and u.unitno = '").append(unitno).append("'");
        }
        if (sectionno != null && !sectionno.equals("")) {
            sql.append(" and u.sectionno = '").append(sectionno).append("'");
        }
        if (resourcevalue != null && !resourcevalue.equals("")) {
            sql.append(" and u.resourcevalue LIKE '%").append(resourcevalue).append("%'");
        }
        if (energyvalue != null && !energyvalue.equals("")) {
            sql.append(" and u.energyvalue LIKE '%").append(energyvalue).append("%'");
        }
        if (manpowervalue != null && !manpowervalue.equals("")) {
            sql.append(" and u.manpowervalue LIKE '%").append(manpowervalue).append("%'");
        }
        if (totalvalue != null && !totalvalue.equals("")) {
            sql.append(" and u.totalvalue LIKE '%").append(totalvalue).append("%'");
        }
        if (starlevel != null && !starlevel.equals("")) {
            sql.append(" and u.starlevel LIKE '%").append(starlevel).append("%'");
        }
        if (resourcenum != null && !resourcenum.equals("")) {
            sql.append(" and u.resourcenum LIKE '%").append(resourcenum).append("%'");
        }
        if (energynum != null && !energynum.equals("")) {
            sql.append(" and u.energynum LIKE '%").append(energynum).append("%'");
        }
        if (manpowernum != null && !manpowernum.equals("")) {
            sql.append(" and u.manpowernum LIKE '%").append(manpowernum).append("%'");
        }
        if (scorename != null && !scorename.equals("")) {
            sql.append(" and u.scorename LIKE '%").append(scorename).append("%'");
        }
        if (userno != null && !userno.equals("")) {
            sql.append(" and u.userno LIKE '%").append(userno).append("%'");
        }

        sql.append(" limit " + (pageNo - 1) * pagesize + " , " + pagesize + " ");

        return jdbcTemplateCsms.queryForList(sql.toString());

    }

    @Override
    public Integer count(String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum, String scorename, String userno) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Scoresum u where 1=1 ");
        if (prono != null && !prono.equals("")) {
            sql.append(" and u.prono = '").append(prono).append("'");
        }
        if (unitno != null && !unitno.equals("")) {
            sql.append(" and u.unitno = '").append(unitno).append("'");
        }
        if (sectionno != null && !sectionno.equals("")) {
            sql.append(" and u.sectionno = '").append(sectionno).append("'");
        }
        if (resourcevalue != null && !resourcevalue.equals("")) {
            sql.append(" and u.resourcevalue LIKE '%").append(resourcevalue).append("%'");
        }
        if (energyvalue != null && !energyvalue.equals("")) {
            sql.append(" and u.energyvalue LIKE '%").append(energyvalue).append("%'");
        }
        if (manpowervalue != null && !manpowervalue.equals("")) {
            sql.append(" and u.manpowervalue LIKE '%").append(manpowervalue).append("%'");
        }
        if (totalvalue != null && !totalvalue.equals("")) {
            sql.append(" and u.totalvalue LIKE '%").append(totalvalue).append("%'");
        }
        if (starlevel != null && !starlevel.equals("")) {
            sql.append(" and u.starlevel LIKE '%").append(starlevel).append("%'");
        }
        if (resourcenum != null && !resourcenum.equals("")) {
            sql.append(" and u.resourcenum LIKE '%").append(resourcenum).append("%'");
        }
        if (energynum != null && !energynum.equals("")) {
            sql.append(" and u.energynum LIKE '%").append(energynum).append("%'");
        }
        if (manpowernum != null && !manpowernum.equals("")) {
            sql.append(" and u.manpowernum LIKE '%").append(manpowernum).append("%'");
        }
        if (scorename != null && !scorename.equals("")) {
            sql.append(" and u.scorename LIKE '%").append(scorename).append("%'");
        }
        if (userno != null && !userno.equals("")) {
            sql.append(" and u.userno LIKE '%").append(userno).append("%'");
        }

        return jdbcTemplateCsms.queryForList(sql.toString()).size();
    }


    @Override
    public List<Map<String, Object>> selectScoresum(String id) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Scoresum u where 1=1 ");

        sql.append(" and u.id = '").append(id).append("'");


        return jdbcTemplateCsms.queryForList(sql.toString());

    }


    @Override
    public List<Map<String, Object>> selectGetScoresumList(String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum, String scorename, String userno) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Scoresum u where 1=1 ");

        if (prono != null && !prono.equals("")) {
            sql.append(" and u.prono LIKE '%").append(prono).append("%'");
        }
        if (unitno != null && !unitno.equals("")) {
            sql.append(" and u.unitno LIKE '%").append(unitno).append("%'");
        }
        if (sectionno != null && !sectionno.equals("")) {
            sql.append(" and u.sectionno LIKE '%").append(sectionno).append("%'");
        }
        if (resourcevalue != null && !resourcevalue.equals("")) {
            sql.append(" and u.resourcevalue LIKE '%").append(resourcevalue).append("%'");
        }
        if (energyvalue != null && !energyvalue.equals("")) {
            sql.append(" and u.energyvalue LIKE '%").append(energyvalue).append("%'");
        }
        if (manpowervalue != null && !manpowervalue.equals("")) {
            sql.append(" and u.manpowervalue LIKE '%").append(manpowervalue).append("%'");
        }
        if (totalvalue != null && !totalvalue.equals("")) {
            sql.append(" and u.totalvalue LIKE '%").append(totalvalue).append("%'");
        }
        if (starlevel != null && !starlevel.equals("")) {
            sql.append(" and u.starlevel LIKE '%").append(starlevel).append("%'");
        }
        if (resourcenum != null && !resourcenum.equals("")) {
            sql.append(" and u.resourcenum LIKE '%").append(resourcenum).append("%'");
        }
        if (energynum != null && !energynum.equals("")) {
            sql.append(" and u.energynum LIKE '%").append(energynum).append("%'");
        }
        if (manpowernum != null && !manpowernum.equals("")) {
            sql.append(" and u.manpowernum LIKE '%").append(manpowernum).append("%'");
        }
        if (scorename != null && !scorename.equals("")) {
            sql.append(" and u.scorename LIKE '%").append(scorename).append("%'");
        }
        if (userno != null && !userno.equals("")) {
            sql.append(" and u.userno LIKE '%").append(userno).append("%'");
        }


        return jdbcTemplateCsms.queryForList(sql.toString());
    }

    @Override
    public Object Del(String prono, String unitno, String sectionno,String scorename) {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM Scoresum WHERE  1=1 ");

        if (prono != null && !prono.equals("")) {
            sql.append(" and prono = '").append(prono).append("'");
        }
        if (unitno != null && !unitno.equals("")) {
            sql.append(" and unitno ='").append(unitno).append("'");
        }
        if (sectionno != null && !sectionno.equals("")) {
            sql.append(" and sectionno = '").append(sectionno).append("'");
        }
        if (scorename != null && !scorename.equals("")) {
            sql.append(" and scorename = '").append(scorename).append("'");
        }

        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public int findBtName(String scorename) {
        StringBuffer sql = new StringBuffer();
        sql.append("select count(id) from Scoresum where scorename ='");
        sql.append(scorename).append("'");
        List<Integer> list = jdbcTemplateCsms.queryForList(sql.toString(), Integer.class);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return 0;
    }
}
