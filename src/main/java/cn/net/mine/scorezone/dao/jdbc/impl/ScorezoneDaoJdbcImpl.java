package cn.net.mine.scorezone.dao.jdbc.impl;

import java.util.List;
import java.util.Map;

import cn.net.mine.scorezone.dao.ScorezoneDao;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;


import cn.net.mine.common.SuperJdbcTemplate;

@Repository
public class ScorezoneDaoJdbcImpl extends SuperJdbcTemplate implements ScorezoneDao {

    @Override
    public Object scorezoneAdd(double onepartmax, double twopartmin, double twopartmax, double threepartmin, double threepartmax, double fourpartmin, double fourpartmax, double fivepartmin, double onevalue, double twovalue, double threevalue, double fourvalue, double fivevalue, String baseid) {
        StringBuffer sql = new StringBuffer();


        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String format = sdf.format(date);
        sql.append("INSERT INTO Scorezone( onepartmax, twopartmin, twopartmax, threepartmin, threepartmax, fourpartmin, fourpartmax, fivepartmin, onevalue, twovalue, threevalue, fourvalue, fivevalue, baseid)");
        sql.append(" VALUES(");
        sql.append("'").append(onepartmax).append("',");
        sql.append("'").append(twopartmin).append("',");
        sql.append("'").append(twopartmax).append("',");
        sql.append("'").append(threepartmin).append("',");
        sql.append("'").append(threepartmax).append("',");
        sql.append("'").append(fourpartmin).append("',");
        sql.append("'").append(fourpartmax).append("',");
        sql.append("'").append(fivepartmin).append("',");
        sql.append("'").append(onevalue).append("',");
        sql.append("'").append(twovalue).append("',");
        sql.append("'").append(threevalue).append("',");
        sql.append("'").append(fourvalue).append("',");
        sql.append("'").append(fivevalue).append("',");
        sql.append("'").append(baseid).append("'");


        sql.append(")");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object scorezoneUpdate(String id, double onepartmax, double twopartmin, double twopartmax, double threepartmin, double threepartmax, double fourpartmin, double fourpartmax, double fivepartmin, double onevalue, double twovalue, double threevalue, double fourvalue, double fivevalue, String baseid) {
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        // String format = sdf.format(date);

        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE Scorezone SET ");
        sql.append(" onepartmax = '").append(onepartmax).append("',");
        sql.append(" twopartmin = '").append(twopartmin).append("',");
        sql.append(" twopartmax = '").append(twopartmax).append("',");
        sql.append(" threepartmin = '").append(threepartmin).append("',");
        sql.append(" threepartmax = '").append(threepartmax).append("',");
        sql.append(" fourpartmin = '").append(fourpartmin).append("',");
        sql.append(" fourpartmax = '").append(fourpartmax).append("',");
        sql.append(" fivepartmin = '").append(fivepartmin).append("',");
        sql.append(" onevalue = '").append(onevalue).append("',");
        sql.append(" twovalue = '").append(twovalue).append("',");
        sql.append(" threevalue = '").append(threevalue).append("',");
        sql.append(" fourvalue = '").append(fourvalue).append("',");
        sql.append(" fivevalue = '").append(fivevalue).append("',");
        sql.append(" baseid = '").append(baseid).append("',");


        sql.append(" id = '").append(id).append("'");
        sql.append(" WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object scorezoneDel(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM Scorezone WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }


    @Override
    public List<Map<String, Object>> selectScorezone(String id) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Scorezone u where 1=1 ");

        sql.append(" and u.id = '").append(id).append("'");


        return jdbcTemplateCsms.queryForList(sql.toString());

    }


    @Override

    public List<Map<String, Object>> selectGetScorezoneList(String onepartmax, String twopartmin, String twopartmax, String threepartmin, String threepartmax, String fourpartmin, String fourpartmax, String fivepartmin, String onevalue, String twovalue, String threevalue, String fourvalue, String fivevalue, String baseid) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Scorezone u where 1=1 ");
        if (onepartmax != null && !onepartmax.equals("")) {
            sql.append(" and u.onepartmax LIKE '%").append(onepartmax).append("%'");
        }
        if (twopartmin != null && !twopartmin.equals("")) {
            sql.append(" and u.twopartmin LIKE '%").append(twopartmin).append("%'");
        }
        if (twopartmax != null && !twopartmax.equals("")) {
            sql.append(" and u.twopartmax LIKE '%").append(twopartmax).append("%'");
        }
        if (threepartmin != null && !threepartmin.equals("")) {
            sql.append(" and u.threepartmin LIKE '%").append(threepartmin).append("%'");
        }
        if (threepartmax != null && !threepartmax.equals("")) {
            sql.append(" and u.threepartmax LIKE '%").append(threepartmax).append("%'");
        }
        if (fourpartmin != null && !fourpartmin.equals("")) {
            sql.append(" and u.fourpartmin LIKE '%").append(fourpartmin).append("%'");
        }
        if (fourpartmax != null && !fourpartmax.equals("")) {
            sql.append(" and u.fourpartmax LIKE '%").append(fourpartmax).append("%'");
        }
        if (fivepartmin != null && !fivepartmin.equals("")) {
            sql.append(" and u.fivepartmin LIKE '%").append(fivepartmin).append("%'");
        }
        if (onevalue != null && !onevalue.equals("")) {
            sql.append(" and u.onevalue LIKE '%").append(onevalue).append("%'");
        }
        if (twovalue != null && !twovalue.equals("")) {
            sql.append(" and u.twovalue LIKE '%").append(twovalue).append("%'");
        }
        if (threevalue != null && !threevalue.equals("")) {
            sql.append(" and u.threevalue LIKE '%").append(threevalue).append("%'");
        }
        if (fourvalue != null && !fourvalue.equals("")) {
            sql.append(" and u.fourvalue LIKE '%").append(fourvalue).append("%'");
        }
        if (fivevalue != null && !fivevalue.equals("")) {
            sql.append(" and u.fivevalue LIKE '%").append(fivevalue).append("%'");
        }
        if (baseid != null && !baseid.equals("")) {
            sql.append(" and u.baseid = '").append(baseid).append("'");
        }

        return jdbcTemplateCsms.queryForList(sql.toString());
    }
}
