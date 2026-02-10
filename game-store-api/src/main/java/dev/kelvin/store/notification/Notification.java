package dev.kelvin.store.notification;

import dev.kelvin.store.common.BaseEntity;
import dev.kelvin.store.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notification extends BaseEntity {
    private String message;
    private String receiver;
    @Enumerated(EnumType.STRING)
    private NotificationLevel level;
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
