package pl.sewkus.sklep.itemOpinions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sewkus.sklep.items.Items;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemOpinionsController {

    @Autowired
    private ItemOpinionsService itemOpinionsService;

    @GetMapping("/item/{id}")
    public String getHome(@PathVariable(value = "id") Long id, Model model) {

        Items item = itemOpinionsService.getItem(id);
        List<ItemOpinions> itemOpinions = new ArrayList<>(itemOpinionsService.getByItemId(id));


        double rating = itemOpinionsService.getRating(itemOpinions);



        model.addAttribute("item", item);
        model.addAttribute("itemOpinions", itemOpinions);
        model.addAttribute("rating", rating);

        model.addAttribute("opinion", new ItemOpinions());

        return "item";
    }
    @PostMapping("/item/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public String addOpinionTest(@PathVariable(value = "id") Long id, @ModelAttribute ItemOpinions opinion)
    {

        itemOpinionsService.addItemOpinion(id, opinion);
        return "redirect:/item/" + id;
    }

}
