package spittr.web;
/**
 * չ�ֱ��������û�ע��Ӧ��
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
        //����spitter
        //spitterRepository.save(spitter);
        
        return "redirect:/spitter/"+spitter.getUsername();
    }
    
    //{}��ռλ������������ʹ��ĳ��������·���С�
    //���������������ռλ��������ͬ�������������ķ�ʽ��������Ҫʹ��@PathVariable{"username"} String name ����ʽ
    @RequestMapping(value="/{username}",method=RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
        //�ӿ����ȡspitter���˴�δʵ�����ݿ��߼���ֱ��new��һ��
        Spitter spitter = new Spitter(username, "test", "firstName", "lastName", "email");
        model.addAttribute(spitter);
        return "profile";
    }
}
