package mm.config;

import mm.dao.MemberDao;
import mm.service.ChangePasswordService;
import mm.service.MemberRegService;

@configuration
public class JavaConfigSub {

	@Autowired
	MemberDao memberDao;

	// ChangePasswordService : dao주입
	@Bean
	public ChangePasswordService changeService() {
		ChangePasswordService service = new ChangePasswordService();
		service.setDao(memberDao());
		return service;
	}
}
