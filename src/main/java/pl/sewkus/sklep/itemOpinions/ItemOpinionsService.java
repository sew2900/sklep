package pl.sewkus.sklep.itemOpinions;

import org.springframework.stereotype.Service;
import pl.sewkus.sklep.items.Items;
import pl.sewkus.sklep.items.ItemsRepo;
import java.util.List;

@Service
public class ItemOpinionsService {

    private ItemOpinionsRepo itemOpinionsRepo;
    private ItemsRepo itemsRepo;

    public ItemOpinionsService(ItemOpinionsRepo itemOpinionsRepo, ItemsRepo itemsRepo) {
        this.itemOpinionsRepo = itemOpinionsRepo;
        this.itemsRepo = itemsRepo;
    }

    public List<ItemOpinions> getByItemId(Long id) {
        return itemOpinionsRepo.findAllByItemId(id);
    }

    public double getRating(List<ItemOpinions> itemOpinions) {
        double rating = 0;
        double count = 0;
        if(!itemOpinions.isEmpty()) {
            for (ItemOpinions iO : itemOpinions) {
                count++;
                rating += iO.getStars();

            }
            rating = rating / count;
        }
        System.out.println(rating);
        return  rating;
    }
    public Items getItem(Long id) {
        return itemsRepo.findById(id).orElse(null);
    }

    public ItemOpinions addItemOpinion(Long id, ItemOpinions itemOpinions) {
        itemOpinions.setItem(itemsRepo.findById(id).orElse(null));
        return itemOpinionsRepo.save(itemOpinions);
    }

}
