package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ysd.entity.modules;
import com.ysd.entity.roles;

public class Manager {
      public static Map<String, Object> getResultMap(){
    	  Map<String, Object> resultMap=new HashMap<String, Object>();
    	  resultMap.put("message", "");
    	  resultMap.put("remark", "");
    	  resultMap.put("success", false);
    	  return resultMap;
    	  
      }
      public static List<String> getRoleByName(List<roles> roles){
    	   List<String> roleName=new ArrayList<String>();
    	   String  Name=null;
    	   for(int i=0;i<roles.size();i++) {
    		  Name=roles.get(i).getName();
    		 
    	   }
    	   roleName.add(Name);
    	    return roleName;
      }
      public static List<String> getRoleById(List<roles> roles){
   	   List<String> roleId=new ArrayList<String>();
   	String  Id=null;
   	   for(int i=0;i<roles.size();i++) {
   		  Id=roles.get(i).getId();

   		
   	   }
   	  roleId.add(Id);
   	    return roleId;
     }
      
      public static List<Object> menuChild(int id,List<modules> list){ //子集查找遍历
          List<Object> lists = new ArrayList<Object>(); 
         // int idd=id;
          Map<String,Object> childArray = new HashMap<String, Object>(); 
          for(modules entry: list){           
            if(entry.getParentId()==id){ 
            	System.out.println(entry.getName());
              childArray.put("id", entry.getId()); 
              childArray.put("title", entry.getName());
              childArray.put("href",entry.getPath()); 
              lists.add(childArray);
            } 
            System.out.println(lists);
          } 
          
          return lists; 
        }
}
