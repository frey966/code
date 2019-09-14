package cn.jmfen.backend.business.live.controller;

import cn.jmfen.backend.business.live.model.RecommendInfo;
import cn.jmfen.backend.business.live.model.RoomRecommend;
import cn.jmfen.backend.business.live.model.RoomRecommendReq;
import cn.jmfen.backend.business.live.service.AnchorFeginApi;
import cn.jmfen.backend.model.CommonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping("/live")
public class AnchorFeginApiController  {

    @Value("${live-api}")
    private String URL;
    @Autowired
    private AnchorFeginApi anchorFeginApi;
    @Autowired
    private RestTemplate restTemplate;
    /**
     *分页查询推荐列表
     * @param pageNum
     * @param pageSize
     * @param zone
     * @param clientType
     * @param matchType
     * @param status
     * @return
     */
    @PostMapping("/v1/rooms/recommendListSplit")
    public CommonResult<Page<RecommendInfo>> getRecommendListSplit(@RequestParam("pageNum")Integer pageNum,
                                                                   @RequestParam("pageSize")Integer pageSize,
                                                                   @RequestParam("type")Integer type,
                                                                   @RequestParam(value = "zone",required = false) Integer zone,
                                                                   @RequestParam(value = "clientType",required = false) String clientType,
                                                                   @RequestParam(value = "matchType",required = false) Integer matchType,
                                                                   @RequestParam(value = "status",required = false) Integer status,HttpServletRequest request)

    {
        String url=URL+"/v1/rooms/recommendListSplit";
        Map map=getParameterMap(request);
        if(map!=null){
            String params = getUrlParamsByMap(map);
            url=url+"?"+ params;
        }
        CommonResult<Page<RecommendInfo>> result = restTemplate.getForObject(url, CommonResult.class);
        return result;
    }

    /**
     * 新增、修改
     * @param recommendReq
     * @param request
     * @return
     */
    @PostMapping("/v1/rooms/insertOrUpdate")
    public String   insertOrUpdate(@RequestBody RoomRecommendReq recommendReq,HttpServletRequest request){
        CommonResult<RoomRecommend> Entity = new CommonResult<RoomRecommend>();
        String url=URL+"/v1/rooms/recommend";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String,Object> map = new HashMap<>();
        map.put("clientType",recommendReq.getClientType());
        map.put("description",recommendReq.getDescription());
        map.put("startDate",recommendReq.getStartDate());
        map.put("endDate",recommendReq.getEndDate());
        map.put("status",recommendReq.getStatus());
        map.put("sort",recommendReq.getSort());
        map.put("roomId",recommendReq.getRoomId());
        map.put("zone",recommendReq.getZone());
        map.put("matchType",recommendReq.getMatchId());
        map.put("matchId",recommendReq.getMatchId());
        map.put("anchorId",recommendReq.getAnchorId());
        map.put("image",recommendReq.getImage());
        map.put("type",recommendReq.getType());
        map.put("appImage",recommendReq.getAppImage());
        map.put("webImage",recommendReq.getWebImage());
        HttpEntity<HashMap> requestBody = new HttpEntity<HashMap> ((HashMap)  map,headers);
        String result = restTemplate.postForObject(url, requestBody,String.class);
        return result;
    }




    public static Map getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            if(!cn.jmfen.backend.common.utils.StringUtils.isEmpty(value)){
                returnMap.put(name, value);
            }

        }
        return returnMap;
    }


    public static String getUrlParamsByMap(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }
        String s = sb.toString();
        if (s.endsWith("&")) {
            s = StringUtils.substringBeforeLast(s, "&");
        }
        return s;
    }


}
