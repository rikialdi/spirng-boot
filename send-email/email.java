di blogger

<!--				//mail 1-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>

##============================================email 2
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=rikialdipari@gmail.com
spring.mail.password=alquranhadist96

# Other properties
spring.mail.properties.mail.smtp.auth=true
#spring.mail.properties.mail.smtp.connectiontimeout=5000
#spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000

# TLS , port 587
spring.mail.properties.mail.smtp.starttls.enable=true

# SSL, post 465
#spring.mail.properties.mail.smtp.socketFactory.port = 465
#spring.mail.properties.mail.smtp.socketFactory.class = javax.net.ssl.SSLSocketFactory

class

@Autowired
    private JavaMailSender sender;

 MimeMessage message = sender.createMimeMessage();

// Enable the multipart flag!
        MimeMessageHelper helper = new MimeMessageHelper(message,true);

        helper.setTo("rikialdipari96@gmail.com");
        helper.setText("How are you?");
        helper.setSubject("Hi2");

     ClassPathResource file = new ClassPathResource("a.png");
     helper.addAttachment("as.png", file); //bisa

        sender.send(message);
