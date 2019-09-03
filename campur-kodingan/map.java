1. objek map List: create list
  public Map<String,Object> findByName(String username) {
  Map map = new HashMap();
  UserHead a = new UserHead();    
  String sql = "SELECT * FROM tabel where username = ?";
                 
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,username);
                if(rows !=null) {
                    for (Map<String, Object> row : rows) {

                        a.setId((Integer) row.get("id"));
                        a.setUsername((String) row.get("username"));


                        if (username.equals(a.getUsername())) {
                            map.put("data", a);
                            map.put("flag", flag_sukses);
                            map.put("message", "User name " + a.getUsername() + " is axisting ");
                            return map;
                        }

                    }
                }
                }
  2. print objek map : 
   Map map = new HashMap();
        Response cetak = new Response();
        UserHead cetak_anaknya = new UserHead(); 
        //cek usermame exist
        Map<String, Object> rows = findByName(obj.getUsername());
        UserHead a = new UserHead();
        if(rows.get("flag").equals(flag_sukses)) {  //jika sukses
            cetak.setObjekList(( List<Map<String, Object>>) rows.get("data"));
                    for (Map<String, Object> row : cetak.getObjekList()) {
                          cetak_anaknya.setId((Integer) row.get("id"));
                          cetak_anaknya.setUsername((String) row.get("username"));

                    }
                System.out.println("id saya"+cetak_anaknya.getId());
                System.out.println("nama saya "+cetak_anaknya.getUsername());
                System.out.println("vobj.getUsername "+obj.getUsername());

            if(cetak_anaknya.getUsername().equals(obj.getUsername())){
                                      //bnear
            }    else{
                               map.put("flag", flag_eror);
                                map.put("message", "user "+ obj.getUsername()+" not found ");
                                return map;
            }
        }
  
  
  3.isi repsonse
  @Data
  public class Response {
    UserHead userhead;
  }
  
4. cetak map for
   public static void showLog(Map<String, Object> map, String title) {
        System.out.println("Process : " + title);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + " : " + value);
        }
        System.out.println("========================");
    }
