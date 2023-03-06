package pl.sewkus.sklep.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sewkus.sklep.itemOpinions.ItemOpinions;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @GetMapping("/home")
    public String getHome(Model model) {
        List<Items> items = new ArrayList<>(itemsService.getDataFromDB());


        model.addAttribute("items", items);
        return "home";
    }

    @GetMapping("/admin/adminPanel")
    public String adminPanel(Model model) {
        return "adminPanel";
    }

    @GetMapping("/admin/addItem")
    public String addItem(Model model) {

        model.addAttribute("newItem", new Items());


        return "addItem";
    }

    @PostMapping("/admin/addItem")
    public String addItem(@ModelAttribute Items item)
    {
        itemsService.addItem(item);
        return "home";
    }

    @GetMapping("/admin/deleteItem")
    public String deleteItemList(Model model) {


        List<Items> itemList = new ArrayList<>(itemsService.getDataFromDB());

        model.addAttribute("itemList", itemList);


        return "deleteItem";
    }


    /**
     * DELETE WITH THYMELEAF
     */
    @GetMapping("/admin/deleteItem/{id}")
    public String deleteItem(@PathVariable(value = "id") Long id, Model model) {

        Items item = itemsService.getItemById(id);

        itemsService.deleteItem(item);


        return "redirect:/admin/deleteItem";
    }

}
