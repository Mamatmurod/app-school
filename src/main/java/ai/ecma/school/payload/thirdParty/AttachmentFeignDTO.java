package ai.ecma.school.payload.thirdParty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentFeignDTO {
    private String id;
    private Long size;
    private String contentType;
    private String name;
    private String path;
    private String url;
    private String urlOpen;
    private String thumbnailLarge;
    private String thumbnailMedium;
    private String thumbnailSmall;
    private String description;
    private Long createdAt;
    private String fileId;
}
