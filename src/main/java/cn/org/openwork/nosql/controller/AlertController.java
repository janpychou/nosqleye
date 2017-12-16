package cn.org.openwork.nosql.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.org.openwork.nosql.service.AlertService;

@RestController
@RequestMapping(value = "/api")
public class AlertController
{
    @Resource
    private AlertService alertService;
    /**
     * 获取告警通知的手机号码
     * @Title: getAlertPhoneNumbers   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-alert-phonenumbers")
    public Object getAlertPhoneNumbers(HttpServletRequest request, HttpServletResponse response)
    {
        Long serverId = Long.valueOf(request.getParameter("serverId"));
        String serverType = request.getParameter("serverType");
        return alertService.getAlertPhoneNumbers(serverId, serverType);
    }
    /**
     * 保存报警手机号码
     * @Title: saveAlertConfigPhoneNumbers   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/save-alert-phonenumbers")
    public Object saveAlertConfigPhoneNumbers(HttpServletRequest request, HttpServletResponse response)
    {
        Long serverId = Long.valueOf(request.getParameter("serverId"));
        String serverType = request.getParameter("serverType");
        String phoneNumbers = request.getParameter("phoneNumbers");
        return alertService.saveAlertConfigPhoneNumbers(serverId, serverType, phoneNumbers);
    }
    @RequestMapping(value = "/get-alert-list")
    public Object getAlertList(HttpServletRequest request, HttpServletResponse response)
    {
        //搜索条件
        String search = request.getParameter("search[value]");
        int draw = Integer.parseInt(request.getParameter("draw"));
        int startIndex = Integer.parseInt(request.getParameter("start"));
        int pageSize = Integer.parseInt(request.getParameter("length"));
        return alertService.getAlertList(search,draw, startIndex, pageSize);
    }
}
