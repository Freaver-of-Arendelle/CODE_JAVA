package pattern.structural.bridge;

/**
 * @author Freaver
 * @date 4/27/2021 14:24
 */
public class Mac extends OperatingSystemVersion{

    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        System.out.println("Mac:");
        videoFile.decode(fileName);
    }
}
