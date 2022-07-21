package jp.te4a.spring.boot.myapp13.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.myapp13.bean.Tokyo;
import jp.te4a.spring.boot.myapp13.form.EquipmentForm;
import jp.te4a.spring.boot.myapp13.repository.TokyoEquipmentRepository;
@Service
public class TokyoEquipmentService {
  @Autowired
  TokyoEquipmentRepository tokyoRepository;
  public EquipmentForm create(EquipmentForm equipmentForm) {
	  Tokyo tokyo = new Tokyo();
	  BeanUtils.copyProperties(equipmentForm, tokyo);
	  tokyoRepository.save(tokyo);
	  return equipmentForm;
  }
  public EquipmentForm update(EquipmentForm equipmentForm) {
	  	Tokyo tokyo = new Tokyo();
	  	BeanUtils.copyProperties(equipmentForm, tokyo);
	  	tokyoRepository.save(tokyo);
	  	return equipmentForm;
	  }
	  public void delete(Tokyo machine_id) {  tokyoRepository.delete(machine_id); }
	  public List<EquipmentForm> findAll() {
	    List<Tokyo> beanList = tokyoRepository.findAll();
	    List<EquipmentForm> formList = new ArrayList<EquipmentForm>();
	    for(Tokyo tokyo: beanList) {
	      EquipmentForm equipmentForm = new EquipmentForm();
	      BeanUtils.copyProperties(tokyo, equipmentForm);
	      formList.add(equipmentForm);
	    }
	    return formList;
	    }
	  public EquipmentForm findOne(Integer machine_id) {
	    Optional<Tokyo> tokyo = tokyoRepository.findById(machine_id);
	    EquipmentForm equipmentForm = new EquipmentForm();
	    BeanUtils.copyProperties(tokyo, equipmentForm);
	    return equipmentForm;
	  }
	}
