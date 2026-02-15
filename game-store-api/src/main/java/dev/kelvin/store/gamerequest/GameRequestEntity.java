package dev.kelvin.store.gamerequest;

import dev.kelvin.store.common.BaseEntity;
import dev.kelvin.store.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GameRequestEntity extends BaseEntity {
    private String title;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
