package cn.net.mine.newinfo.dao.jdbc.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cn.net.mine.newinfo.dao.NewinfoDao;
import org.springframework.stereotype.Repository;


import cn.net.mine.common.SuperJdbcTemplate;

@Repository
public class NewinfoDaoJdbcImpl extends SuperJdbcTemplate implements NewinfoDao {


    @Override
    public Object newinfoAdd(String infoTitle, String infoType, String infoContent, String[] infoImg) {
        StringBuffer sql = new StringBuffer();

        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String format = sdf.format(date);
        sql.append("INSERT INTO Newinfo( infoTitle,  infoType,  infoContent,  infoImg)");
        sql.append(" VALUES(");
        sql.append("'").append(infoTitle).append("',");
        sql.append("'").append(infoType).append("',");
        sql.append("'").append(infoContent).append("',");
        sql.append("'").append(Arrays.toString(infoImg)).append("'");


        sql.append(")");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object newinfoUpdate(String id, String infoTitle, String infoType, String infoContent, String[] infoImg, String type) {
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        // String format = sdf.format(date);

        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE Newinfo SET ");
        if (infoTitle != null && !infoTitle.equals(""))
            sql.append(" infoTitle = '").append(infoTitle).append("',");
        if (infoType != null && !infoType.equals(""))
            sql.append(" infoType = '").append(infoType).append("',");
        if (infoContent != null && !infoContent.equals(""))
            sql.append(" infoContent = '").append(infoContent).append("',");
        if (infoImg != null && !infoImg.equals(""))
            sql.append(" infoImg = '").append(Arrays.toString(infoImg)).append("',");
        if (type != null && !type.equals(""))
            sql.append(" type = '").append(type).append("',");


        sql.append(" id = '").append(id).append("'");
        sql.append(" WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object newinfoDel(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM Newinfo WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }


    @Override
    public List<Map<String, Object>> selectNewinfoList(Integer pageNo, Integer pagesize, String infoTitle, String infoType, String infoContent, String type) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Newinfo u where 1=1 ");
        if (infoTitle != null && !infoTitle.equals("")) {
            sql.append(" and u.infoTitle LIKE '%").append(infoTitle).append("%'");
        }
        if (infoType != null && !infoType.equals("")) {
            sql.append(" and u.infoType LIKE '%").append(infoType).append("%'");
        }
        if (infoContent != null && !infoContent.equals("")) {
            sql.append(" and u.infoContent LIKE '%").append(infoContent).append("%'");
        }
        if (type != null && !type.equals("")) {
            sql.append(" and u.type LIKE '%").append(type).append("%'");
        }


        sql.append(" limit " + (pageNo - 1) * pagesize + " , " + pagesize + " ");

        return jdbcTemplateCsms.queryForList(sql.toString());

    }

    @Override
    public Integer count(String infoTitle, String infoType, String infoContent, String type) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Newinfo u where 1=1 ");
        if (infoTitle != null && !infoTitle.equals("")) {
            sql.append(" and u.infoTitle LIKE '%").append(infoTitle).append("%'");
        }
        if (infoType != null && !infoType.equals("")) {
            sql.append(" and u.infoType LIKE '%").append(infoType).append("%'");
        }
        if (infoContent != null && !infoContent.equals("")) {
            sql.append(" and u.infoContent LIKE '%").append(infoContent).append("%'");
        }
        if (type != null && !type.equals("")) {
            sql.append(" and u. type LIKE '%").append(type).append("%'");
        }


        return jdbcTemplateCsms.queryForList(sql.toString()).size();
    }


    @Override
    public List<Map<String, Object>> selectNewinfo(String id) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Newinfo u where 1=1 ");

        sql.append(" and u.id = '").append(id).append("'");


        return jdbcTemplateCsms.queryForList(sql.toString());

    }


    @Override
    public List<Map<String, Object>> selectGetNewinfoList(String infoTitle, String infoType, String infoContent) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Newinfo u where 1=1 ");
        if (infoTitle != null && !infoTitle.equals("")) {
            sql.append(" and u.infoTitle LIKE '%").append(infoTitle).append("%'");
        }
        if (infoType != null && !infoType.equals("")) {
            sql.append(" and u.infoType LIKE '%").append(infoType).append("%'");
        }
        if (infoContent != null && !infoContent.equals("")) {
            sql.append(" and u.infoContent LIKE '%").append(infoContent).append("%'");
        }


        return jdbcTemplateCsms.queryForList(sql.toString());
    }

}
