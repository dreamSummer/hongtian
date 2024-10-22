package com.hotent.core.datahandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 更新数据监听器。
 * <pre>
 * &lt;bean id="updateDataListener" class="com.hotent.core.datahandler.UpdateDataListener">
 *  	&lt;property name="sqlMap">
 *			&lt;map>
 *				&lt;entry key="biaoming">
 *					&lt;list>
 *						&lt;value type="java.lang.String">
 *							UPDATE QINGJIA a  SET(username) =(SELECT b.fullname FROM sys_user b WHERE b.userid = a.userid) WHERE a.userid=?
 *						&lt;/value>
 *					&lt;/list>
 *				&lt;/entry>
 *			&lt;/map>
 *		&lt;/property>
 *	&lt;/bean>
 * </pre>
 * @author ray
 *
 */
public class UpdateDataListener implements ApplicationListener<UpdDataEvent> {
	
	@Resource(name="jdbcTemplate")
	JdbcTemplate jdbcTemplate;
	
	private Map<String,List<String>> sqlMap=new HashMap<String, List<String>>();

	@Override
	public void onApplicationEvent(UpdDataEvent event) {
		DataModel dataModel=(DataModel) event.getSource();
		String id=dataModel.getPk();
		String tableName=dataModel.getTableName().toLowerCase();
		List<String> sqlList=sqlMap.get(tableName);
		for(String sql:sqlList){
			jdbcTemplate.update(sql, id);
		}
	}
	
	/**
	 * 设置sqlmap，键为表名，值为sql列表。
	 * @param map
	 */
	public void setSqlMap(Map<String,List<String>> map){
		for(String key:map.keySet()){
			//转小写
			this.sqlMap.put(key.toLowerCase(), map.get(key));
		}
	}

}
