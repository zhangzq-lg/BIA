package com.lg.zzq.bia.web.struts;

import com.lg.zzq.bia.web.common.db.AppContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseStruts2Action extends ActionSupport {

	// 获取dao对象
	public Object getDao(String dao) {
		return AppContext.getIntstance().getAppContext().getBean(dao);
	}

	// 统一查询
	public String f_conditionStr; // 用户输入的查询条件
	public String f_type; // 下拉框的值select
	public String comboContentStr; // 下拉框option值

	public String getF_conditionStr() {
		return f_conditionStr;
	}

	public void setF_conditionStr(String fConditionStr) {
		f_conditionStr = fConditionStr;
	}

	public String getF_type() {
		return f_type;
	}

	public void setF_type(String fType) {
		f_type = fType;
	}

	public String getComboContentStr() {
		return comboContentStr;
	}

	public void setComboContentStr(String comboContentStr) {
		this.comboContentStr = comboContentStr;
	}

}
