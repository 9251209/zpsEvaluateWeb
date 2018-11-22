package cn.net.mine.scorebase.dao.jdbc.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cn.net.mine.scorebase.dao.ScorebaseDao;
import org.springframework.stereotype.Repository;


import cn.net.mine.common.SuperJdbcTemplate;

@Repository
public class ScorebaseDaoJdbcImpl extends SuperJdbcTemplate implements ScorebaseDao {


    @Override
    public Object scorebaseAdd(String type, String tablename, String formulaid, String weight,String weightnew, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula) {
        StringBuffer sql = new StringBuffer();

        UUID uuid= UUID.randomUUID();
        String str = uuid.toString();

        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String format = sdf.format(date);
        sql.append("INSERT INTO Scorebase(id, type, tablename, formulaid, weight, weightnew, parama, paramb, paramc, paramd, paramy, paramformula, ua, ub, uc, ud, uy, uformula, explaina, explainb, explainc, explaind, explainy, explainformula )");
        sql.append(" VALUES(");
        sql.append("'").append(str).append("',");
        sql.append("'").append(type).append("',");
        sql.append("'").append(tablename).append("',");
        sql.append("'").append(formulaid).append("',");
        sql.append("'").append(weight).append("',");

        sql.append("'").append(weightnew).append("',");
        sql.append("'").append(parama).append("',");
        sql.append("'").append(paramb).append("',");
        sql.append("'").append(paramc).append("',");
        sql.append("'").append(paramd).append("',");
        sql.append("'").append(paramy).append("',");
        sql.append("'").append(paramformula).append("',");
        sql.append("'").append(ua).append("',");
        sql.append("'").append(ub).append("',");
        sql.append("'").append(uc).append("',");
        sql.append("'").append(ud).append("',");
        sql.append("'").append(uy).append("',");
        sql.append("'").append(uformula).append("',");
        sql.append("'").append(explaina).append("',");
        sql.append("'").append(explainb).append("',");
        sql.append("'").append(explainc).append("',");
        sql.append("'").append(explaind).append("',");
        sql.append("'").append(explainy).append("',");
        sql.append("'").append(explainformula).append("'");

        sql.append(")");
        Integer a= jdbcTemplateCsms.update(sql.toString());
        if(a>0){
            Map<String,Object> map=new HashMap<>();
            map.put("data",str );
            return map;//获得刚刚插入的id
        }
        return "";

    }

