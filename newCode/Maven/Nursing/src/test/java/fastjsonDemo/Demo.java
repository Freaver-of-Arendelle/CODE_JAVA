package fastjsonDemo;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import org.junit.Test;


/**
 * @author Freaver
 * @Time 07/12/2021 12:54
 * @Description
 */

public class Demo {

    @Test
    public void test() {
        String s = "gjkhkhkkk";
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

        AES aes = SecureUtil.aes(key);

        System.out.println(new String(key));

        byte[] encrypt = aes.encrypt(s);
        byte[] decrypt = aes.decrypt(encrypt);

        System.out.println(aes.toString());

        System.out.println(new String(encrypt));
        System.out.println(new String(decrypt));


    }
}
