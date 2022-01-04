package mm.service;

import mm.dao.Dao;
import mm.dao.MemberDao;
import mm.domain.Member;
import mm.domain.RegRequest;
import mm.exception.DuplicateMemberException;

public class MemberRegService {

	// MemberDao dao = new MemberDao(); //의존상태

	private Dao dao; // Dao타입의 객체를 주입받는 방법 : (생성자, setter메소드 )사용하기

	// 디폴트생성자
	public MemberRegService() {
	}

	// 생성자사용
	public MemberRegService(Dao dao) {
		this.dao = dao;
	}

	// setter사용
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public void regMember(RegRequest request) throws DuplicateMemberException {
		// 이메일 중복체크
		Member member = dao.selectByEmail(request.getEmail());

		if (member != null) {
			throw new DuplicateMemberException("이미 존재하는 이메일입니다.");
		}
		dao.insert(request.toMember());
		System.out.println("등록되었습니다.");
	}
}
