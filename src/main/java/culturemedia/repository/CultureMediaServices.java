package culturemedia.repository;

import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CultureMediaServices {
    List<Video> listarTodos();

    Video agregar(Video video);

    View agregar(View view);
}