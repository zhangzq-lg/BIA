package com.lg.zzq.bia.entity.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseRootDao extends HibernateDaoSupport {
	/** 打印日志  */
	private static Logger log = Logger.getLogger(BaseRootDao.class);
	
	/** 持久化删除方法 */
	public void delete(Object entity) {
		this.getHibernateTemplate().delete(entity);
	}
	
	/** 持久化删除全部指定的实体方法 */
	public void deleteAll(Collection entities) {
		this.getHibernateTemplate().deleteAll(entities);
	}
	
	/** 通过Id删除 */
	public void deleteAllById(String[] allId, Class entityClass) {
		Object obj = null;
		
		for(int i = 0; i < allId.length; i++) {
			obj = get(entityClass, allId[i]);
			getHibernateTemplate().delete(obj);
		}
	}
	
	/** 通过hql删除 */
	public int deleteByHql(String deleteHql) {
		return this.update(deleteHql);
	}
	
	/** 通过id删除 */
	public void delete(String id, Class entityClass) {
		Object obj = get(entityClass, id);
		getHibernateTemplate().delete(obj);
	}
	
	/** 通过带参数的hql删除 */
	public int delete(String deleteHql, Object[] objects) {
		 return this.update(deleteHql, objects);
	}
	
	/** 查询 */
	public List find(String queryString) {
		return this.getHibernateTemplate().find(queryString);
	}
	
	/** 查询 */
	public List find(String queryString, Object value) {
		return this.getHibernateTemplate().find(queryString, value);
	}
	
	/** 查询 */
	public List find(String queryString, Object[] values) {
		return this.getHibernateTemplate().find(queryString, values);
	}
	
	/** 迭代查询 */
	public Iterator iterate(String queryString) {
		return this.getHibernateTemplate().iterate(queryString);
	}
	
	/** 迭代查询 */
	public Iterator iterate(String queryString, Object value) {
		return this.getHibernateTemplate().iterate(queryString, value);
	}
	
	/** 迭代查询 */
	public Iterator iterate(String queryString, Object[] values) {
		return this.getHibernateTemplate().iterate(queryString, values);
	}
	
	/** 通过id获得单个实例 */
	public Object get(Class entityClass, Serializable id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}
	
	/** 查询、获取 */
	public Object get(Class entityClass, Serializable id, LockMode lockMode) {
		return this.getHibernateTemplate().get(entityClass, id, lockMode);
	}
	
	/** 查询指定所有id的数据 */
	public Set getByIds(Class entityClass, String[] allId) {
		Set entitySet = new HashSet();
		for(int i = 0; i < allId.length; i++) {
			entitySet.add(this.getHibernateTemplate().get(entityClass, allId[i]));
		}
		return entitySet;
	}
	
	/** 查询指定所有id的数据 */
	public Set getByIds(Class entityClass, Integer[] allId) {
		Set entitySet = new HashSet();
		for(int i = 0; i < allId.length; i++) {
			entitySet.add(this.getHibernateTemplate().get(entityClass, allId[i]));
		}
		return entitySet;
	}
	
	/** 加载*/
	public Object load(Class entityClass, Serializable id) {
		return this.getHibernateTemplate().load(entityClass, id);
	}
	
	/** 加载*/
	public List loadAll(Class entityClass) {
		return this.getHibernateTemplate().loadAll(entityClass);
	}
	
	/** 加载*/
	public void load(Object entity, Serializable id) {
		this.getHibernateTemplate().load(entity, id);
	}
	
	/** 保存*/
	public Serializable save(Object entity) {
		return this.getHibernateTemplate().save(entity);
	}
	
	/** 更新对象*/
	public void update(Object entity) {
		this.getHibernateTemplate().update(entity);
	}
	
	/** 通过hql更新 */
	public int update(String updateHql) {
		Session session = this.getSession();
		int resultInt = session.createQuery(updateHql).executeUpdate();
		return resultInt;
	}
	
	/** 通过hql更新 */
	public int update(String updateHql, Object[] objects) {
		Session session = this.getSession();
		Query updateQuery = session.createQuery(updateHql);
		if(objects != null) {
			for(int i = 0; i < objects.length; i++) {
				updateQuery.setParameter(i, objects[i]);
			}
		}
		return updateQuery.executeUpdate();
	}
	
	/** 保存或更新*/
	public void saveOrUpdate(Object entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}
	
	/** 保存或更新*/
	public void saveOrUpdateAll(Collection entities) {
		this.getHibernateTemplate().saveOrUpdateAll(entities);
	}
	
	/** 初始化*/
	public void initialize(Object proxy) {
		this.getHibernateTemplate().initialize(proxy);
	}
	
}
