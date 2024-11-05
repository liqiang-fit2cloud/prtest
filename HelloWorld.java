public class HelloWorld {
    public static void main(String[] args) {
        // 原始字符串
        String originalString = "Hello, World! World is beautiful.";
        
        // 替换 "World" 为 "Java1"
        String replacedString = originalString.replace("World", "Java");
        
        // 输出结果
        System.out.println("原始字符串: " + originalString);
        System.out.println("替换后的字符串11: " + replacedString);
        System.out.println(originalString + replacedString);
    }
}
