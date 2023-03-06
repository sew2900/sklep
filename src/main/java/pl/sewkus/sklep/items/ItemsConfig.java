package pl.sewkus.sklep.items;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ItemsConfig {

    private final ItemsRepo itemsRepo;

    @Bean(name = "oc")
    public void configItems(){
        itemsRepo.save(new Items(1L,"Book","Lorem ipsum dolor sit amet, consectetur adipiscing elit. ", "https://smartmobilestudio.com/wp-content/uploads/2012/06/leather-book-preview.png", 29.99));
        itemsRepo.save(new Items(2L,"Some another item","Vivamus aliquam, odio ut commodo venenatis, ante lorem dapibus ipsum,", "https://smartmobilestudio.com/wp-content/uploads/2012/06/leather-book-preview.png", 46.99));
        itemsRepo.save(new Items(3L,"Just item","placerat augue quam ac orci. Morbi commodo luctus", "https://smartmobilestudio.com/wp-content/uploads/2012/06/leather-book-preview.png", 10));
        itemsRepo.save(new Items(4L,"Just some item","venenatis libero quis scelerisque", "https://smartmobilestudio.com/wp-content/uploads/2012/06/leather-book-preview.png", 292.99));
        itemsRepo.save(new Items(5L,"Good brand item","ligula ultricies in. Morbi at massa finibus, consectetur tortor eget, rhoncus ipsum. Donec consectetur tristique condimentum. Aliquam", "https://smartmobilestudio.com/wp-content/uploads/2012/06/leather-book-preview.png", 29.99));
        itemsRepo.save(new Items(6L,"Not best item","Praesent venenatis libero", "https://smartmobilestudio.com/wp-content/uploads/2012/06/leather-book-preview.png", 29.99));
        itemsRepo.save(new Items(7L,"Bike","nibh, ac dignissim est interdum sed. Sed eleifend. ", "https://smartmobilestudio.com/wp-content/uploads/2012/06/leather-book-preview.png", 293.99));
        itemsRepo.save(new Items(8L,"Pen","uis scelerisque convallis. Ut efficitur dapibus lorem, a porta ante vestibulum vehicula. Lorem ipsum dolor sit amet, consectetur", "https://smartmobilestudio.com/wp-content/uploads/2012/06/leather-book-preview.png", 1.99));
        itemsRepo.save(new Items(9L,"PC","varius nibh, ac dignissim est interdum sed. Sed eleifend. ", "https://smartmobilestudio.com/wp-content/uploads/2012/06/leather-book-preview.png", 1129.99));
    }
}
