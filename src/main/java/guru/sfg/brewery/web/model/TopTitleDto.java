package guru.sfg.brewery.web.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TopTitleDto extends BaseItem {

    @Builder
    public TopTitleDto(UUID id, Integer version, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate,
                       String fullName, String jobTitle) {
        super(id, version, createdDate, lastModifiedDate);
        this.fullName = fullName;
        this.jobTitle = jobTitle;
    }

    private String fullName;
    private String jobTitle;
}
