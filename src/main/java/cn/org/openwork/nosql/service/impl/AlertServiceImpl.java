package cn.org.openwork.nosql.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.org.openwork.nosql.bean.AlertConfig;
import cn.org.openwork.nosql.bean.AlertConfigExample;
import cn.org.openwork.nosql.bean.AlertList;
import cn.org.openwork.nosql.bean.AlertListDto;
import cn.org.openwork.nosql.bean.AlertListExample;
import cn.org.openwork.nosql.bean.Constant;
import cn.org.openwork.nosql.bean.PagedDto;
import cn.org.openwork.nosql.bean.RedisServer;
import cn.org.openwork.nosql.bean.RedisServerExample;
import cn.org.openwork.nosql.bean.RestResponse;
import cn.org.openwork.nosql.bean.AlertConfigExample.Criteria;
import cn.org.openwork.nosql.mapper.AlertConfigMapper;
import cn.org.openwork.nosql.mapper.AlertListMapper;
import cn.org.openwork.nosql.mapper.RedisServerMapper;
import cn.org.openwork.nosql.service.AlertService;
import cn.org.openwork.nosql.util.MiscUtil;
@Service
public class AlertServiceImpl implements AlertService
{
    @Resource
    private AlertConfigMapper alertConfigMapper;
    @Resource
    private AlertListMapper alertListMapper;
    @Resource
    private RedisServerMapper redisServerMapper;
    @Override
    public RestResponse<String> getAlertPhoneNumbers(Long serverId,String serverType)
    {
        RestResponse<String> restResponse=new RestResponse<>();
        AlertConfigExample example=new AlertConfigExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andServerIdEqualTo(serverId);
        createCriteria.andServerTypeEqualTo(serverType);
        List<AlertConfig> list = alertConfigMapper.selectByExample(example);
        if (!list.isEmpty())
        {
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
            restResponse.setData(list.get(0).getPhoneNumbers());
        }
        else{
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(Constant.FAIL_MESSAGE);
        }
        return restResponse;
    }
    
    @Override
    public RestResponse<String> saveAlertConfigPhoneNumbers(Long serverId,String serverType,String phoneNumbers)
    {
        RestResponse<String> restResponse=new RestResponse<>();
        AlertConfigExample example=new AlertConfigExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andServerIdEqualTo(serverId);
        createCriteria.andServerTypeEqualTo(serverType);
        try
        {
            List<AlertConfig> list = alertConfigMapper.selectByExample(example);
            AlertConfig alertConfig=null;
            //如不存在，则新增一个
            if (list.isEmpty())
            {
                alertConfig=new AlertConfig();
                alertConfig.setCreateTime(new Date());
                alertConfig.setRealertSecondsLater(Constant.REALERT_SECONDS_LATER);
                alertConfig.setServerId(serverId);
                alertConfig.setServerType(serverType);
                alertConfigMapper.insertSelective(alertConfig);
            }
            else{
                alertConfig=list.get(0);
            }
            //保存报警手机号码
            alertConfig.setPhoneNumbers(phoneNumbers);
            alertConfigMapper.updateByPrimaryKey(alertConfig);   
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        }
        catch (Exception e)
        {
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(Constant.FAIL_MESSAGE);
            e.printStackTrace();
        }
        
        return restResponse;
    }

    @Override
    public PagedDto<AlertListDto> getAlertList(String search, int draw, int startIndex, int pageSize)
    {
        PagedDto<AlertListDto> pagedDto=new PagedDto<>();
        AlertListExample alertListExample=new AlertListExample();
        //如果搜索条件不为空
        if (!search.isEmpty())
        {
            List<Long> serverIds=new ArrayList<>();
            RedisServerExample redisServerExample=new RedisServerExample();
            redisServerExample.createCriteria().andHostLike("%"+search+"%");
            List<RedisServer> redisServers = redisServerMapper.selectByExample(redisServerExample);
            if(!redisServers.isEmpty()){
                for (RedisServer redisServer : redisServers)
                {
                    serverIds.add(redisServer.getId());
                }
                alertListExample.createCriteria().andServerIdIn(serverIds); 
            }
            else{
                alertListExample.createCriteria().andServerIdEqualTo(Constant.ZERO); 
            }
        }
        //获取记录条数
        int count = alertListMapper.countByExample(alertListExample);
        alertListExample.setLimitStart(startIndex);
        alertListExample.setPageSize(pageSize);
        alertListExample.setOrderByClause("id desc");
        //根据条件查询报警记录
        List<AlertList> alertLists = alertListMapper.selectByExample(alertListExample);
        List<AlertListDto> alertListDtos=new ArrayList<>();
        for (AlertList alertList : alertLists)
        {
            RedisServer redisServer = redisServerMapper.selectByPrimaryKey(alertList.getServerId());
            AlertListDto alertListDto=new AlertListDto();
            alertListDto.setAlertContent(alertList.getAlertContent());
            alertListDto.setAlertLevel(alertList.getAlertLevel());
            alertListDto.setCreateTime(MiscUtil.getFormatDateTime(alertList.getCreateTime()));
            alertListDto.setHost(redisServer.getHost());
            alertListDto.setPort(String.valueOf(redisServer.getPort()));
            alertListDto.setServerId(alertList.getServerId());
            alertListDtos.add(alertListDto);
        }
        
        pagedDto.setData(alertListDtos);
        pagedDto.setDraw(draw);
        pagedDto.setRecordsFiltered(count);
        pagedDto.setRecordsTotal(count);
        return pagedDto;
    }
    
}
