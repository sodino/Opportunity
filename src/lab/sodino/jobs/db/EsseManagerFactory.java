package lab.sodino.jobs.db;

import android.database.sqlite.SQLiteOpenHelper;

/** 
 * @author Sodino E-mail:sodinoopen@hotmail.com 
 * @version Time：Nov 3, 2013 11:39:56 PM 
 */
public abstract class EsseManagerFactory {
	
	private boolean closed;
	private final SQLiteOpenHelper dbHelper;
	
	public EsseManagerFactory(String name){
		dbHelper = build(name);
	}
	
	public EsseManager createEsseManager(){
		if(closed){
			throw new IllegalStateException("EsseManagerFactory can't create esse manager,it was closed!");
		}
		EsseManager em = new EsseManagerImp();
		closed = false;
		return em;
	}
	
	public abstract SQLiteOpenHelper build(String name);
}
