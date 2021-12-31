package mm.assembler;

import mm.dao.MemberDao;
import mm.service.ChangePasswordService;
import mm.service.MemberRegService;

public class Assembler {

	//조립기
	
	//객체를 관리 : 객체를 생성(의존도 설정), 보관, 제공
	
	private MemberDao dao;
	private MemberRegService regService;
	private ChangePasswordService passwordService;
	
	//객체 생성
	public Assembler() {
		dao = new MemberDao();
		regService = new MemberRegService();
		regService.setDao(dao);
		passwordService = new ChangePasswordService(dao);
	}
	
	//객체 제공
	public MemberDao getDao() {
		return dao;
	}
	
	public MemberRegService getRegService() {
		return regService;
	}
	
	public ChangePasswordService getPasswordService() {
		return passwordService;
	}
	
}
