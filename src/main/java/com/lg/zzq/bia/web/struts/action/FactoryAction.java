package com.lg.zzq.bia.web.struts.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lg.zzq.bia.entity.Factory;
import com.lg.zzq.bia.entity.dao.FactoryDao;
import com.lg.zzq.bia.entity.dao.TextCodeDao;
import com.lg.zzq.bia.web.struts.BaseStruts2Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class FactoryAction extends BaseStruts2Action implements ModelDriven<Factory> {

	private Factory model = new Factory();

	public Factory getModel() {
		return model;
	}

	// 列表
	public String list() {
		FactoryDao oDao = (FactoryDao) this.getDao("daoFactory");
		List dataList = oDao.find("from Factory o");
		ActionContext.getContext().put("dataList", dataList);

		return "plist";
	}

	// 保存
	public String save() {
		FactoryDao oDao = (FactoryDao) this.getDao("daoFactory");
		if (model.getId() == null) {
			model.setState("1"); // 1:正常 0:停用
		}
		oDao.saveOrUpdate(model);

		return list();
	}

	// 转向新增页面
	public String toCreate() {
		TextCodeDao tDao = (TextCodeDao) this.getDao("daoTextDao");
		List ctypeList = tDao.find("from TextCode o where o.classCode = '0103'"); // 厂家分类
		ActionContext.getContext().put("ctypeList", ctypeList);

		return "pcreate";
	}

	// 转向修改页面
	public String toUpdate() {
		TextCodeDao tDao = (TextCodeDao) this.getDao("daoTextDao");
		List ctypeList = tDao.find("from TextCode o where o.classCode='0103'"); // 厂家分类
		ActionContext.getContext().put("ctypeList", ctypeList);

		FactoryDao oDao = (FactoryDao) this.getDao("daoFactory");
		Factory obj = (Factory) oDao.get(Factory.class, model.getId());
		ActionContext.getContext().getValueStack().push(obj);

		return "pupdate";
	}

	// 转向查看页面
	public String toView() {
		FactoryDao oDao = (FactoryDao) this.getDao("daoFactory");
		Factory obj = (Factory) oDao.get(Factory.class, model.getId());
		ActionContext.getContext().getValueStack().push(obj);

		return "pview";
	}

	// 批量删除
	public String delete() {
		String[] ids = model.getId().split(", ");
		FactoryDao oDao = (FactoryDao) this.getDao("daoFactory");
		oDao.deleteAllById(ids, Factory.class);

		return list();
	}

	// 改变状态
	private void state(String value) {
		String ids[] = model.getId().split(", ");
		FactoryDao oDao = (FactoryDao) this.getDao("daoFactory");
		Set oSet = new HashSet();
		for (int i = 0; i < ids.length; i++) {
			Factory obj = (Factory) oDao.get(Factory.class, ids[i]);
			obj.setState(value);
			oSet.add(obj);
		}

		oDao.saveOrUpdate(oSet); // 批量提交
	}

	// 启用
	public String start() {
		state("1");
		return list();
	}

	// 停用
	public String stop() {
		state("0");
		return list();
	}

}
