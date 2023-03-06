package pl.sewkus.sklep.itemOpinions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import pl.sewkus.sklep.items.Items;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemOpinions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdOpinion;

    private String author;

    private String content;

    private Double stars;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Items item;
}
