package culturemedia.repository;

import culturemedia.model.Video;

import java.util.List;

public interface VideoRepository {
    List<Video> findAll();
   void save(Video save);
   List<Video> find(String title);
   List<Video> find(Double fromDuration, Double toDuration);
}
