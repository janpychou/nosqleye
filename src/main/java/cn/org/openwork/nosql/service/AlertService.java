package cn.org.openwork.nosql.service;

import cn.org.openwork.nosql.bean.AlertListDto;
import cn.org.openwork.nosql.bean.PagedDto;
import cn.org.openwork.nosql.bean.RestResponse;

public interface AlertService
{
    /**
     * 根据serverId获取报警手机号
     * @Title: getAlertPhoneNumbers   
     * @param serverId
     * @param serverType
     * @return        
     * @throws
     */
    public RestResponse<String> getAlertPhoneNumbers(Long serverId,String serverType);
    /**
     * 保存报警手机号码
     * @Title: saveAlertConfigPhoneNumbers   
     * @param serverId
     * @param serverType
     * @param phoneNumbers
     * @return        
     * @throws
     */
    public RestResponse<String> saveAlertConfigPhoneNumbers(Long serverId,String serverType,String phoneNumbers);
    /**
     * 获取报警列表分页对象
     * @Title: getAlertList   
     * @param search
     * @param draw
     * @param startIndex
     * @param pageSize
     * @return        
     * @throws
     */
    public PagedDto<AlertListDto> getAlertList(String search,int draw, int startIndex, int pageSize);
}
