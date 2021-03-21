package guru.sfg.brewery.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class CustomerServices extends BaseEntity {
    private String serviceTitle;
    private String serviceDescription;

    @Builder
    public CustomerServices(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                            String serviceTitle, String serviceDetail, Customer customer) {
        super(id, version, createdDate, lastModifiedDate);
        this.serviceTitle = serviceTitle;
        this.serviceDescription = serviceDetail;
        this.customer = customer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
