import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class runtimeDemo {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        var process = runtime.exec("ipconfig");
        byte[] bytes = new byte[1000000000];
        InputStream is = process.getInputStream();
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len, StandardCharsets.UTF_8));

    }
    
}