    @Override
    public Object scorebaseUpdate(String id, String type, String tablename, String formulaid, String weight,String weightnew, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula) {
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        // String format = sdf.format(date);

        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE Scorebase SET ");

        if (type != null && !type.equals(""))
            sql.append("type = '").append(type).append("',");
        if (tablename != null && !tablename.equals(""))
            sql.append(" tablename = '").append(tablename).append("',");
        if (formulaid != null && !formulaid.equals(""))
            sql.append(" formulaid = '").append(formulaid).append("',");
        if (weight != null && !weight.equals(""))
            sql.append(" weight = '").append(weight).append("',");

        if (weightnew != null && !weightnew.equals(""))
            sql.append(" weightnew = '").append(weightnew).append("',");
        if (parama != null && !parama.equals(""))
            sql.append(" parama = '").append(parama).append("',");
        if (paramb != null && !paramb.equals(""))
            sql.append(" paramb = '").append(paramb).append("',");
        if (paramc != null && !paramc.equals(""))
            sql.append("         paramc = '").append(paramc).append("',");
        if (paramd != null && !paramd.equals(""))
            sql.append(" paramd = '").append(paramd).append("',");
        if (paramy != null && !paramy.equals(""))
            sql.append(" paramy = '").append(paramy).append("',");
        if (paramformula != null && !paramformula.equals(""))
            sql.append(" paramformula = '").append(paramformula).append("',");
        if (ua != null && !ua.equals(""))
            sql.append(" ua = '").append(ua).append("',");
        if (ub != null && !ub.equals(""))
            sql.append(" ub = '").append(ub).append("',");
        if (uc != null && !uc.equals(""))
            sql.append(" uc = '").append(uc).append("',");
        if (ud != null && !ud.equals(""))
            sql.append(" ud = '").append(ud).append("',");
        if (uy != null && !uy.equals(""))
            sql.append(" uy = '").append(uy).append("',");
        if (uformula != null && !uformula.equals(""))
            sql.append(" uformula = '").append(uformula).append("',");
        if (explaina != null && !explaina.equals(""))
            sql.append(" explaina = '").append(explaina).append("',");
        if (explainb != null && !explainb.equals(""))
            sql.append(" explainb = '").append(explainb).append("',");
        if (explainc != null && !explainc.equals(""))
            sql.append(" explainc = '").append(explainc).append("',");
        if (explaind != null && !explaind.equals(""))
            sql.append(" explaind = '").append(explaind).append("',");
        if (explainy != null && !explainy.equals(""))
            sql.append(" explainy = '").append(explainy).append("',");
        if (explainformula != null && !explainformula.equals(""))
            sql.append(" explainformula = '").append(explainformula).append("',");


        sql.append(" id = '").append(id).append("'");
        sql.append(" WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }

    @Override
    public Object scorebaseDel(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM Scorebase WHERE ID = '").append(id).append("'");
        return jdbcTemplateCsms.update(sql.toString());
    }


    @Override
    public List<Map<String, Object>> selectScorebaseList(Integer pageNo, Integer pagesize, String type, String tablename, String formulaid, String weight, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Scorebase u where 1=1 ");
        if (type != null && !type.equals("")) {
            sql.append(" and u.type LIKE '%").append(type).append("%'");
        }
        if (tablename != null && !tablename.equals("")) {
            sql.append(" and u.tablename LIKE '%").append(tablename).append("%'");
        }
        if (formulaid != null && !formulaid.equals("")) {
            sql.append(" and u.formulaid LIKE '%").append(formulaid).append("%'");
        }
        if (weight != null && !weight.equals("")) {
            sql.append(" and u.weight LIKE '%").append(weight).append("%'");
        }
        if (parama != null && !parama.equals("")) {
            sql.append(" and u.parama LIKE '%").append(parama).append("%'");
        }
        if (paramb != null && !paramb.equals("")) {
            sql.append(" and u.paramb LIKE '%").append(paramb).append("%'");
        }
        if (paramc != null && !paramc.equals("")) {
            sql.append(" and u.paramc LIKE '%").append(paramc).append("%'");
        }
        if (paramd != null && !paramd.equals("")) {
            sql.append(" and u.paramd LIKE '%").append(paramd).append("%'");
        }
        if (paramy != null && !paramy.equals("")) {
            sql.append(" and u.paramy LIKE '%").append(paramy).append("%'");
        }
        if (paramformula != null && !paramformula.equals("")) {
            sql.append(" and u.paramformula LIKE '%").append(paramformula).append("%'");
        }
        if (ua != null && !ua.equals("")) {
            sql.append(" and u.ua LIKE '%").append(ua).append("%'");
        }
        if (ub != null && !ub.equals("")) {
            sql.append(" and u.ub LIKE '%").append(ub).append("%'");
        }
        if (uc != null && !uc.equals("")) {
            sql.append(" and u.uc LIKE '%").append(uc).append("%'");
        }
        if (ud != null && !ud.equals("")) {
            sql.append(" and u.ud LIKE '%").append(ud).append("%'");
        }
        if (uy != null && !uy.equals("")) {
            sql.append(" and u.uy LIKE '%").append(uy).append("%'");
        }
        if (uformula != null && !uformula.equals("")) {
            sql.append(" and u.uformula LIKE '%").append(uformula).append("%'");
        }
        if (explaina != null && !explaina.equals("")) {
            sql.append(" and u.explaina LIKE '%").append(explaina).append("%'");
        }
        if (explainb != null && !explainb.equals("")) {
            sql.append(" and u.explainb LIKE '%").append(explainb).append("%'");
        }
        if (explainc != null && !explainc.equals("")) {
            sql.append(" and u.explainc LIKE '%").append(explainc).append("%'");
        }
        if (explaind != null && !explaind.equals("")) {
            sql.append(" and u.explaind LIKE '%").append(explaind).append("%'");
        }
        if (explainy != null && !explainy.equals("")) {
            sql.append(" and u.explainy LIKE '%").append(explainy).append("%'");
        }
        if (explainformula != null && !explainformula.equals("")) {
            sql.append(" and u.explainformula LIKE '%").append(explainformula).append("%'");
        }


        sql.append(" limit " + (pageNo - 1) * pagesize + " , " + pagesize + " ");

        return jdbcTemplateCsms.queryForList(sql.toString());

    }

    @Override
    public Integer count(String type, String tablename, String formulaid, String weight, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Scorebase u where 1=1 ");
        if (type != null && !type.equals("")) {
            sql.append(" and u.type LIKE '%").append(type).append("%'");
        }
        if (tablename != null && !tablename.equals("")) {
            sql.append(" and u.tablename LIKE '%").append(tablename).append("%'");
        }
        if (formulaid != null && !formulaid.equals("")) {
            sql.append(" and u.formulaid LIKE '%").append(formulaid).append("%'");
        }
        if (weight != null && !weight.equals("")) {
            sql.append(" and u.weight LIKE '%").append(weight).append("%'");
        }
        if (parama != null && !parama.equals("")) {
            sql.append(" and u.parama LIKE '%").append(parama).append("%'");
        }
        if (paramb != null && !paramb.equals("")) {
            sql.append(" and u.paramb LIKE '%").append(paramb).append("%'");
        }
        if (paramc != null && !paramc.equals("")) {
            sql.append(" and u.paramc LIKE '%").append(paramc).append("%'");
        }
        if (paramd != null && !paramd.equals("")) {
            sql.append(" and u.paramd LIKE '%").append(paramd).append("%'");
        }
        if (paramy != null && !paramy.equals("")) {
            sql.append(" and u.paramy LIKE '%").append(paramy).append("%'");
        }
        if (paramformula != null && !paramformula.equals("")) {
            sql.append(" and u.paramformula LIKE '%").append(paramformula).append("%'");
        }
        if (ua != null && !ua.equals("")) {
            sql.append(" and u.ua LIKE '%").append(ua).append("%'");
        }
        if (ub != null && !ub.equals("")) {
            sql.append(" and u.ub LIKE '%").append(ub).append("%'");
        }
        if (uc != null && !uc.equals("")) {
            sql.append(" and u.uc LIKE '%").append(uc).append("%'");
        }
        if (ud != null && !ud.equals("")) {
            sql.append(" and u.ud LIKE '%").append(ud).append("%'");
        }
        if (uy != null && !uy.equals("")) {
            sql.append(" and u.uy LIKE '%").append(uy).append("%'");
        }
        if (uformula != null && !uformula.equals("")) {
            sql.append(" and u.uformula LIKE '%").append(uformula).append("%'");
        }
        if (explaina != null && !explaina.equals("")) {
            sql.append(" and u.explaina LIKE '%").append(explaina).append("%'");
        }
        if (explainb != null && !explainb.equals("")) {
            sql.append(" and u.explainb LIKE '%").append(explainb).append("%'");
        }
        if (explainc != null && !explainc.equals("")) {
            sql.append(" and u.explainc LIKE '%").append(explainc).append("%'");
        }
        if (explaind != null && !explaind.equals("")) {
            sql.append(" and u.explaind LIKE '%").append(explaind).append("%'");
        }
        if (explainy != null && !explainy.equals("")) {
            sql.append(" and u.explainy LIKE '%").append(explainy).append("%'");
        }
        if (explainformula != null && !explainformula.equals("")) {
            sql.append(" and u.explainformula LIKE '%").append(explainformula).append("%'");
        }

        return jdbcTemplateCsms.queryForList(sql.toString()).size();
    }


    @Override
    public List<Map<String, Object>> selectScorebase(String id) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Scorebase u where 1=1 ");

        sql.append(" and u.id = '").append(id).append("'");


        return jdbcTemplateCsms.queryForList(sql.toString());

    }

    @Override
    public List<Map<String, Object>> selectGetScorebaseList(String type, String tablename, String formulaid, String weight, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from Scorebase u where 1=1 ");
        if (type != null && !type.equals("")) {
            sql.append(" and u.type LIKE '%").append(type).append("%'");
        }
        if (tablename != null && !tablename.equals("")) {
            sql.append(" and u.tablename LIKE '%").append(tablename).append("%'");
        }
        if (formulaid != null && !formulaid.equals("")) {
            sql.append(" and u.formulaid LIKE '%").append(formulaid).append("%'");
        }
        if (weight != null && !weight.equals("")) {
            sql.append(" and u.weight LIKE '%").append(weight).append("%'");
        }
        if (parama != null && !parama.equals("")) {
            sql.append(" and u.parama LIKE '%").append(parama).append("%'");
        }
        if (paramb != null && !paramb.equals("")) {
            sql.append(" and u.paramb LIKE '%").append(paramb).append("%'");
        }
        if (paramc != null && !paramc.equals("")) {
            sql.append(" and u.paramc LIKE '%").append(paramc).append("%'");
        }
        if (paramd != null && !paramd.equals("")) {
            sql.append(" and u.paramd LIKE '%").append(paramd).append("%'");
        }
        if (paramy != null && !paramy.equals("")) {
            sql.append(" and u.paramy LIKE '%").append(paramy).append("%'");
        }
        if (paramformula != null && !paramformula.equals("")) {
            sql.append(" and u.paramformula LIKE '%").append(paramformula).append("%'");
        }
        if (ua != null && !ua.equals("")) {
            sql.append(" and u.ua LIKE '%").append(ua).append("%'");
        }
        if (ub != null && !ub.equals("")) {
            sql.append(" and u.ub LIKE '%").append(ub).append("%'");
        }
        if (uc != null && !uc.equals("")) {
            sql.append(" and u.uc LIKE '%").append(uc).append("%'");
        }
        if (ud != null && !ud.equals("")) {
            sql.append(" and u.ud LIKE '%").append(ud).append("%'");
        }
        if (uy != null && !uy.equals("")) {
            sql.append(" and u.uy LIKE '%").append(uy).append("%'");
        }
        if (uformula != null && !uformula.equals("")) {
            sql.append(" and u.uformula LIKE '%").append(uformula).append("%'");
        }
        if (explaina != null && !explaina.equals("")) {
            sql.append(" and u.explaina LIKE '%").append(explaina).append("%'");
        }
        if (explainb != null && !explainb.equals("")) {
            sql.append(" and u.explainb LIKE '%").append(explainb).append("%'");
        }
        if (explainc != null && !explainc.equals("")) {
            sql.append(" and u.explainc LIKE '%").append(explainc).append("%'");
        }
        if (explaind != null && !explaind.equals("")) {
            sql.append(" and u.explaind LIKE '%").append(explaind).append("%'");
        }
        if (explainy != null && !explainy.equals("")) {
            sql.append(" and u.explainy LIKE '%").append(explainy).append("%'");
        }
        if (explainformula != null && !explainformula.equals("")) {
            sql.append(" and u.explainformula LIKE '%").append(explainformula).append("%'");
        }


        return jdbcTemplateCsms.queryForList(sql.toString());
    }
}
