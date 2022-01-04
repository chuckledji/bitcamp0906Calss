package mm.config;

import mm.dao.MemberDao;
import mm.service.ChangePasswordService;
import mm.service.MemberRegService;

@configuration
public class JavaConfig {

	// MemberDao
	@Bean(name = "dao")
	@Scope(value = "Singleton")
	public MemberDao memberDao() {
		return MemberDao();
	}

	// MemberRegService : dao주입
	@Bean
	public MemberRegService regService() {
		return new MemberRegService(memberDao());
	}

	// ChangePasswordService : dao주입
	@Bean
	public ChangePasswordService changeService() {
		ChangePasswordService service = new ChangePasswordService();
		service.setDao(memberDao());
		return service;
	}
}
