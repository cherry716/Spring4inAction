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
        //����ȡ����spittle�б���䵽model�С�Modelʵ���Ͼ���һ��Map�����ᴫ�ݸ���ͼ���������ݾ�����Ⱦ���ͻ����ˡ�
        //����addAttribute�������Ҳ�ָ��key��ʱ��key�����ֵ�Ķ��������ƶ�ȷ����Ҳ���Խ�����ʽ����
        //model.addAttribute("spittleList",spittleRepository.findSpittles(Long.MAX_VALUE, 20))Ч�����������һ��
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        
        return "spittles";
    }
}