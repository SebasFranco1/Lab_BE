package culturemedia;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.CultureMediaService;

import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {
    @Override
    public List<Video> listarTodos() {
        return List.of();
    }

    @Override
    public Video agregar(Video video) {
        return null;
    }

    @Override
    public View agregar(View view) {
        return null;
    }
}
