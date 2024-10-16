package culturemedia.repository;

import culturemedia.model.Video;

import java.util.List;

interface VideoRepository {
    List<Video> findAll();
   Video save(Video save);
   List<Video> find(String title);
   List<Video> find(Double fromDuration, Double toDuration);
}
