package com.rit.gameserver;

import static org.assertj.core.api.Assertions.assertThat;
import com.rit.gameserver.api.GameController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameServerApplicationTests {

	@Autowired
	private GameController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
