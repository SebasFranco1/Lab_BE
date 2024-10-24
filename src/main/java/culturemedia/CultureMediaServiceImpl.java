import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import culturemedia.service.CultureMediaServices;
import culturemedia.service.impl.CultureMediaServiceImpl;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;

@Test
void when_find_ForTitle_an_VideoNotFoundException_should_be_thrown_successfully() {
    assertThrows(VideoNotFoundException.class, () -> {
        cultureMediaService.find("anything");
    } );
}

@Test
void when_Find_ByDuration_an_VideoNotFoundException_thrown_successfully() {
    assertThrows(VideoNotFoundException.class, () -> {
        cultureMediaService.find(0.0,0.9);
    });

}

@Test
void when_findByTitle_should_be_returned_successfully() {
    List<Video> videos = List.of(
            exampleVideo1,
            exampleVideo2,
            exampleVideo3,
            exampleVideo4,
            exampleVideo5,
            exampleVideo6
    );

    for ( Video video : videos ) {
        cultureMediaService.add( video );
    }

    assertThrows(VideoNotFoundException.class, () -> {
        cultureMediaService.find("Hilmer");
    });
}

@Test
void when_findByDuration_should_be_returned_succesfully() {
    List<Video> videos = List.of(
            exampleVideo1,
            exampleVideo2,
            exampleVideo3,
            exampleVideo4,
            exampleVideo5,
            exampleVideo6
    );

    for ( Video video : videos ) {
        cultureMediaService.add( video );
    }

    try{
        List<Video> video = cultureMediaService.find(0, 5.5);
        assertEquals(5, video.size());
    }
    catch (VideoNotFoundException e){
        assert(false);
    }
}
    }