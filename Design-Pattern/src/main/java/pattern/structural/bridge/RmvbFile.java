package pattern.structural.bridge;

/**
 * @author Freaver
 * @date 4/27/2021 14:22
 */
public class RmvbFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("rmvb: " + fileName);
    }
}
