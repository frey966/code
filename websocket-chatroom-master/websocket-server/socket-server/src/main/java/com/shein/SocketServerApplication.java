package com.shein;

import com.shein.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocketServerApplication implements CommandLineRunner {


	@Autowired
	WebSocketServer webSocketServer;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SocketServerApplication.class, args);

	}

	@Override
	public void run(String... strings) throws Exception {
		webSocketServer.start();
	}
}
