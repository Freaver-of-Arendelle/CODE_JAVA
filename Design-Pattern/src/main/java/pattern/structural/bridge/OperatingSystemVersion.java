package pattern.structural.bridge;

/**
 * @author Freaver
 * @date 4/27/2021 14:23
 */
public abstract class OperatingSystemVersion {
    protected VideoFile videoFile;

    public OperatingSystemVersion(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void play(String fileName);
}
