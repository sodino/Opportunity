package lab.sodino.util.filesys;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author Sodino E-mail:sodino@qq.com
 * @version Time：2013年10月15日 下午2:41:53
 */
public class FileUtil {
	public static final int RESULT_SUCCESS = 0;
	public static final int RESULT_FILE_NOT_EXIST = 1;
	
	public static void read(LocalDataInfo info){
		if(info == null || info.reqAction != LocalDataInfo.ACTION_READ || info.reqPath == null || info.reqPath.length() == 0){
			return;
		}
		File reqFile = new File(info.reqPath);
		if(reqFile.exists() == false){
			info.result = RESULT_FILE_NOT_EXIST;
			return;
		}
		
		ByteArrayOutputStream baos = null;
		FileInputStream fis = null;
		byte[] tmpData = new byte[2048];
		int count = -1;
		try{
			baos = new ByteArrayOutputStream();
			fis = new FileInputStream(reqFile);
			while((count = fis.read(tmpData, 0, 2048)) >= 0){
				baos.write(tmpData, 0, count);
			}
			
			info.data = baos.toByteArray();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(baos != null){
					baos.close();
				}
				if(fis != null){
					fis.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
