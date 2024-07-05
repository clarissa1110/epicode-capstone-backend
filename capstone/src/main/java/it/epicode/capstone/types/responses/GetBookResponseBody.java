package it.epicode.capstone.types.responses;

import jakarta.annotation.Nullable;
import lombok.Data;

import java.util.List;

@Data
public class GetBookResponseBody {

    private BookResponse[] items;

    public static class BookResponse {
        private String id;
        private String etag;
        private VolumeInfo volumeInfo;

        public String getEtag() {
            return etag;
        }

        public void setEtag(String etag) {
            this.etag = etag;
        }

        public VolumeInfo getVolumeInfo() {
            return volumeInfo;
        }

        public void setVolumeInfo(VolumeInfo volumeInfo) {
            this.volumeInfo = volumeInfo;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class VolumeInfo {
            private String title;
            private String subtitle;
            private List<String> authors;
            private String publisher;
            private String publishedDate;
            private String description;
            private List<String> categories;
            private ImageLinks imageLinks;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public List<String> getAuthors() {
                return authors;
            }

            public void setAuthors(List<String> authors) {
                this.authors = authors;
            }

            public String getPublisher() {
                return publisher;
            }

            public void setPublisher(String publisher) {
                this.publisher = publisher;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPublishedDate() {
                return publishedDate;
            }

            public void setPublishedDate(String publishedDate) {
                this.publishedDate = publishedDate;
            }

            public List<String> getCategories() {
                return categories;
            }

            public void setCategories(List<String> categories) {
                this.categories = categories;
            }

            public ImageLinks getImageLinks() {
                return imageLinks;
            }

            public void setImageLinks(ImageLinks imageLinks) {
                this.imageLinks = imageLinks;
            }

            public static class ImageLinks {
                private String thumbnail;

                public String getThumbnail() {
                    return thumbnail;
                }

                public void setThumbnail(String thumbnail) {
                    this.thumbnail = thumbnail;
                }
            }
        }

    }
}
