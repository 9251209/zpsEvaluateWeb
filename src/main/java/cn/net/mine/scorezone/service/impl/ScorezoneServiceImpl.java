package cn.net.mine.scorezone.service.impl;

import java.util.List;
import java.util.Map;


import cn.net.mine.scorezone.dao.ScorezoneDao;
import cn.net.mine.scorezone.service.ScorezoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ScorezoneServiceImpl implements ScorezoneService {

    @Autowired
    private ScorezoneDao scorezoneDao;

    @Override
    public Object scorezoneAdd(double onepartmax, double twopartmin, double twopartmax, double threepartmin, double threepartmax, double fourpartmin, double fourpartmax, double fivepartmin, double onevalue, double twovalue, double threevalue, double fourvalue, double fivevalue, String baseid) {
        return this.scorezoneDao.scorezoneAdd(onepartmax, twopartmin, twopartmax, threepartmin, threepartmax, fourpartmin, fourpartmax, fivepartmin, onevalue, twovalue, threevalue, fourvalue, fivevalue, baseid );
    }

    @Override
    public Object scorezoneUpdate(String id, double onepartmax, double twopartmin, double twopartmax, double threepartmin, double threepartmax, double fourpartmin, double fourpartmax, double fivepartmin, double onevalue, double twovalue, double threevalue, double fourvalue, double fivevalue, String baseid) {
        return this.scorezoneDao.scorezoneUpdate(id,onepartmax, twopartmin, twopartmax, threepartmin, threepartmax, fourpartmin, fourpartmax, fivepartmin, onevalue, twovalue, threevalue, fourvalue, fivevalue, baseid );
    }

    @Override
    public Object scorezoneDel(String id) {
        return this.scorezoneDao.scorezoneDel(id);
    }

    @Override
    public List<Map<String, Object>> selectScorezone(String id) {
        return this.scorezoneDao.selectScorezone(id);
    }

    @Override
    public List<Map<String, Object>> selectGetScorezoneList(String onepartmax, String twopartmin, String twopartmax, String threepartmin, String threepartmax, String fourpartmin, String fourpartmax, String fivepartmin, String onevalue, String twovalue, String threevalue, String fourvalue, String fivevalue, String baseid) {
        return this.scorezoneDao.selectGetScorezoneList(onepartmax,twopartmin,twopartmax,threepartmin,threepartmax,fourpartmin,fourpartmax,fivepartmin,onevalue,twovalue,threevalue,fourvalue,fivevalue,baseid);
    }
}
