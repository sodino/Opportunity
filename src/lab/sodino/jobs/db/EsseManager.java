package lab.sodino.jobs.db;

import android.database.sqlite.SQLiteOpenHelper;
import lab.sodino.jobs.db.data.Esse;

/** 
 * @author Sodino E-mail:sodinoopen@hotmail.com 
 * @version Time：Nov 3, 2013 10:22:57 PM 
 */
public class EsseManager{
	public EsseManager(SQLiteOpenHelper helper){
		
	}
	public boolean update(Esse e) {
		return false;
	}

	public boolean delete(Esse e) {
		return false;
	}

	public Esse find(Class<? extends Esse> cls) {
		return null;
	}

	public boolean drop(Class<? extends Esse> clz) {
		return false;
	}

	public boolean drop(String table) {
		return false;
	}

}
