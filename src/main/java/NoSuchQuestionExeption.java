import java.nio.file.NoSuchFileException;

public class NoSuchQuestionExeption extends Exception {
    public NoSuchQuestionExeption(String msg) {
        super(msg);
    }
}
