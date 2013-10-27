package lab.sodino.jobs.db.data;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**所有数据的父类
 * @author Sodino E-mail:sodino@qq.com
 * @version Time：2013年10月1日 下午5:07:22
 */
public abstract class Esse {
	long _id = -1;
	
	public long get_id(){
		return _id;
	}
	
	public void set_id(long id){
		_id = id;
	}
	
	/**以类名为数据库表名。*/
	public String getTableName() {
		return getClass().getSimpleName();
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("_id=" + _id);
		//如果是子类的话，getClass()为子类名，非Esse 
		Class<?> cls = getClass();
		while(cls != Esse.class){
			Field[] fArr = cls.getDeclaredFields();
			if(fArr == null){
				break;
			}
			for(Field f : fArr){
				if(Modifier.isStatic(f.getModifiers())){
					continue;
				}
				if(f.isAccessible() == false){
					f.setAccessible(true);
				}
				String name = f.getName();
				try{
					Object value = f.get(this);
					sb.append(",");
					sb.append(name);
					sb.append("=");
					sb.append(value);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
