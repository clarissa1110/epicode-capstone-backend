package it.epicode.capstone.types.responses;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CompleteGetBookResponseBody {

    private BookResponse[] items;
    public class BookResponse {
        private String kind;
        private String id;
        private String etag;
        private String selfLink;
        private VolumeInfo volumeInfo;
        private UserInfo userInfo;
        private SaleInfo saleInfo;
        private AccessInfo accessInfo;
        private SearchInfo searchInfo;

        public String getSelfLink() {
            return selfLink;
        }

        public void setSelfLink(String selfLink) {
            this.selfLink = selfLink;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

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

        public UserInfo getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfo userInfo) {
            this.userInfo = userInfo;
        }

        public SaleInfo getSaleInfo() {
            return saleInfo;
        }

        public void setSaleInfo(SaleInfo saleInfo) {
            this.saleInfo = saleInfo;
        }

        public AccessInfo getAccessInfo() {
            return accessInfo;
        }

        public void setAccessInfo(AccessInfo accessInfo) {
            this.accessInfo = accessInfo;
        }

        public SearchInfo getSearchInfo() {
            return searchInfo;
        }

        public void setSearchInfo(SearchInfo searchInfo) {
            this.searchInfo = searchInfo;
        }

        public static class VolumeInfo {
            private String title;
            private String subtitle;
            private List<String> authors;
            private String publisher;
            private String publishedDate;
            private String description;
            private List<IndustryIdentifier> industryIdentifiers;
            private Integer pageCount;
            private Dimensions dimensions;
            private String printType;
            private String mainCategory;
            private List<String> categories;
            private Double averageRating;
            private Integer ratingsCount;
            private String contentVersion;
            private ImageLinks imageLinks;
            private String language;
            private String previewLink;
            private String infoLink;
            private String canonicalVolumeLink;

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

            public String getPublishedDate() {
                return publishedDate;
            }

            public void setPublishedDate(String publishedDate) {
                this.publishedDate = publishedDate;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public List<IndustryIdentifier> getIndustryIdentifiers() {
                return industryIdentifiers;
            }

            public void setIndustryIdentifiers(List<IndustryIdentifier> industryIdentifiers) {
                this.industryIdentifiers = industryIdentifiers;
            }

            public Integer getPageCount() {
                return pageCount;
            }

            public void setPageCount(Integer pageCount) {
                this.pageCount = pageCount;
            }

            public Dimensions getDimensions() {
                return dimensions;
            }

            public void setDimensions(Dimensions dimensions) {
                this.dimensions = dimensions;
            }

            public String getPrintType() {
                return printType;
            }

            public void setPrintType(String printType) {
                this.printType = printType;
            }

            public String getMainCategory() {
                return mainCategory;
            }

            public void setMainCategory(String mainCategory) {
                this.mainCategory = mainCategory;
            }

            public List<String> getCategories() {
                return categories;
            }

            public void setCategories(List<String> categories) {
                this.categories = categories;
            }

            public Double getAverageRating() {
                return averageRating;
            }

            public void setAverageRating(Double averageRating) {
                this.averageRating = averageRating;
            }

            public Integer getRatingsCount() {
                return ratingsCount;
            }

            public void setRatingsCount(Integer ratingsCount) {
                this.ratingsCount = ratingsCount;
            }

            public String getContentVersion() {
                return contentVersion;
            }

            public void setContentVersion(String contentVersion) {
                this.contentVersion = contentVersion;
            }

            public ImageLinks getImageLinks() {
                return imageLinks;
            }

            public void setImageLinks(ImageLinks imageLinks) {
                this.imageLinks = imageLinks;
            }

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public String getPreviewLink() {
                return previewLink;
            }

            public void setPreviewLink(String previewLink) {
                this.previewLink = previewLink;
            }

            public String getInfoLink() {
                return infoLink;
            }

            public void setInfoLink(String infoLink) {
                this.infoLink = infoLink;
            }

            public String getCanonicalVolumeLink() {
                return canonicalVolumeLink;
            }

            public void setCanonicalVolumeLink(String canonicalVolumeLink) {
                this.canonicalVolumeLink = canonicalVolumeLink;
            }

            public static class IndustryIdentifier {
                private String type;
                private String identifier;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getIdentifier() {
                    return identifier;
                }

                public void setIdentifier(String identifier) {
                    this.identifier = identifier;
                }
            }

            public static class Dimensions {
                private String height;
                private String width;
                private String thickness;

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getThickness() {
                    return thickness;
                }

                public void setThickness(String thickness) {
                    this.thickness = thickness;
                }
            }

            public static class ImageLinks {
                private String smallThumbnail;
                private String thumbnail;
                private String small;
                private String medium;
                private String large;
                private String extraLarge;

                public String getSmallThumbnail() {
                    return smallThumbnail;
                }

                public void setSmallThumbnail(String smallThumbnail) {
                    this.smallThumbnail = smallThumbnail;
                }

                public String getThumbnail() {
                    return thumbnail;
                }

                public void setThumbnail(String thumbnail) {
                    this.thumbnail = thumbnail;
                }

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getExtraLarge() {
                    return extraLarge;
                }

                public void setExtraLarge(String extraLarge) {
                    this.extraLarge = extraLarge;
                }
            }
        }

        public static class UserInfo {
            private Map<String, Object> review;
            private Map<String, Object> readingPosition;
            private Boolean isPurchased;
            private Boolean isPreordered;
            private String updated;

            public Map<String, Object> getReview() {
                return review;
            }

            public void setReview(Map<String, Object> review) {
                this.review = review;
            }

            public Map<String, Object> getReadingPosition() {
                return readingPosition;
            }

            public void setReadingPosition(Map<String, Object> readingPosition) {
                this.readingPosition = readingPosition;
            }

            public Boolean getPurchased() {
                return isPurchased;
            }

            public void setPurchased(Boolean purchased) {
                isPurchased = purchased;
            }

            public Boolean getPreordered() {
                return isPreordered;
            }

            public void setPreordered(Boolean preordered) {
                isPreordered = preordered;
            }

            public String getUpdated() {
                return updated;
            }

            public void setUpdated(String updated) {
                this.updated = updated;
            }
        }

        public static class SaleInfo {
            private String country;
            private String saleability;
            private String onSaleDate;
            private Boolean isEbook;
            private Price listPrice;
            private Price retailPrice;
            private String buyLink;

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getSaleability() {
                return saleability;
            }

            public void setSaleability(String saleability) {
                this.saleability = saleability;
            }

            public String getOnSaleDate() {
                return onSaleDate;
            }

            public void setOnSaleDate(String onSaleDate) {
                this.onSaleDate = onSaleDate;
            }

            public Boolean getEbook() {
                return isEbook;
            }

            public void setEbook(Boolean ebook) {
                isEbook = ebook;
            }

            public Price getListPrice() {
                return listPrice;
            }

            public void setListPrice(Price listPrice) {
                this.listPrice = listPrice;
            }

            public Price getRetailPrice() {
                return retailPrice;
            }

            public void setRetailPrice(Price retailPrice) {
                this.retailPrice = retailPrice;
            }

            public String getBuyLink() {
                return buyLink;
            }

            public void setBuyLink(String buyLink) {
                this.buyLink = buyLink;
            }

            public static class Price {
                private Double amount;
                private String currencyCode;

                public Double getAmount() {
                    return amount;
                }

                public void setAmount(Double amount) {
                    this.amount = amount;
                }

                public String getCurrencyCode() {
                    return currencyCode;
                }

                public void setCurrencyCode(String currencyCode) {
                    this.currencyCode = currencyCode;
                }
            }
        }

        public static class AccessInfo {
            private String country;
            private String viewability;
            private Boolean embeddable;
            private Boolean publicDomain;
            private String textToSpeechPermission;
            private Format epub;
            private Format pdf;
            private String webReaderLink;
            private String accessViewStatus;
            private DownloadAccess downloadAccess;

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getViewability() {
                return viewability;
            }

            public void setViewability(String viewability) {
                this.viewability = viewability;
            }

            public Boolean getEmbeddable() {
                return embeddable;
            }

            public void setEmbeddable(Boolean embeddable) {
                this.embeddable = embeddable;
            }

            public Boolean getPublicDomain() {
                return publicDomain;
            }

            public void setPublicDomain(Boolean publicDomain) {
                this.publicDomain = publicDomain;
            }

            public String getTextToSpeechPermission() {
                return textToSpeechPermission;
            }

            public void setTextToSpeechPermission(String textToSpeechPermission) {
                this.textToSpeechPermission = textToSpeechPermission;
            }

            public Format getEpub() {
                return epub;
            }

            public void setEpub(Format epub) {
                this.epub = epub;
            }

            public Format getPdf() {
                return pdf;
            }

            public void setPdf(Format pdf) {
                this.pdf = pdf;
            }

            public String getWebReaderLink() {
                return webReaderLink;
            }

            public void setWebReaderLink(String webReaderLink) {
                this.webReaderLink = webReaderLink;
            }

            public String getAccessViewStatus() {
                return accessViewStatus;
            }

            public void setAccessViewStatus(String accessViewStatus) {
                this.accessViewStatus = accessViewStatus;
            }

            public DownloadAccess getDownloadAccess() {
                return downloadAccess;
            }

            public void setDownloadAccess(DownloadAccess downloadAccess) {
                this.downloadAccess = downloadAccess;
            }

            public static class Format {
                private Boolean isAvailable;
                private String downloadLink;
                private String acsTokenLink;

                public Boolean getAvailable() {
                    return isAvailable;
                }

                public void setAvailable(Boolean available) {
                    isAvailable = available;
                }

                public String getDownloadLink() {
                    return downloadLink;
                }

                public void setDownloadLink(String downloadLink) {
                    this.downloadLink = downloadLink;
                }

                public String getAcsTokenLink() {
                    return acsTokenLink;
                }

                public void setAcsTokenLink(String acsTokenLink) {
                    this.acsTokenLink = acsTokenLink;
                }
            }

            public static class DownloadAccess {
                private String kind;
                private String volumeId;
                private Boolean restricted;
                private Boolean deviceAllowed;
                private Boolean justAcquired;
                private Integer maxDownloadDevices;
                private Integer downloadsAcquired;
                private String nonce;
                private String source;
                private String reasonCode;
                private String message;
                private String signature;

                public String getKind() {
                    return kind;
                }

                public void setKind(String kind) {
                    this.kind = kind;
                }

                public String getVolumeId() {
                    return volumeId;
                }

                public void setVolumeId(String volumeId) {
                    this.volumeId = volumeId;
                }

                public Boolean getRestricted() {
                    return restricted;
                }

                public void setRestricted(Boolean restricted) {
                    this.restricted = restricted;
                }

                public Boolean getDeviceAllowed() {
                    return deviceAllowed;
                }

                public void setDeviceAllowed(Boolean deviceAllowed) {
                    this.deviceAllowed = deviceAllowed;
                }

                public Boolean getJustAcquired() {
                    return justAcquired;
                }

                public void setJustAcquired(Boolean justAcquired) {
                    this.justAcquired = justAcquired;
                }

                public Integer getMaxDownloadDevices() {
                    return maxDownloadDevices;
                }

                public void setMaxDownloadDevices(Integer maxDownloadDevices) {
                    this.maxDownloadDevices = maxDownloadDevices;
                }

                public Integer getDownloadsAcquired() {
                    return downloadsAcquired;
                }

                public void setDownloadsAcquired(Integer downloadsAcquired) {
                    this.downloadsAcquired = downloadsAcquired;
                }

                public String getNonce() {
                    return nonce;
                }

                public void setNonce(String nonce) {
                    this.nonce = nonce;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public String getReasonCode() {
                    return reasonCode;
                }

                public void setReasonCode(String reasonCode) {
                    this.reasonCode = reasonCode;
                }

                public String getMessage() {
                    return message;
                }

                public void setMessage(String message) {
                    this.message = message;
                }

                public String getSignature() {
                    return signature;
                }

                public void setSignature(String signature) {
                    this.signature = signature;
                }
            }
        }

        public static class SearchInfo {
            private String textSnippet;

            public String getTextSnippet() {
                return textSnippet;
            }

            public void setTextSnippet(String textSnippet) {
                this.textSnippet = textSnippet;
            }
        }
    }
}
