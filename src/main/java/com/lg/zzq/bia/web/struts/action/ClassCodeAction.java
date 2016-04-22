package com.lg.zzq.bia.web.struts.action;

import java.util.List;

import com.lg.zzq.bia.entity.ClassCode;
import com.lg.zzq.bia.entity.dao.ClassCodeDao;
import com.lg.zzq.bia.web.struts.BaseStruts2Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author zzq_eason
 *
 */
public class ClassCodeAction extends BaseStruts2Action implements ModelDriven<ClassCode> {

	private ClassCode model = new ClassCode();
	
	public ClassCode getModel() {
		return model;
	}
	
	// 列表
	public String list() {
		// 从Spring容器中获取对象
		ClassCodeDao oDao = (ClassCodeDao) this.getDao("daoClassCode");
		List dataList = oDao.find("from ClassCode o");
		
		ActionContext.getContext().put("dataList", dataList);
		return "plist";
	}
	
	// 保存
	public String save() {
		ClassCodeDao oDao = (ClassCodeDao) this.getDao("daoClassCode");
		oDao.saveOrUpdate(model);
		
		return list();
	}

	// 删除
	public String delete() {
		ClassCodeDao oDao = (ClassCodeDao) this.getDao("daoClassCode");
		oDao.delete(model.getId(), ClassCode.class);
		
		return list();
	}
	
	// 转向新增页面
	public String toCreate() {
		return "pcreate";
	}
	
	// 转向修改页面
	public String toUpdate() {
		// 准备数据
		ClassCodeDao oDao = (ClassCodeDao) this.getDao("daoClassCode");
		ClassCode obj = (ClassCode) oDao.get(ClassCode.class, model.getId());
		ActionContext.getContext().getValueStack().push(obj);
		
		return "pupdate";
	}

}
