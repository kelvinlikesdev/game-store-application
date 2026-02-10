package dev.kelvin.store.game;

import dev.kelvin.store.category.Category;
import dev.kelvin.store.comment.Comment;
import dev.kelvin.store.common.BaseEntity;
import dev.kelvin.store.wishlist.Wishlist;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Game extends BaseEntity {
    private String title;
    @Enumerated(EnumType.STRING)
    private SupportedPlatforms supportedPlatforms;
    private String coverPicture;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "game") // mappedBy is from the one side(not many)
    private List<Comment> comments;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "game_wishlist",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "wishlist_id")
    )
    List<Wishlist> wishlists;

    public void addWishlist(Wishlist wishlist) {
        if (!this.wishlists.contains(wishlist)) {
            this.wishlists.add(wishlist);
            wishlist.getGames().add(this);
        }
    }

    public void removeWishlist(Wishlist wishlist) {
        if (this.wishlists.contains(wishlist)) {
            this.wishlists.remove(wishlist);
            wishlist.getGames().remove(this);
        }
    }

}
