package cn.net.mine.scorezone.controller;


import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import cn.net.mine.scorezone.service.ScorezoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.net.mine.common.util.ReturnObject;

/**
 * @program:
 * @description:
 * @author: √   99
 * @create:
 **/

@Controller
@RequestMapping(value = "/scorezone")
public class ScorezoneController {

    @Autowired
    private ScorezoneService scorezoneService;

    /**
     * 添加
     * @param response
     * @param onepartmax
     * @param twopartmin
     * @param twopartmax
     * @param threepartmin
     * @param threepartmax
     * @param fourpartmin
     * @param fourpartmax
     * @param fivepartmin
     * @param onevalue
     * @param twovalue
     * @param threevalue
     * @param fourvalue
     * @param fivevalue
     * @param baseid
     * @return
     */
    @RequestMapping(value = "/scorezoneAdd")
    @ResponseBody
    public ReturnObject scorezoneAdd(HttpServletResponse response, double onepartmax, double twopartmin, double twopartmax, double threepartmin, double threepartmax, double fourpartmin, double fourpartmax, double fivepartmin, double onevalue, double twovalue, double threevalue, double fourvalue, double fivevalue, String baseid) {
        ReturnObject ro = new ReturnObject();
        try {
            ro.setCode("1");
            ro.setMsg("添加成功！");
            ro.setData(this.scorezoneService.scorezoneAdd(onepartmax, twopartmin, twopartmax, threepartmin, threepartmax, fourpartmin, fourpartmax, fivepartmin, onevalue, twovalue, threevalue, fourvalue, fivevalue, baseid ));
            return ro;
        } catch (Exception e) {
            e.printStackTrace();
            ro.setCode("0");
            ro.setMsg("系统繁忙请稍后再试！！！");
            ro.setData(null);
            return ro;
        }
    }

    /**
     * 修改
     * @param response
     * @param id
     * @param onepartmax
     * @param twopartmin
     * @param twopartmax
     * @param threepartmin
     * @param threepartmax
     * @param fourpartmin
     * @param fourpartmax
     * @param fivepartmin
     * @param onevalue
     * @param twovalue
     * @param threevalue
     * @param fourvalue
     * @param fivevalue
     * @param baseid
     * @return
     */
    @RequestMapping(value = "/scorezoneUpdate")
    @ResponseBody
    public ReturnObject scorezoneUpdate(HttpServletResponse response, String id, double onepartmax, double twopartmin, double twopartmax, double threepartmin, double threepartmax, double fourpartmin, double fourpartmax, double fivepartmin, double onevalue, double twovalue, double threevalue, double fourvalue, double fivevalue, String baseid) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("编辑成功！");
            ro.setData(this.scorezoneService.scorezoneUpdate(id,onepartmax, twopartmin, twopartmax, threepartmin, threepartmax, fourpartmin, fourpartmax, fivepartmin, onevalue, twovalue, threevalue, fourvalue, fivevalue, baseid ));
            return ro;
        } catch (Exception e) {
            e.printStackTrace();
            ro.setCode("0");
            ro.setMsg("系统繁忙请稍后再试！！！");
            ro.setData(null);
            return ro;
        }
    }

    /**
     * 删除
     * @param response
     * @param id
     * @return
     */
    @RequestMapping(value = "/scorezoneDel")
    @ResponseBody
    public ReturnObject scorezoneDel(HttpServletResponse response, @RequestParam(value = "id") String id) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("删除成功！");
            ro.setData(this.scorezoneService.scorezoneDel(id));
            return ro;
        } catch (Exception e) {
            e.printStackTrace();
            ro.setCode("0");
            ro.setMsg("系统繁忙请稍后再试！！！");
            ro.setData(null);
            return ro;
        }
    }





    /**
     * 查询单条
     *
     * @param response
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectScorezone")
    @ResponseBody
    public ReturnObject selectScorezone(HttpServletResponse response,
                                      @RequestParam(value = "id") String id) {

        ReturnObject ro = new ReturnObject();

        Map<String, Object> map = scorezoneService.selectScorezone(id).get(0);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(map);
        return ro;
    }



}