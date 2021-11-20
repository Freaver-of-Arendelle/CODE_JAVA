package pattern.structural.bridge;

/**
 * @author Freaver
 * @date 4/27/2021 14:24
 */
public class Windows extends OperatingSystemVersion{

    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        System.out.println("Windows:");
        videoFile.decode(fileName);
    }
}
