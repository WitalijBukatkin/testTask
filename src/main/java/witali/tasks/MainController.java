package witali.tasks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import witali.tasks.domain.Parts;
import witali.tasks.repos.PartsRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    private final PartsRepo partsRepo;

    public MainController(PartsRepo partsRepo) {
        this.partsRepo = partsRepo;
    }

    private void nextPage(List<Parts> parts, Map<String, Object> model, String sIndex){
        ArrayList<Parts> partsIterable=new ArrayList<>();
        int start=0, stop;
        try {
            stop=Integer.parseInt(sIndex);
        } catch (NumberFormatException e){
            stop=10;
        }

        if(stop<10)
            stop=10;
        if(stop>parts.size()) {
            if (parts.size() < 10)
                stop = parts.size();
            else if(stop-10<parts.size()){
                start=stop-10;
                stop = parts.size();
            } else{
                stop=10;
            }
        }
        else
            start=stop-10;

        for (int i = start; i < stop; i++)
            partsIterable.add(parts.get(i));

        model.put("parts", partsIterable);
        model.put("site", stop);
    }

    private int calculateCountComputer(Iterable<Parts> parts){
        final Map<String, Integer> map=new HashMap<>();
        parts.forEach(e->{
            if(e.isNeed())
                map.merge(e.getType(), e.getCount(), (a, b) -> a + b);
        });
        return map.values().stream().mapToInt(i->i).min().orElse(0);
    }

    private void filter(String site, String type, String radio, Map<String, Object> model){
        Iterable<Parts> parts;
        if (type != null) {
            switch(radio){
                case "need":
                    parts = partsRepo.findByTypeLikeAndNeedTrue("%"+type+"%");
                    break;
                case "optional":
                    parts = partsRepo.findByTypeLikeAndNeedFalse("%"+type+"%");
                    break;
                default:
                    parts = partsRepo.findByTypeLike("%"+type+"%");
            }
        }
        else {
            switch(radio){
                case "need":
                    parts = partsRepo.findByNeedTrue();
                    break;
                case "optional":
                    parts = partsRepo.findByNeedFalse();
                    break;
                default:
                    parts = partsRepo.findAll();
            }

        }
        nextPage((List<Parts>)parts, model, site);
        model.put("filterType", type);
        model.put("filterRadio", radio);
    }

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        Iterable<Parts> productsIterable = partsRepo.findAll();
        nextPage((List<Parts>)productsIterable, model, "0");
        model.put("count", calculateCountComputer(productsIterable));
        return "main";
    }

    @GetMapping("add")
    public String add(@RequestParam String type, @RequestParam String model, @RequestParam String count, @RequestParam String need, Map<String, Object> model1) {
        int countInt=0;
        try {
            countInt=Integer.parseInt(count);
        } catch (Exception ignored){}
        Parts parts = new Parts(type, model, countInt, "Yes".equals(need));
        partsRepo.save(parts);
        return main(model1);
    }

    @GetMapping("edit")
    public String edit(@RequestParam String line, @RequestParam String remove, @RequestParam String type, @RequestParam String model, @RequestParam String count, @RequestParam String need, Map<String, Object> model1) {
        if("1".equals(remove)){ //deleting
            try {
                int idInt=Integer.parseInt(line);
                partsRepo.deleteById(idInt);
            } catch (Exception ignored){}
        } else {                //editing
            try {
                int countInt = Integer.parseInt(count);
                int idInt = Integer.parseInt(line);
                Parts parts = partsRepo.findById(idInt).get();
                parts.setType(type);
                parts.setModel(model);
                parts.setCount(countInt);
                parts.setNeed("Yes".equals(need));
                partsRepo.save(parts);
            } catch (Exception ignored) {}
        }
        return main(model1);
    }

    @GetMapping("filter")
    public String filter(@RequestParam String type, @RequestParam String radio, Map<String, Object> model) {
        filter("0", type, radio, model);
        model.put("count", calculateCountComputer(partsRepo.findAll()));
        return "main";
    }

    @GetMapping("nav")
    public String nav(@RequestParam String site, @RequestParam String type, @RequestParam String radio, Map<String, Object> model) {
        if(!type.isEmpty() || !radio.isEmpty())
            filter(site, type, radio, model);
        else
            nextPage((List<Parts>) partsRepo.findAll(), model, site);
        model.put("count", calculateCountComputer(partsRepo.findAll()));
        return "main";
    }
}