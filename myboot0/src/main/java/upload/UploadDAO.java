package upload;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UploadDAO {

	public void fileinsert(UploadVO vo);
	
	public List<UploadVO> filelist(String name);
}
