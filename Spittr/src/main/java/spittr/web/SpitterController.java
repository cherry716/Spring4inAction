package spittr.web;
/**
 * 展现表单，允许用户注册应用
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.Spitter;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    
    @Autowired
    private SpittleRepository spitterRepository;
    
    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String showRegistrationForm(){
        return "registerForm";
    }
    
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String processRegistration(Spitter spitter){
        //保存spitter
        //spitterRepository.save(spitter);
        
        return "redirect:/spitter/"+spitter.getUsername();
    }
    
    //{}是占位符，这样可以使得某变量放在路径中。
    //如果方法参数名跟占位符名称相同，则可以用下面的方式，否则需要使用@PathVariable{"username"} String name 的形式
    @RequestMapping(value="/{username}",method=RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
        //从库里获取spitter。此处未实现数据库逻辑，直接new了一个
        Spitter spitter = new Spitter(username, "test", "firstName", "lastName", "email");
        model.addAttribute(spitter);
        return "profile";
    }
}
