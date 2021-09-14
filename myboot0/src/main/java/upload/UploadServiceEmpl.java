package upload;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service3")
public class UploadServiceEmpl implements UploadService{

	@Autowired
	UploadDAO dao;
	
	@Override
	public void fileInsert(UploadVO vo) {
		dao.fileinsert(vo);
	}

	@Override
	public List<UploadVO> fileList(String name) {
		return dao.filelist(name);
	}
	
	
}
