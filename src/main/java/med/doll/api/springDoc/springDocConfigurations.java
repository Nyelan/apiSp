package med.doll.api.springDoc;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class springDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                        .info(new Info()
                            .title("Med Doll API")
                            .description("API Rest da aplicação Med Doll, contendo as funcionalidades de CRUD de médicos e de pacientes, além de agendamento e cancelamento de consultas.")
                            .contact(new Contact()
                                    .name("Leonardo Vaz")
                                    .email("leonardovazcimp@gmail.com"))
                        .license(new License()
                                .name("Meu portfólio")
                                .url("https://portfolioalura-orpin.vercel.app/")));
    }



}
