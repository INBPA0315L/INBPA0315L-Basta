package hu.unideb.inf;


import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LegoSet {

    @EqualsAndHashCode.Include
    private final String code;

    @Setter
    private String theme;

    @ToString.Exclude
    private int bricks;

}
