package mediawiki;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.BlockUserPage;

public class BlockUserTest extends BaseTest {

	@Test
	public void blockUser() {
		BlockUserPage block = loginAsAdmin()
				.specialPages()
				.blockUser()
				.setUsername("User001")
				.ipBlock()
				.selectExpiry("indefinite")
				.block();
		
		assertTrue(block.getMessage().contains("User001 has been blocked."));
	}
	
}