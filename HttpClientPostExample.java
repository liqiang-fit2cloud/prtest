import java.io.OutputStream;  
import java.net.HttpURLConnection;  
import java.net.URL;  
  
public class HttpClientPostExample {  
  
    public static void main(String[] args) {  
        String targetUrl = "https://api.example.com/data"; // 替换为实际的API URL  
        String jsonInputString = "{\"key\":\"value\"}"; // 替换为实际的JSON数据  
        String response = sendPostRequest(targetUrl, jsonInputString);  
          
        System.out.println("Response: " + response);  
    }  
  
    public static String sendPostRequest(String targetUrl, String jsonInputString) {  
        HttpURLConnection connection = null;  
        BufferedReader reader = null;  
        StringBuilder response = new StringBuilder();  
        String result = "";  
  
        try {  
            // 创建URL对象  
            URL url = new URL(targetUrl);  
            // 打开连接  
            connection = (HttpURLConnection) url.openConnection();  
            // 设置请求方法为POST  
            connection.setRequestMethod("POST");  
            // 设置请求头，指定内容类型为JSON  
            connection.setRequestProperty("Content-Type", "application/json; utf-8");  
            connection.setRequestProperty("Accept", "application/json");  
            connection.setDoOutput(true);  
  
            // 发送POST输出  
            try (OutputStream os = connection.getOutputStream()) {  
                byte[] input = jsonInputString.getBytes("utf-8");  
                os.write(input, 0, input.length);  
            }  
  
            // 获取响应码  
            int responseCode = connection.getResponseCode();  
            System.out.println("Response Code: " + responseCode);  
  
            // 如果响应码是200（OK），则读取响应内容  
            if (responseCode == HttpURLConnection.HTTP_OK) {  
                // 创建BufferedReader来读取URL的响应  
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));  
                String line;  
                while ((line = reader.readLine()) != null) {  
                    response.append(line);  
                }  
                // 将StringBuilder转换为String  
                result = response.toString();  
            } else {  
                System.out.println("POST request not worked. Response Code: " + responseCode);  
            }  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭资源  
            try {  
                if (reader != null) {  
                    reader.close();  
                }  
                if (connection != null) {  
                    connection.disconnect();  
                }  
            } catch (Exception ex) {  
                ex.printStackTrace();  
            }  
        }  
  
        return result;  
    }  
}
