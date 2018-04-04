package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    
    
    private SpittleRepository spittleRepository;
    
    @Autowired
    public SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String spittles(Model model){
        //将获取到的spittle列表填充到model中。Model实际上就是一个Map，它会传递给视图，这样数据就能渲染到客户端了。
        //调用addAttribute方法并且不指定key的时候，key会根据值的对象类型推断确定。也可以进行显式声明
        //model.addAttribute("spittleList",spittleRepository.findSpittles(Long.MAX_VALUE, 20))效果跟下面代码一样
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        
        return "spittles";
    }
}
