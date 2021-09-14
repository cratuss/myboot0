package upload;

import java.util.List;

public interface UploadService {
	public void fileInsert(UploadVO vo);
	public List<UploadVO> fileList(String name);
}
