package cn.net.mine.user.dao.jdbc.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import cn.net.mine.user.dao.UserDao;
import cn.net.mine.common.SuperJdbcTemplate;

@Repository
public class UserDaoJdbcImpl extends SuperJdbcTemplate implements UserDao {

    @Override
    public Object userAdd(String userno, String password, String telphone, String status, Integer flag, String realname,
                          String sex, Integer age, String education, String position) {
        StringBuffer sql = new StringBuffer();
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String format = sdf.format(date);
        sql.append("INSERT INTO USER(userno ,password ,telphone ,status ,flag ,realname ,sex ,age ,education ,position)");
        sql.append(" VALUES(");
        sql.append("'").append(userno).append("',");
        sql.append("'").append(password).append("',");
        sql.append("'").append(telphone).append("',");
        sql.append("'").append(status).append("',");
        sql.append("'").append(flag).append("',");

        sql.append("'").append(realname).append("',");
        sql.append("'").append(sex).append("',");
        if (age != null && !age.equals("")) {
            sql.append("'").append(age).append("',");
        } else {
            sql.append("'").append("0").append("',");
        }

        sql.append("'").append(education).append("',");
        sql.append("'").append(position).append("'");
        sql.append(")");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object userUpdate(String id, String userno, String password, String telphone, String status, Integer flag,
                             String realname, String sex, Integer age, String education, String position) {
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        // String format = sdf.format(date);

        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE USER SET ");
        if (userno != null && !userno.equals(""))
            sql.append(" userno = '").append(userno).append("',");
        if (password != null && !password.equals(""))
            sql.append(" password = '").append(password).append("',");
        if (telphone != null && !telphone.equals(""))
            sql.append(" telphone = '").append(telphone).append("',");
        if (status != null && !status.equals(""))
            sql.append(" status = '").append(status).append("',");
        if (flag != null && !flag.equals(""))
            sql.append(" flag = '").append(flag).append("',");
        if (realname != null && !realname.equals(""))
            sql.append(" realname = '").append(realname).append("',");
        if (sex != null && !sex.equals(""))
            sql.append(" sex = '").append(sex).append("',");
        if (age != null && !age.equals(""))
            sql.append(" age = '").append(age).append("',");
        if (education != null && !education.equals(""))
            sql.append(" education = '").append(education).append("',");
        if (position != null && !position.equals(""))
            sql.append(" position = '").append(position).append("',");

        sql.append(" id = '").append(id).append("'");

        sql.append(" WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object userDel(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM USER WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public int findBtName(String userno) {
        StringBuffer sql = new StringBuffer();
        sql.append("select count(id) from USER where userno ='");
        sql.append(userno).append("'");
        List<Integer> list = jdbcTemplateCsms.queryForList(sql.toString(), Integer.class);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return 0;
    }

    @Override
    public int findBtName(String userno, String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("select count(id) from User where userno ='");
        sql.append(userno).append("' AND id !='").append(id).append("'");
        List<Integer> list = jdbcTemplateCsms.queryForList(sql.toString(), Integer.class);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return 0;
    }

    @Override
    public Map<String, Object> login(String userno, String pawwsord) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from User u ");
        sql.append(" WHERE u.userno = '").append(userno).append("'");
        sql.append(" AND u.password = '").append(pawwsord).append("'");
        List<Map<String, Object>> list = jdbcTemplateCsms.queryForList(sql.toString());
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Map<String, Object>> selectUserList(Integer pageNo, Integer pagesize, String userno, String status) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from User u where 1=1 ");
        if (userno != null && !userno.equals("")) {
            sql.append(" and u.userno LIKE '%").append(userno).append("%'");
        }
        if (status != null && !status.equals("")) {
            sql.append(" AND u.status LIKE '%").append(status).append("%'");
        }

        sql.append(" limit " + (pageNo - 1) * pagesize + " , " + pagesize + " ");

        return jdbcTemplateCsms.queryForList(sql.toString());

    }

    @Override
    public Integer count(String userno, String status) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from User u where 1=1 ");
        if (userno != null && !userno.equals("")) {
            sql.append(" and u.userno LIKE '%").append(userno).append("%'");
        }
        if (status != null && !status.equals("")) {
            sql.append(" AND u.status LIKE '%'").append(status).append("%'");
        }

        return jdbcTemplateCsms.queryForList(sql.toString()).size();
    }


    @Override
    public List<Map<String, Object>> selectUser(String id) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from User u where 1=1 ");

        sql.append(" and u.id = '").append(id).append("'");


        return jdbcTemplateCsms.queryForList(sql.toString());

    }


    @Override
    public Object statusUpdate(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE USER SET ");

        sql.append(" status = '").append("1").append("',");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mmm:ss");
        sql.append(" statusdate = '").append(sdf.format(new Date())).append("'");

        sql.append(" WHERE ID = '").append(id).append("'");

        return jdbcTemplateCsms.update(sql.toString());
    }
}
