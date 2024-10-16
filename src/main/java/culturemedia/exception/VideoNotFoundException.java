package culturemedia.exception;

public class VideoNotFoundException extends CultureMediaException {
    public VideoNotFoundException(String title) {
        super(title);
    }
    public VideoNotFoundException() {super ();}
}
