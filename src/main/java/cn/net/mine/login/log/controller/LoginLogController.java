package cn.net.mine.login.log.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cn.net.mine.common.util.ReturnObject;
import cn.net.mine.login.log.service.LoginLogService;
/**
 * @author JinYue
 * @ClassName: LoginLogController
 * @Description: 登录日志Controller
 */
@RestController
@RequestMapping(value="/loginLogController")
public class LoginLogController {
	@Autowired
	LoginLogService loginLogService;
	@RequestMapping(value="/loginLogList",method=RequestMethod.POST)
	public ReturnObject list(@RequestParam("pageSize")String pageSize,@RequestParam("pageNum")String pageNum) {
		ReturnObject ro = new ReturnObject();
		try {
				Map<String, Object> loginLog = loginLogService.list( pageSize, pageNum);
	            ro.setCode("1");
                ro.setMsg("接口正常");
                ro.setData(loginLog);
                return ro;
			} catch (Exception e) {
				e.printStackTrace();
				ro.setCode("0");
	            ro.setMsg("接口异常！");
	            ro.setData("");
	            return ro;
			}

	}
	@RequestMapping(value="/loginLogCount",method=RequestMethod.POST)
	public ReturnObject count(@RequestParam("pageSize")String pageSize) {
		ReturnObject ro = new ReturnObject();
		try {
				Map<String, Object> loginLog = loginLogService.count(pageSize);
	            ro.setCode("1");
                ro.setMsg("接口正常");
                ro.setData(loginLog);
                return ro;
			} catch (Exception e) {
				e.printStackTrace();
				ro.setCode("0");
	            ro.setMsg("接口异常！");
	            ro.setData("");
	            return ro;
			}
	}
	@RequestMapping(value="/loginLogAdd",method=RequestMethod.POST)
	public ReturnObject add(@RequestParam("userId")String userId,@RequestParam("date")String date,@RequestParam("shift")String shift) {
		ReturnObject ro = new ReturnObject();
		try {
				Map<String, Object> loginLog = loginLogService.add(userId, date, shift);
	            ro.setCode("1");
                ro.setMsg("接口正常");
                ro.setData(loginLog);
                return ro;
			} catch (Exception e) {
				e.printStackTrace();
				ro.setCode("0");
	            ro.setMsg("接口异常！");
	            ro.setData("");
	            return ro;
			}
	}
	@RequestMapping(value="/loginLogUpdate",method=RequestMethod.POST)
	public ReturnObject update(@RequestParam("id")String id,@RequestParam("userId")String userId,@RequestParam("date")String date,@RequestParam("shift")String shift) {
		ReturnObject ro = new ReturnObject();
		try {
				Map<String, Object> loginLog = loginLogService.update( id,userId,date,shift);
	            ro.setCode("1");
                ro.setMsg("接口正常");
                ro.setData(loginLog);
                return ro;
			} catch (Exception e) {
				e.printStackTrace();
				ro.setCode("0");
	            ro.setMsg("接口异常！");
	            ro.setData("");
	            return ro;
			}
	}
	@RequestMapping(value="/loginLogDelete",method=RequestMethod.POST)
	public ReturnObject delete(@RequestParam("ids")String... id) {
		ReturnObject ro = new ReturnObject();
		try {
				Map<String, Object> loginLog = loginLogService.delete(id);
	            ro.setCode("1");
                ro.setMsg("接口正常");
                ro.setData(loginLog);
                return ro;
			} catch (Exception e) {
				e.printStackTrace();
				ro.setCode("0");
	            ro.setMsg("接口异常！");
	            ro.setData("");
	            return ro;
			}
	}
	@RequestMapping(value="/loginLogDeleteAll",method=RequestMethod.POST)
	public ReturnObject deleteAll() {
		ReturnObject ro = new ReturnObject();
		try {
				Map<String, Object> loginLog = loginLogService.deleteAll();
	            ro.setCode("1");
                ro.setMsg("接口正常");
                ro.setData(loginLog);
                return ro;
			} catch (Exception e) {
				e.printStackTrace();
				ro.setCode("0");
	            ro.setMsg("接口异常！");
	            ro.setData("");
	            return ro;
			}
	}
	@RequestMapping(value="/loginLogDetail",method=RequestMethod.POST)
	public ReturnObject detail(@RequestParam("id")String id) {
		ReturnObject ro = new ReturnObject();
		try {
				Map<String, Object> loginLog = loginLogService.detail(id);
	            ro.setCode("1");
                ro.setMsg("接口正常");
                ro.setData(loginLog);
                return ro;
			} catch (Exception e) {
				e.printStackTrace();
				ro.setCode("0");
	            ro.setMsg("接口异常！");
	            ro.setData("");
	            return ro;
			}
	}
	
	/**
	 * 查询消息列表
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryList")
	@ResponseBody
	public ReturnObject queryList() {
		ReturnObject ro = new ReturnObject();
		try {
	           ro.setCode("1");
	           ro.setMsg("");
	           ro.setData(loginLogService.queryList());
	           return ro;
			} catch (Exception e) {
				e.printStackTrace();
				 ro.setCode("0");
	             ro.setMsg("系统繁忙请稍后再试！！！");
	             ro.setData("");
	             return ro;
	  }
	}
}
