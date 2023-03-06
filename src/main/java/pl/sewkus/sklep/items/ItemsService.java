package pl.sewkus.sklep.items;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {

    private ItemsRepo itemsRepo;

    public ItemsService(ItemsRepo itemsRepo) {
        this.itemsRepo = itemsRepo;
    }

    public List<Items> getDataFromDB()
    {
        return itemsRepo.findAll();
    }

    public Items getItemById(Long id){
        return itemsRepo.findById(id).orElse(null);
    }

    public Items addItem(Items item){
        return itemsRepo.save(item);
    }

    public void deleteItem(Items item) {
        itemsRepo.delete(item);
    }
}
