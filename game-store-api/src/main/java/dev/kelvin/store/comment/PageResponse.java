package dev.kelvin.store.comment;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponse<T> {
    private int pageNumber;
    private int pageSize;
    private int totalElements;
    private int totalPages;
    private boolean last;
    private boolean first;
}
