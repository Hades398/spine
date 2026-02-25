package sam.spine.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookResponse {
    private List<Item> items;

    @Data
    public static class Item {
        private VolumeInfo volumeInfo;
    }

    @Data
    public static class VolumeInfo {
        private String title;
        private List<String> authors;
        private String description;
        private String isbn;
        private String google_Id;
        private String image_url;
    }
}
