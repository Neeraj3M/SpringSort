package com.neerajspring;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import java.util.ArrayList;
import java.util.List;

@Controller
public class numberlistController {
	@RequestMapping(value = "/NumberList", method=RequestMethod.GET)
	public ModelAndView NumberList(){
		return new ModelAndView("NumberList","command",new numberlist());
	}
	@RequestMapping(value = "/NumberListView", method=RequestMethod.GET)
	public String ViewPrevious(@ModelAttribute("GetSorted")ArrayList<numberlist> numlist, ModelMap model){
		FileStore mof = new FileStore();
		List<numberlist> oldNumber = new ArrayList<numberlist>();
		try {
			oldNumber = mof.readCSV();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(oldNumber);
		model.addAttribute("sortlist",oldNumber);
		return "NumberListView";
	}
	@RequestMapping(value= "/doSort",method=RequestMethod.POST)
	public String doSort(@ModelAttribute("GetSorted")numberlist NumberList, ModelMap model) throws IOException{
		NumberList.sortList();
		model.addAttribute("Numlist",NumberList.getNumlist());
		model.addAttribute("SortedNumlist",NumberList.getSortedNumlist());
		model.addAttribute("ChangeNo",NumberList.getChangeNo());
		model.addAttribute("TimeTaken", NumberList.getTimeTaken());
		savetofile(NumberList);
		return "numberlistSort";
	}
	public void savetofile(numberlist num) throws IOException{
		FileStore mof = new FileStore();
        mof.storeCSV(num);
	}
	
}
