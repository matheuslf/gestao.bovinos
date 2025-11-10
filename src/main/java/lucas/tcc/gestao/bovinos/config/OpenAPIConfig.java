package lucas.tcc.gestao.bovinos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Monitoramento de Bovinos")
                        .description("REST API para leitura e monitoramento de bovinos")
                        .version("v1.0"));
    }
}

