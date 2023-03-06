package pl.sewkus.sklep.itemOpinions;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import pl.sewkus.sklep.items.Items;
import pl.sewkus.sklep.items.ItemsRepo;

@Configuration
@AllArgsConstructor
public class ItemOpinionsConfig {


    private final ItemOpinionsRepo itemOpinionsRepo;

    private final ItemsRepo itemsRepo;

    @Bean
    @DependsOn("oc")
    public void configOpinions(){
        Items item1 = itemsRepo.findById(1L).orElse(null);
        ItemOpinions itemOpinions1 = new ItemOpinions(1L, "Adam","Donec consectetur tristique condimentum.",2.5,item1);
        ItemOpinions itemOpinions2 = new ItemOpinions(2L, "Mati","Braesent venenatis libero quis s.",4.5,item1);
        ItemOpinions itemOpinions3 = new ItemOpinions(3L, "Gawro00","ut egestas ligula ultricies in. Morbi at massa finibus",3.0,item1);
        ItemOpinions itemOpinions4 = new ItemOpinions(4L, "Monika2115","Super!!!.",5.0,item1);

        itemOpinionsRepo.save(itemOpinions1);
        itemOpinionsRepo.save(itemOpinions2);
        itemOpinionsRepo.save(itemOpinions3);
        itemOpinionsRepo.save(itemOpinions4);
    }
}
