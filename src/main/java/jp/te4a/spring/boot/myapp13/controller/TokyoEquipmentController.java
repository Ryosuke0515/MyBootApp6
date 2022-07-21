package jp.te4a.spring.boot.myapp13.controller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.te4a.spring.boot.myapp13.bean.Tokyo;
import jp.te4a.spring.boot.myapp13.form.EquipmentForm;
import jp.te4a.spring.boot.myapp13.service.TokyoEquipmentService;

@Controller
@RequestMapping("equipment")
public class TokyoEquipmentController {
  @Autowired
  TokyoEquipmentService tokyoService;
  @ModelAttribute 
  EquipmentForm setUpForm() {
    return new EquipmentForm();
  }
  @GetMapping
  String list(Model model) {
    model.addAttribute("tokyo_table", tokyoService.findAll());
    return "equipment/list";
  }
  @PostMapping(path="create")
  String create(@Validated EquipmentForm form, BindingResult result , Model model) {
    if(result.hasErrors()) {
      return list(model);
    }
    tokyoService.create(form);
    return "redirect:/equipment";
  }

  @PostMapping(path = "edit", params = "form")
  String editForm(@RequestParam Integer machine_id, EquipmentForm form) {
    EquipmentForm equipmentForm = tokyoService.findOne(machine_id);
    BeanUtils.copyProperties(equipmentForm,  form);
    return "equipment/edit";
  }
  @PostMapping(path = "edit")
  String edit(@RequestParam Integer machine_id, @Validated EquipmentForm form,
                                                                                                                           BindingResult result) {
  if(result.hasErrors()) {
  return editForm(machine_id, form);
  }
  tokyoService.update(form);
  return "redirect:/equipment";
  }

  @PostMapping(path = "delete")
  String delete(@RequestParam Tokyo machine_id) {
    tokyoService.delete(machine_id);
    return "redirect:/equipment";
  }
  @PostMapping(path = "edit", params = "goToTop")
  String goToTop() {
    return "redirect:/equipment";
  }
  
  
}
