package culturemedia.repository;

import java.util.List;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.service.VideoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.Collections;


import culturemedia.model.Video;
import culturemedia.repository.impl.VideoRepositoryImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VideoRepositoryTest {

    private VideoRepository videoRepository;

    @BeforeEach
    void init(){

        videoRepository = new VideoRepositoryImpl();

        List<Video> videos = List.of(new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1));


        for ( Video video : videos ) {
            videoRepository.save( video );
        }

    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() {
        List<Video> videos = videoRepository.findAll( );
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindByTitle_only_videos_which_contains_the_word_in_the_title_should_be_returned_successfully() {
        List<Video> videos = videoRepository.find( "Clic" );
        assertEquals(2, videos.size());
    }

    @Test
    void when_FindByDuration_only_videos_between_the_range_should_be_returned_successfully() {
        List<Video> videos = videoRepository.find( 4.5, 5.5 );
        assertEquals(3, videos.size());
    }

    @Test
    void when_FindByTitle_does_not_match_any_video_an_empty_list_should_be_returned_successfully() {
        assert(false);
    }

    @Test
    void when_FindByDuration_does_not_match_any_video_an_empty_list_should_be_returned_successfully() {
        assert(false);
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        VideoRepository videoRepository = Mockito.mock(VideoRepository.class);
        Video video1 = new Video("Title1", "Description1", 120, "url1");
        Video video2 = new Video("Title2", "Description2", 150, "url2");
        List<Video> videos = Arrays.asList(video1, video2);
        Mockito.when(videoRepository.findAll()).thenReturn(videos);

        VideoService videoService = new VideoService(videoRepository);
        List<Video> returnedVideos = videoService.findAll();

        Assertions.assertEquals(2, returnedVideos.size());
        Assertions.assertTrue(returnedVideos.contains(video1));
        Assertions.assertTrue(returnedVideos.contains(video2));
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        Object Mockito;
        VideoRepository videoRepository = Mockito.mock(VideoRepository.class);
        Mockito.when(videoRepository.findAll()).thenReturn(Collections.emptyList());

        VideoService videoService = new VideoService(videoRepository);

        Assertions.assertThrows(VideoNotFoundException.class, () -> {
            videoService.findAll();
   });
}
}