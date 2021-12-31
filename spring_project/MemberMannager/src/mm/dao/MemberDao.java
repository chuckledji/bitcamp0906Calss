package mm.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import mm.domain.Member;

public class MemberDao implements Dao {

	//ID
	private static int nextId = 0; 		
	
	//회원정보를 저장할 수 있는 공간을 만듦
	private Map<String, Member> map = new HashMap<String, Member>();
	
	@Override
	public void insert(Member member) {
		member.setId(nextId++);					//후위형으로(0부터시작하므로)
		map.put(member.getEmail(), member);
	}

	@Override
	public void update(Member member) {
		map.put(member.getEmail(), member);

	}

	@Override
	public Member selectByEmail(String email) {
		return map.get(email);
	}

	@Override
	public Collection<Member> selectAll() {
		return map.values();
	}

}
