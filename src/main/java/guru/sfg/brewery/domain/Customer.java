/*
 *  Copyright 2020 the original author or authors.
 *
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package guru.sfg.brewery.domain;

import guru.sfg.brewery.domain.security.User;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

/**
 * Created by jt on 2019-01-26.
 */
@Data
@NoArgsConstructor
@Entity
public class Customer extends BaseEntity {

    @Builder
    public Customer(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String customerName,
                    UUID apiKey, Set<BeerOrder> beerOrders, TopTitle topTitle,
                    AboutMyself aboutme, Set<CustomerServices> servicesOffered) {
        super(id, version, createdDate, lastModifiedDate);
        this.customerName = customerName;
        this.apiKey = apiKey;
        this.beerOrders = beerOrders;
        this.topTitle = topTitle;
        this.aboutMyself = aboutme;
        this.customerServicesOfferedSet = servicesOffered;
    }

    private String customerName;

    @Column(length = 36, columnDefinition = "varchar")
    private UUID apiKey;

    @OneToMany(mappedBy = "customer")
    private Set<BeerOrder> beerOrders;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private TopTitle topTitle;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AboutMyself aboutMyself;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> users;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Set<CustomerServices> customerServicesOfferedSet;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Set<TechnicalSkills> customerTechnicalSkills;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Set<TechnicalExperience> customerTechnicalExperience;
}
