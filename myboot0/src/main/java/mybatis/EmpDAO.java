package mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmpDAO {	
	
	public List<EmpVO> emplist();

	public EmpVO empone(int id);
	
	public void empinsert(EmpVO vo);
	
	public void empupdate(EmpVO vo);
	
	public void empdelete(String name);
	
	public int cnt();
	
	public List<EmpVO> empdeptlist(int[] a);
	
	
}
