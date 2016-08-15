/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.youye.back.controller;

import cn.youye.back.entity.Type;
import cn.youye.back.service.TypeService;
import cn.youye.back.sys.common.BaseController;
import cn.youye.back.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 单表Controller
 * @author Youye
 * @version 2016-08-11
 */
@Controller
@RequestMapping(value = "/type")
public class TypeController extends BaseController {

	@Autowired
	private TypeService typeService;
	
	@ModelAttribute
	public Type get(@RequestParam(required=false) String id) {
		Type entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = typeService.get(id);
		}
		if (entity == null){
			entity = new Type();
		}
		return entity;
	}

	@RequestMapping(value = {"list", ""})
	public String list(Type type, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Type> list=typeService.findList(type);
//		Page<Type> page = typeService.findPage(new Page<Type>(request, response), type);
		model.addAttribute("list", list);
		return "modules/type/typeList";
	}

	@RequestMapping(value = "form")
	public String form(Type type, Model model) {
		model.addAttribute("type", type);
		return "modules/type/typeForm";
	}

	@RequestMapping(value = "save")
	public String save(Type type, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, type)){
			return form(type, model);
		}
		typeService.save(type);
		addMessage(redirectAttributes, "保存单表成功");
		return "redirect:"+"/type/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(Type type, RedirectAttributes redirectAttributes) {
		typeService.delete(type);
		addMessage(redirectAttributes, "删除单表成功");
		return "redirect:"+"/type/?repage";
	}

}