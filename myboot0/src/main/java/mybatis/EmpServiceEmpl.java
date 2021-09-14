package mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//main / mvc === service(1개 기능(여러개 sql 실행) 메소드) === dao(1개 sql 메소드)

@Service("service2")
public class EmpServiceEmpl implements EmpService{
	@Autowired
	EmpDAO dao;
	
	@Override
	public List<EmpVO> getEmpList() {
		// select count
		return dao.emplist();
	}

	@Override
	public EmpVO getEmpOne(int id) {
		return dao.empone(id);
	}

	@Override
	public void insertEmp(EmpVO vo) {
		EmpVO result = dao.empone(vo.getEmployee_id());
		if(result == null) {
			dao.empinsert(vo);
		}
	}

	@Override
	public void updateEmp(EmpVO vo) {
		dao.empupdate(vo);
		
	}

	@Override
	public void delete(String name) {
		dao.empdelete(name);
		
	}

	@Override
	public int countEmp() {
		return dao.cnt();
	}

	@Override
	public List<EmpVO> empDeptList(int[] a) {
		return dao.empdeptlist(a);
	}
	
	
	
	
}
