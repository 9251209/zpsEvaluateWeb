package cn.net.mine.project.dao.jdbc.impl;

import java.util.List;
import java.util.Map;

import cn.net.mine.project.dao.ProjectDao;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;


import cn.net.mine.common.SuperJdbcTemplate;

@Repository
public class ProjectDaoJdbcImpl extends SuperJdbcTemplate implements ProjectDao {


    @Override
    public Object projectAdd(String prono, String proname, String type, String userno, String totalInvestmentAmount,
                             String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany) {
        StringBuffer sql = new StringBuffer();
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String format = sdf.format(date);
        sql.append("INSERT INTO project( prono,  proname,  type,  userno,  totalInvestmentAmount,coveredArea,  purpose,  brief,  leader,  address,  consCompany,  buildCompany,  superCompany,  designCompany ,  prospectCompany  )");
        sql.append(" VALUES(");

        sql.append("'").append(prono).append("',");
        sql.append("'").append(type).append("',");
        sql.append("'").append(userno).append("',");
        sql.append("'").append(totalInvestmentAmount).append("',");
        sql.append("'").append(coveredArea).append("',");
        sql.append("'").append(purpose).append("',");
        sql.append("'").append(brief).append("',");
        sql.append("'").append(leader).append("',");
        sql.append("'").append(address).append("',");
        sql.append("'").append(consCompany).append("',");
        sql.append("'").append(buildCompany).append("',");
        sql.append("'").append(superCompany).append("',");
        sql.append("'").append(designCompany).append("',");
        sql.append("'").append(prospectCompany).append("',");
        sql.append("'").append(proname).append("'");


        sql.append(")");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object projectUpdate(String id, String prono, String proname, String type, String userno, String totalInvestmentAmount,
                                String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany) {
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        // String format = sdf.format(date);

        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE project SET ");
        sql.append(" prono = '").append(prono).append("',");
        sql.append(" type = '").append(type).append("',");
        sql.append(" userno = '").append(userno).append("',");
        sql.append(" totalInvestmentAmount = '").append(totalInvestmentAmount).append("',");
        sql.append(" coveredArea = '").append(coveredArea).append("',");
        sql.append(" purpose = '").append(purpose).append("',");
        sql.append(" brief = '").append(brief).append("',");
        sql.append(" leader = '").append(leader).append("',");
        sql.append(" address = '").append(address).append("',");
        sql.append(" consCompany = '").append(consCompany).append("',");
        sql.append(" buildCompany = '").append(buildCompany).append("',");
        sql.append(" superCompany = '").append(superCompany).append("',");
        sql.append(" designCompany = '").append(designCompany).append("',");
        sql.append(" prospectCompany = '").append(prospectCompany).append("',");
        sql.append(" proname = '").append(proname).append("'");

        sql.append(" WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object projectDel(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM project WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public int findBtName(String prono) {
        StringBuffer sql = new StringBuffer();
        sql.append("select count(id) from project where prono ='");
        sql.append(prono).append("'");
        List<Integer> list = jdbcTemplateCsms.queryForList(sql.toString(), Integer.class);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return 0;
    }

    @Override
    public int findBtName(String prono, String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("select count(id) from project where prono ='");
        sql.append(prono).append("' AND id !='").append(id).append("'");
        List<Integer> list = jdbcTemplateCsms.queryForList(sql.toString(), Integer.class);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return 0;
    }


    @Override
    public List<Map<String, Object>> selectProjectList(Integer pageNo, Integer pagesize, String prono, String proname, String type, String userno, String totalInvestmentAmount,
                                                       String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from project u where 1=1 ");
        if (prono != null && !prono.equals("")) {
            sql.append(" and u.prono LIKE '%").append(prono).append("%'");
        }
        if (type != null && !type.equals("")) {
            sql.append(" and u.type LIKE '%").append(type).append("%'");
        }
        if (userno != null && !userno.equals("")) {
            sql.append(" and u.userno LIKE '%").append(userno).append("%'");
        }
        if (totalInvestmentAmount != null && !totalInvestmentAmount.equals("")) {
            sql.append(" and u.totalInvestmentAmount LIKE '%").append(totalInvestmentAmount).append("%'");
        }
        if (coveredArea != null && !coveredArea.equals("")) {
            sql.append(" and u.coveredArea LIKE '%").append(coveredArea).append("%'");
        }
        if (purpose != null && !purpose.equals("")) {
            sql.append(" and u.purpose LIKE '%").append(purpose).append("%'");
        }
        if (brief != null && !brief.equals("")) {
            sql.append(" and u.brief LIKE '%").append(brief).append("%'");
        }
        if (leader != null && !leader.equals("")) {
            sql.append(" and u.leader LIKE '%").append(leader).append("%'");
        }
        if (address != null && !address.equals("")) {
            sql.append(" and u.address LIKE '%").append(address).append("%'");
        }
        if (consCompany != null && !consCompany.equals("")) {
            sql.append(" and u.consCompany LIKE '%").append(consCompany).append("%'");
        }
        if (buildCompany != null && !buildCompany.equals("")) {
            sql.append(" and u.buildCompany LIKE '%").append(buildCompany).append("%'");
        }
        if (superCompany != null && !superCompany.equals("")) {
            sql.append(" and u.superCompany LIKE '%").append(superCompany).append("%'");
        }
        if (designCompany != null && !designCompany.equals("")) {
            sql.append(" and u.designCompany LIKE '%").append(designCompany).append("%'");
        }
        if (prospectCompany != null && !prospectCompany.equals("")) {
            sql.append(" and u.prospectCompany LIKE '%").append(prospectCompany).append("%'");
        }
        if (proname != null && !proname.equals("")) {
            sql.append(" and u.proname LIKE '%").append(proname).append("%'");
        }

        sql.append(" limit " + (pageNo - 1) * pagesize + " , " + pagesize + " ");

        return jdbcTemplateCsms.queryForList(sql.toString());

    }

    @Override
    public Integer count(String prono, String proname, String type, String userno, String totalInvestmentAmount,
                         String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from project u where 1=1 ");
        if (prono != null && !prono.equals("")) {
            sql.append(" and u.prono LIKE '%").append(prono).append("%'");
        }
        if (type != null && !type.equals("")) {
            sql.append(" and u.type LIKE '%").append(type).append("%'");
        }
        if (userno != null && !userno.equals("")) {
            sql.append(" and u.userno LIKE '%").append(userno).append("%'");
        }
        if (totalInvestmentAmount != null && !totalInvestmentAmount.equals("")) {
            sql.append(" and u.totalInvestmentAmount LIKE '%").append(totalInvestmentAmount).append("%'");
        }
        if (coveredArea != null && !coveredArea.equals("")) {
            sql.append(" and u.coveredArea LIKE '%").append(coveredArea).append("%'");
        }
        if (purpose != null && !purpose.equals("")) {
            sql.append(" and u.purpose LIKE '%").append(purpose).append("%'");
        }
        if (brief != null && !brief.equals("")) {
            sql.append(" and u.brief LIKE '%").append(brief).append("%'");
        }
        if (leader != null && !leader.equals("")) {
            sql.append(" and u.leader LIKE '%").append(leader).append("%'");
        }
        if (address != null && !address.equals("")) {
            sql.append(" and u.address LIKE '%").append(address).append("%'");
        }
        if (consCompany != null && !consCompany.equals("")) {
            sql.append(" and u.consCompany LIKE '%").append(consCompany).append("%'");
        }
        if (buildCompany != null && !buildCompany.equals("")) {
            sql.append(" and u.buildCompany LIKE '%").append(buildCompany).append("%'");
        }
        if (superCompany != null && !superCompany.equals("")) {
            sql.append(" and u.superCompany LIKE '%").append(superCompany).append("%'");
        }
        if (designCompany != null && !designCompany.equals("")) {
            sql.append(" and u.designCompany LIKE '%").append(designCompany).append("%'");
        }
        if (prospectCompany != null && !prospectCompany.equals("")) {
            sql.append(" and u.prospectCompany LIKE '%").append(prospectCompany).append("%'");
        }
        if (proname != null && !proname.equals("")) {
            sql.append(" and u.proname LIKE '%").append(proname).append("%'");
        }

        return jdbcTemplateCsms.queryForList(sql.toString()).size();
    }


    @Override
    public List<Map<String, Object>> selectProject(String id) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from project u where 1=1 ");

        sql.append(" and u.id = '").append(id).append("'");


        return jdbcTemplateCsms.queryForList(sql.toString());

    }

}
