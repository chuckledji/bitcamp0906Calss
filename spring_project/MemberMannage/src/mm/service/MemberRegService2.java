package mm.service;

import mm.dao.Dao;
import mm.dao.MemberDao;
import mm.domain.Member;
import mm.domain.RegRequest;
import mm.exception.DuplicateMemberException;

public class MemberRegService2 {

	// @Autowired
	@Resource(name = "guestDao")
	private Dao dao; // 컴포넌트가 이걸읽고 dao = new MemberDao()를 해준다는 것
						// Dao타입의 bean을 자동주입

	// 디폴트생성자
	public MemberRegService2() {
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
