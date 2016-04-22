package com.lg.zzq.bia.web.struts.action;

import java.util.List;

import com.lg.zzq.bia.entity.TextCode;
import com.lg.zzq.bia.entity.dao.ClassCodeDao;
import com.lg.zzq.bia.entity.dao.TextCodeDao;
import com.lg.zzq.bia.web.struts.BaseStruts2Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class TextCodeAction extends BaseStruts2Action implements ModelDriven<TextCode> {

	private TextCode model = new TextCode();

	public TextCode getModel() {
		return model;
	}

	// 列表
	public String list() {
		TextCodeDao oDao = (TextCodeDao) this.getDao("daoTextCode");
		List dataList = oDao.find("from TextCode o");
		ActionContext.getContext().put("dataList", dataList);

		return "plist";
	}

	// 保存
	public String save() {
		TextCodeDao oDao = (TextCodeDao) this.getDao("daoTextCode");
		oDao.saveOrUpdate(model);

		return list();
	}

	// 删除一条
	public String deleteOne() {
		TextCodeDao oDao = (TextCodeDao) this.getDao("daoTextCode");
		oDao.delete(model.getId(), TextCode.class);

		return list();
	}

	// 删除多条
	public String delete() {
		TextCodeDao oDao = (TextCodeDao) this.getDao("daoTextCode");
		String[] ids = model.getId().split(", ");
		oDao.deleteAllById(ids, TextCode.class);

		return list();
	}

	// 转向新增页面
	public String toCreate() {
		// 准备数据
		ClassCodeDao cDao = (ClassCodeDao) this.getDao("daoClassCode");
		List classCodeList = cDao.find("from ClassCode o");
		ActionContext.getContext().put("classCodeList", classCodeList);

		return "pcreate";
	}

	// 转向修改页面
	public String toUpdate() {
		// 准备数据
		ClassCodeDao cDao = (ClassCodeDao) this.getDao("daoClassCode");
		List classCodeList = cDao.find("from ClassCode o");
		ActionContext.getContext().put("classCodeList", classCodeList);

		return "pupdate";
	}

	// 转向查看页面
	public String toView() {
		TextCodeDao oDao = (TextCodeDao) this.getDao("daoTextCode");
		TextCode obj = (TextCode) oDao.get(TextCode.class, model.getId());
		ActionContext.getContext().getValueStack().push(obj);

		return "pview";
	}

}
