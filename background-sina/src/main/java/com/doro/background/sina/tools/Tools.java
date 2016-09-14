package com.doro.background.sina.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



public class Tools
{
	  //绛惧悕鐗堟湰
    public static final String SIGN_VERSION_NAME = "sign_version";

    //绛惧悕绫诲瀷
    public static final String SIGN_TYPE_NAME    = "sign_type";

    //绛惧悕鍊�
    public static final String SIGN_NAME         = "sign";

	  /**
     * 鍒涘缓http post鍙戦�鏁版嵁鐨剈rl杩炴帴
     *
     * @param params
     *            杞崲鏁版嵁 map
     * @param encode 鏄惁鍋歶rlencode
     * @return url 
     */
    public static String createLinkString(Map<String, String> params, boolean encode) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        String charset = params.get("_input_charset");
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (encode) {
                try {
                    value = URLEncoder.encode(URLEncoder.encode(value, charset),charset);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if (i == keys.size() - 1) {
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
            }
        
        return prestr;
    }
    
    @SuppressWarnings("rawtypes")
	public static Map<String, String> getParameterMap(Map<String, Object> properties,boolean isFilter) {
        // 参数Map
        //Map properties = request.getParameterMap();
        // 返回值Map
        Map<String, String> returnMap = new HashMap<String, String>();
        Iterator<?> entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            if(isFilter){
            if(!name.equals("sign")&&!name.equals("sign_type")&&!name.equals("sign_version")){
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
            returnMap.put(name, value);
        }
        }else
        {
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
             returnMap.put(name, value);
        }
        }
        return returnMap;
    }
    /**
     * 璁＄畻鏂囦欢鐨凪D5鎽樿鍊�
     * @param file 鏂囦欢璺姴
     * @return 32浣嶇殑MD5鎽樿
     */
    public static String getFileMD5(File file) {
      if (!file.isFile()){
        return null;
      }
      MessageDigest digest = null;
      FileInputStream in=null;
      byte buffer[] = new byte[1024];
      int len;
      try {
        digest = MessageDigest.getInstance("MD5");
        in = new FileInputStream(file);
        while ((len = in.read(buffer, 0, 1024)) != -1) {
          digest.update(buffer, 0, len);
        }
        in.close();
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
      
      String bytes2hex03 = bytes2hex03(digest.digest());
      return bytes2hex03;

    }
    
    public static String bytes2hex03(byte[] bytes)  
    {  
        final String HEX = "0123456789abcdef";  
        StringBuilder sb = new StringBuilder(bytes.length * 2);  
        for (byte b : bytes)  
        {  
            // 鍙栧嚭杩欎釜瀛楄妭鐨勯珮4浣嶏紝鐒跺悗涓�x0f涓庤繍绠楋紝寰楀埌涓�釜0-15涔嬮棿鐨勬暟鎹紝閫氳繃HEX.charAt(0-15)鍗充负16杩涘埗鏁� 
            sb.append(HEX.charAt((b >> 4) & 0x0f));  
            // 鍙栧嚭杩欎釜瀛楄妭鐨勪綆浣嶏紝涓�x0f涓庤繍绠楋紝寰楀埌涓�釜0-15涔嬮棿鐨勬暟鎹紝閫氳繃HEX.charAt(0-15)鍗充负16杩涘埗鏁� 
            sb.append(HEX.charAt(b & 0x0f));  
        }  
  
        return sb.toString();  
    }  
    
}
