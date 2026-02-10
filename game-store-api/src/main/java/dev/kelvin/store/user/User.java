package dev.kelvin.store.user;

import dev.kelvin.store.common.BaseEntity;
import dev.kelvin.store.gamerequest.GameRequest;
import dev.kelvin.store.notification.Notification;
import dev.kelvin.store.wishlist.Wishlist;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "_user")
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String profilePictureUrl;

    @OneToOne
    private Wishlist wishlist;

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user")
    private List<GameRequest> gameRequests;
}
